<%-- 
    Document   : agregarHabitacion
    Created on : 29-05-2018, 17:55:42
    Author     : 420NiggaBytes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <form action="agregarHabitacion" method="post">
            <SELECT NAME="tipo_cama">
                <OPTION VALUE="Individual">Individual</OPTION>
                <OPTION VALUE="Doble Cama">Doble Cama</OPTION>
                <OPTION VALUE="Tiple Cama">Tiple Cama</OPTION>
                <OPTION VALUE="Doble Camarote">Doble Camarote</OPTION>             
            </SELECT>
            <input type="text" name="accesorios">
            <input type="number" name="precio" min="0">
            <input type="text" name="descripcion">  
            <input type="text" name="nombre">
           <SELECT NAME="estado">
                <OPTION VALUE="1">Disponible</OPTION>
                <OPTION VALUE="2">Ocupada</OPTION>                   
            </SELECT>
            <input type="number" name="capacidad" min="0">
            <input type="submit">
    </form>


    <%            } else {
            response.getWriter().print("Por Favor Inicie Sesion.");
            response.sendRedirect("index.jsp");
        }
    %>
</body>
</html>
