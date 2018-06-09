
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/validaciones_comedor_1.js" type="text/javascript"></script>
         <link href="css/formulariosVarios.css" rel="stylesheet" type="text/css"/>
   
        <title>Perfil Administrador</title>
        <%
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Expires", "0");
            response.setDateHeader("Expires", -1);
        %> 
        <%
            if (session.getAttribute("user") != null) {

        %>

        <SCRIPT type="text/javascript">
            window.history.forward();
            function noBack() {
                window.history.forward();
            }
        </SCRIPT>
    </head>
    <body>
        
        <%             HttpSession sesion = request.getSession();
            String usuario;
            String nivel;

            if (sesion.getAttribute("user") != null && sesion.getAttribute("nivel") != null) {
                usuario = sesion.getAttribute("user").toString();
                nivel = sesion.getAttribute("nivel").toString();
            } else {
                out.print("<script>location.replace('index.jsp');</script>");
            }

        %>
         
        <div class="login-page">
          
         <div class="form">
             <h4 align="center">Formulario Platos</h4>
        <form id="agregar_comedor" action="nuevoPlato" method="post" class="login-form">
            <input type="text" name="nombre_plato" id="nombre" placeholder="Nombre Plato"><br>
               
            <input type="button" id="btn_enviar" value="Enviar" onclick="validarForm()">
            <p class="message"><a href="listaComedor.jsp">Volver</a></p><br><br>
          <span id="error" ></span>
        </form>
             
              
</div>
</div>

    <%            } else {
            response.getWriter().print("Por Favor Inicie Sesion.");
            response.sendRedirect("index.jsp");
        }
    %>
    
    <script>
       
        
    </script>
</body>
</html>
