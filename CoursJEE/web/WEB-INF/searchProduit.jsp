<%-- 
    Document   : searchProduit
    Created on : 30 avr. 2018, 19:56:11
    Author     : ghost
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/addProduit" method="POST" enctype="multipart/form-data">
            <div> <br>
                <label> Designation </label>
                 <input type="hidden" name="action" value="searchproduit"/>
                <input type="text" class="form-control" required name="designation" /> 
                <input type="submit" value="rechercher"/>
                
            </div>
        </form>
            ${produit.pu}
    </body>
</html>
