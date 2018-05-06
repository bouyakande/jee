<%-- 
    Document   : AddCategorie
    Created on : 10 avr. 2018, 02:03:48
    Author     : ghost
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <title>Ajout Categorie</title>
    </head>
    <body>
        <div class="panel panel-primary">
            <div class="panel panel-heading">Categorie
                <div class="panel panel-body">
                     <form action="/CoursJEE/addCat" method="POST">
                         <label>  Numero categorie </label>
                         <input type="text" class="form-control" name="numcat"/> 
                          <label>  Nom categorie </label>
                         <input type="text" class="form-control" name="nomcat"/> 
                         <input type="submit" value="valider" class="btn btn-primary">
                     </form>
                </div>
            </div>
            
        </div>
            
        
       
    </body>
</html>
