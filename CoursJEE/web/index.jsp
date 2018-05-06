<%-- 
    Document   : index
    Created on : Mar 19, 2018, 6:52:22 PM
    Author     : ucer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><center>Authentification</center></h1>
        <form method="post" action="/CoursJEE/user">
        <label> Login </label>  <input type="text" name="login" placeholder="Entrer votre login"><br>
        <label> Password </label>  <input type="password" name="password" placeholder="Entrer votre login"><br>
        <input type="submit" name="connect" value="Connexion">
        <%
            //out.println(request.getAttribute("error"));
        %>
        ${error}
        
    </body>        </form>

</html>
