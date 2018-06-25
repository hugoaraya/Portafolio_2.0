<%-- 
    Document   : agregarHabitacion
    Created on : 29-05-2018, 17:55:42
    Author     : 420NiggaBytes
--%>

<%@page import="modelo.Empresa"%>
<%@page import="dao.EmpresaDAO"%>
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
        <script src="js/validaciones_huesped_A_1.js" type="text/javascript"></script>
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
                   String rut = session.getAttribute("user").toString();
            
           EmpresaDAO dao2 = new EmpresaDAO();
            ArrayList<Empresa> dCon = dao2.listaEmpresa(rut);            
            for (Empresa temp : dCon) {
                        
        %>
        
         <div class="login-page">
         <div class="form">
             <h4 align="center">Formulario Huesped</h4><br>
        <form id="agregar_huesped" action="agregarHuesped" method="post" class="login-form">           
            <input type="hidden" name="empresa_id" value="<%=temp.getIdEmpresa()%>">           
            <input type="text" style="width:77%;" name="rut" placeholder="Rut Empleado" maxlength="10" id="rut"> - <input style="width:18%;" type="text" name="dv" placeholder="DV" class="dv" maxlength="1" id="dv"><br>              
            <input type="text" name="nombre_huesped" id="nombre" placeholder="Nombre Empleado"><br>            
            <input type="text" name="apellido_huesped" id="apellido" placeholder="Apellido Empleado"><br>           
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
            <input type="text" name="correo" id="correo" placeholder="Correo Empleado" ><br>
            <input type="text" name="telefono" id="telefono" placeholder="Telefono Empleado" maxlength="8"><br>
            <p class="message">Estado del huesped:</p><br>
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

    <%        }  } else {
            response.getWriter().print("Por Favor Inicie Sesion.");
            response.sendRedirect("index.jsp");
        }
    %>
</body>
</html>
