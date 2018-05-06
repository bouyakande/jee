<%-- 
    Document   : addProduit
    Created on : 15 avr. 2018, 13:13:26
    Author     : ghost
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="panel panel-primary">
            <div class="panel panel-heading">Produit
                <div class="panel panel-body">
                    
                    <form action="/CoursJEE/addProduit" method="POST" enctype="multipart/form-data">
                        <div> <br>
                            <label> Designation </label>
                            <input type="text" class="form-control" name="design" />
                            <input type="hidden" name="action" value="addproduit"/>
                            <label>  prix </label>
                            <input type="text" class="form-control" name="prix"/> 
                        </div>
                    <div> <br>
                            <img src="" id="image" />
                            <label> Photo <span class="requis">*</span> </label>
                            <input type="file" class="form-control" name="photo" id="photo"/> 
                            <label>  categorie </label>
                            <select id="cat" name="cat"> <option>Choisir une categorie </option>
                                <c:forEach items="${listCategorie}" var="cat">
                                    <option value="${cat.id}">${cat.nom}</option>
                                </c:forEach>
                            </select>
                        </div><br>

                        <input type="submit" value="valider" class="btn btn-primary">
                    </form>
                    
                    <table border="1">
                        <thead>
                            <tr>

                                <th>Nom produit</th>
                                <th>Prix</th>
                                <th>Photo</th>
                                <th>Categorie</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listProduit}" var="produit">
                                <tr>
                                    <td>${produit.designation}</td>
                                    <td>${produit.pu}</td>
                                    
                                    <td><img src="data:image/jpeg;base64,${produit.encodedImg}" style="width:60px;height:60px;"/></td>
                                    <td>${produit.categorie.nom}</td>
                                   
                                </tr>
                            </c:forEach>


                        </tbody>
                    </table>

                </div>
            </div>
            <script src="${pageContext.request.contextPath}/Js/jquery-3.2.1.min.js" type="text/javascript"></script>
            <script type="text/javascript">
                $(document).ready(function () {
                    function imageIsLoaded(e) {
                        //$("#file").css("color","green");
                        //$('#image_preview').css("display", "block");
                        $('#image').attr('src', e.target.result);
                        $('#image').attr('width', '300px');
                        $('#image').attr('height', '300px');
                    }
                    ;
                    $('#photo').change(function () {
                        //alert('ok');
                        var assetsBaseDir = "${pageContext.request.contextPath}/logo.png";
                        var file = this.files[0];

                        var imagefile = file.type;
                        //alert(imagefile);
                        var match = ["image/jpeg", "image/png", "image/jpg"];
                        if (!((imagefile == match[0]) || (imagefile == match[1]) || (imagefile == match[2])))
                        {
                            //alert('no match');
                            $('#image').attr('src', assetsBaseDir + 'default.jpeg');
                            $("#message").html("Selectionner une image valide, Note : Seules jpeg, jpg and png Images sont autorisé");
                            return false;
                        } else
                        {
                            //alert('match');
                            var reader = new FileReader();
                            reader.onload = imageIsLoaded;
                            reader.readAsDataURL(this.files[0]);
                        } 
                    });
                });
            </script>
    </body>
</html>
