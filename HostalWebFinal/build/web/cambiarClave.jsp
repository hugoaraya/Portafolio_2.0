<%-- 
    Document   : agregarHabitacion
    Created on : 29-05-2018, 17:55:42
    Author     : 420NiggaBytes
--%>

<%@page import="modelo.Empresa"%>
<%@page import="dao.EmpresaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Empresa</title>
        <script src="js/validar_pass_1.js" type="text/javascript"></script>
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
               String rut = session.getAttribute("user").toString();
            
            EmpresaDAO dao2 = new EmpresaDAO();
            ArrayList<Empresa> dCon = dao2.listaEmpresa(rut);            
            for (Empresa temp : dCon) {
                        
        %>
        
         <div class="login-page">
         <div class="form">
             <h4 align="center">Cambiar Clave</h4><br>
        <form id="cambiar_clave" action="cambiarClave" method="post" class="login-form">           
            <input type="hidden" name="usuario_id" value="<%=temp.getUsuario_id()%>">      
            <input type="password" name="clave" id="pass" placeholder="Nueva Contraseña"><br> 
             <input type="password" id="repass" placeholder="Repetir Contraseña"><br> 
             <input type="button" id="btn_enviar" value="Enviar" onclick="validarForm()">
            <p class="message"><a href="indexEmpresa.jsp">Volver</a></p><br><br>
          <span id="error" ></span>
          
        </form>
  </div>
         </div>   

    <%       }  } else {
            response.getWriter().print("Por Favor Inicie Sesion.");
            response.sendRedirect("index.jsp");
        }
    %>
</body>
</html>
