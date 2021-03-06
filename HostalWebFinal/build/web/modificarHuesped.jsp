<%-- 
    Document   : agregarHabitacion
    Created on : 29-05-2018, 17:55:42
    Author     : 420NiggaBytes
--%>

<%@page import="modelo.Huesped"%>
<%@page import="dao.HuespedDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Empresa</title>
        <script src="js/validaciones_huesped_M.js" type="text/javascript"></script>
        <link href="css/formularios_huesped.css" rel="stylesheet" type="text/css"/>
        <%
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Expires", "0");
            response.setDateHeader("Expires", -1);
        %> 
        <%
            if (session.getAttribute("user") != null) {

        %>

       
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
            HuespedDAO daoco = new HuespedDAO();
            Huesped con = new Huesped();
            con = daoco.getHuespedPorId(Integer.parseInt(id));              
        %>
        
         <div class="login-page">
         <div class="form">
             <h4 align="center">Formulario Huesped</h4><br>
        <form id="agregar_huesped" action="modificarHuesped" method="post" class="login-form">
            <input type="hidden" name="idhuesped" value="<%=con.getId_huesped()%>">
            <input type="hidden" name="idempresa" value="<%=con.getId_empresa()%>">
            <label>Rut Huesped:</label><br>
            <input type="text" value=" <%=con.getRut()+"-"+con.getDv()%>" disabled><br>
            <label>Nombre Huesped: </label><br>             
            <input type="text" name="nombre_huesped" id="nombre" value="<%=con.getNombre()%>"><br>
            <label>Apellido Huesped: </label>
            <input type="text" name="apellido_huesped" id="apellido" value="<%=con.getApellido()%>"><br> 
            <label>Cargo: </label>            
            <SELECT NAME="cargo" id='cargo'>
                <option value="0" disabled selected>Seleccionar</option>
                <OPTION VALUE="1" >Gerente</OPTION> 
                <OPTION VALUE="2" >Sub Gerente</OPTION> 
                <OPTION VALUE="3" >Jefe</OPTION>               
                <OPTION VALUE="4">Supervisor</OPTION>
                <OPTION VALUE="5">Ejecutivo</OPTION> 
                <OPTION VALUE="6" >Contador</OPTION> 
                <OPTION VALUE="7" >RRHH</OPTION>               
                <OPTION VALUE="8">Analista QA</OPTION> 
                <OPTION VALUE="9">Programador</OPTION> 
                <OPTION VALUE="10">Ingeniero</OPTION> 
            </SELECT><br>
            <label>Email: </label>
            <input type="text" name="correo" id="correo" value="<%=con.getCorreo()%>"><br>
            <label>Telefono: </label>
            <input type="text" name="telefono" id="telefono" value="<%=con.getNumero_tefono()%>" maxlength="8"><br>
            <label>Estado del huesped:</label><br>
            <SELECT NAME="id_estado_huesped" id='estado'>
                <option value="0" disabled selected>Seleccionar</option>
                <OPTION VALUE="1">Hospedado</OPTION> 
                <OPTION VALUE="2">Check Out</OPTION> 
                <OPTION VALUE="3">No Pertenece a la empresa</OPTION>
            </SELECT><br><br>
             <input type="button" id="btn_enviar" value="Enviar" onclick="validarForm()">
            <p class="message"><a href="listaHuesped.jsp">Volver</a></p><br><br>
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
