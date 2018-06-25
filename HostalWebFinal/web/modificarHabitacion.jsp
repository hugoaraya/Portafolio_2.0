<%-- 
    Document   : agregarHabitacion
    Created on : 29-05-2018, 17:55:42
    Author     : 420NiggaBytes
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Habitacion"%>
<%@page import="dao.HabitacionesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Administrador</title>
        <script src="js/validaciones_1.js" type="text/javascript"></script>
         <link href="css/formulariosVarios.css" rel="stylesheet" type="text/css"/>
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
                   
            
           
               String id = request.getParameter("id");
               HabitacionesDAO daoco = new HabitacionesDAO();
            Habitacion con = new Habitacion();
            con = daoco.getHabitacionPorId(Integer.parseInt(id));

        %>
        
         <div class="login-page">
         <div class="form">
             <h4 align="center">Formulario Habitación</h4>
        <form id="agregar_habitacion_form"  action="actualizarHabitacion" method="post" class="login-form">
            <input type="hidden" name="id_habitacion" value="<%=con.getId_habitacion()%>">   
            <label>Nombre Habitacion:</label><br>
                <input type="text" name="nombre" id="nombre" value="<%=con.getNombre_habitacion()%>"><br>
                <label>Tipo de cama:</label><br>
            <SELECT NAME="tipo_cama">
                <OPTION VALUE="Individual" selected>Individual</OPTION>
                <OPTION VALUE="Doble Cama">Doble Cama</OPTION>
                <OPTION VALUE="Tiple Cama">Tiple Cama</OPTION>
                <OPTION VALUE="Doble Camarote">Doble Camarote</OPTION>             
            </SELECT><br>
            <label>Accesorios:</label><br>
            <input type="text" name="accesorios" id="accesorios" value="<%=con.getAccesorios()%>"><br>
            <label>Precio:</label><br>
            <input type="text" name="precio" id="precio" value="<%=con.getPrecio_habitacion()%>"><br>
            <label>Capacidad:</label><br>
            <SELECT NAME="capacidad">
                <OPTION VALUE="1" selected>1 Huesped</OPTION>
                <OPTION VALUE="2">2 Huesped</OPTION>
                <OPTION VALUE="3">3 Huesped</OPTION>
                <OPTION VALUE="4">4 Huesped</OPTION>             
            </SELECT><br>  
            <label>Estado de la Habitacion:</label><br>
           <SELECT NAME="estado">
                <OPTION VALUE="1">Disponible.</OPTION>
                <OPTION VALUE="3">No disponible por mantención.</OPTION>                   
            </SELECT><br>
            <label>Descripcion de Habitacion:</label><br>
            <textarea name="descripcion" id="descripcion"><%=con.getDescripcion()%></textarea>  
           <br><br>
            <input type="button" id="btn_enviar" value="Enviar" onclick="validarForm()">  
           <p class="message"><a href="listaHabitaciones.jsp">Volver</a></p><br><br>
          <span id="error" ></span>
 </form>
</div>
</div>

    <%          } else {
            response.getWriter().print("Por Favor Inicie Sesion.");
            response.sendRedirect("index.jsp");
        }
    %>
</body>
</html>
