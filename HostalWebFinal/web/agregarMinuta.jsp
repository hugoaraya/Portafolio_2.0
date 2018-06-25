
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/validaciones_minuta.js" type="text/javascript"></script>
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
            
          LocalDate localDate = LocalDate.now();       
        %>
         <div class="login-page">
         <div class="form">
             <h4 align="center">Formulario Minuta</h4><br>
        <form id="agregar_minuta" action="nuevaMinuta" method="post" class="login-form">
            <input type="text" name="nombre_minuta" id="nombre" placeholder="Nombre Minuta"><br>
            <p class="message">Fecha Inicio</p>
            <input type="date" name="fecha_inicio" id="fechaInicio" min="<%=localDate%>" ><br>
            <p class="message">Fecha Fin</p>
            <input type="date" name="fecha_fin" id="fechaFin" min="<%=localDate%>"><br><br>
             <input type="button" id="btn_enviar" value="Enviar" onclick="validarForm()">
            <p class="message"><a href="listaMinuta.jsp">Volver</a></p><br><br>
          <span id="error" ></span>
        </form>
         </div>
         </div>      

    <%            } else {
            response.getWriter().print("Por Favor Inicie Sesion.");
            response.sendRedirect("index.jsp");
        }
    %>
</body>
</html>
