<%-- 
    Document   : indexAdmin
    Created on : 15-05-2018, 14:12:58
    Author     : 420NiggaBytes
--%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
         <link rel="stylesheet" type="text/css" href="css/stylesheet_a.css"> 
        
        <% 
        response.setHeader("Pragma","no-cache"); 
        response.setHeader("Cache-Control","no-store"); 
        response.setHeader("Expires","0"); 
        response.setDateHeader("Expires",-1); 
        %> 
        <%
            if (session.getAttribute("user") != null) {
                
        %>
       
        <SCRIPT type="text/javascript">
            window.history.forward();
            function noBack() { window.history.forward(); }
        </SCRIPT>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            String usuario;
            String nivel;
            
            if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){
                usuario = sesion.getAttribute("user").toString();
                nivel = sesion.getAttribute("nivel").toString();
            }else{
                out.print("<script>location.replace('index.jsp');</script>");
            }
        
        %>
       
        
        <div class="wrapper">
            <div class="container">
                <div class="img-container">
                    <img src="img/admin.png" alt="">
                </div>
                <div class="content">
                    <div class="head">
                        <p>Administrador </p>
                        <span>Hostal Doña Clarita</span>
                    </div>
                    <br> 
                    <a href='listaHabitaciones.jsp' title="Mantenedor Habitaciones" class="link">Mantenedor Habitaciones</a><br>
                    <a href='listaComedor.jsp' title="Mantenedor Comedor" class="link">Mantenedor Comedor</a> 
                </div>

                <div class="floating-icon">
                    <a class="x" title="Cerrar Sesión" href='SvLogOut'>X</a>
                </div>
            </div>
        </div>
          <%
                
            } else {
                response.getWriter().print("Por Favor Inicie Sesion.");                    
                response.sendRedirect("index.jsp");
            }
        %>

    </body>
</html>
