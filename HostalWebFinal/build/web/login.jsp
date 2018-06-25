<%--
    Document   : index
    Created on : 14-05-2018, 13:01:17
    Author     : 420NiggaBytes
--%>

<%@page import="dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In</title>
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
          response.setHeader("Pragma","no-cache");
          response.setHeader("Expires","0");        
        %>
    </head>
    <BODY>
        <div class="login-box">
            <img src="img/avatar.png" class="avatar">
             <div class="floating-icon">
                    <a class="x"  title="Volver a Inicio" href='index.jsp'>X</a>
              </div>
            <h1>Login</h1>        
            <form action="SvLogin" method="POST">
                <p>Rut</p>
                <input type="text" name="username" placeholder="Rut Sin Verificador." required>
                <p>Contraseña</p>
                <input type="password" name="password" placeholder="Contraseña" required>
                <input type="submit" name="submit" value="Login">  
            </form>
            <%
                
             
                if(request.getParameter("error") != null){
                    int error = Integer.parseInt(request.getParameter("error"));
             if(error == 1){
                 %>
                 <p>Usuario  o contraseña incorrecta.</p>
                 <%
            }
}
            %>    
                
        </div>

    </body>
</html>
