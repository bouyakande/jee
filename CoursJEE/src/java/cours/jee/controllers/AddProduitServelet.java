/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours.jee.controllers;

import Entities.Categorie;
import Entities.Produit;
import Service.CategorieFacadeLocal;
import Service.ProduitFacadeLocal;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.function.Predicate;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ghost
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
@WebServlet(name = "AddProduitServelet", urlPatterns = {"/addProduit"})
public class AddProduitServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @EJB
    private ProduitFacadeLocal ProduitEJB;
    @EJB
    private CategorieFacadeLocal CategEJB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "addproduit":
                List<Categorie> Listecat = CategEJB.findAll();
                List<Produit> ListeProd = ProduitEJB.findAll();
                System.out.println(Listecat.size());
                request.setAttribute("listCategorie", Listecat);
                request.setAttribute("listProduit", ListeProd);
                getServletContext().getRequestDispatcher("/WEB-INF/addProduit.jsp").forward(request, response);
                break;
            case "searchproduit":
                getServletContext().getRequestDispatcher("/WEB-INF/searchProduit.jsp").forward(request, response);
                break;

        }

    }
    final String lien = "/home/ghost/Bureau/CoursJEE/web/Images/";

    /**
     * Handles the HTTP <codte>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");

        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        switch (action) {
            case "addproduit":
                Produit prod = new Produit();
                prod.setDesignation(request.getParameter("design"));
                prod.setPu(Integer.parseInt(request.getParameter("prix")));
                prod.setCategorie(CategEJB.find(Integer.parseInt(request.getParameter("cat"))));
                Part part = request.getPart("photo");
                // String path = "/Images/logo.png";
                //String url = getServletContext().getRealPath(path);
                String fileName = getFileName(part);
                File f = new File(lien + fileName);

                OutputStream out = new FileOutputStream(f);
                System.out.println(lien);

                InputStream stream = part.getInputStream();

                final byte[] bytes = new byte[1024];
                int read = 0;
                ByteArrayOutputStream b = new ByteArrayOutputStream();
                while ((read = stream.read(bytes)) != -1) {
                    b.write(bytes, 0, read);

                }
                b.flush();

                prod.setPhoto(b.toByteArray());
                try {
                    ProduitEJB.create(prod);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "searchproduit":
                Predicate<Produit> pre=(x)->x.getPu()==Integer.parseInt(request.getParameter("designation"));
                Produit Prod=ProduitEJB.findProd(pre);
                request.setAttribute("produit", Prod);
                getServletContext().getRequestDispatcher("/WEB-INF/searchProduit.jsp").forward(request, response);
                break;

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
