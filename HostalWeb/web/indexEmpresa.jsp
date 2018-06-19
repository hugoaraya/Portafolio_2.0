<%-- 
    Document   : indexEmpresa
    Created on : 15-05-2018, 15:03:27
    Author     : 420NiggaBytes
--%>
<%@page import="modelo.Empresa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.EmpresaDAO"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Empresa</title>       
        <link rel="stylesheet" type="text/css" href="css/stylesheet_e_1.css"> 
        <%
          response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
          response.setHeader("Pragma","no-cache");
          response.setHeader("Expires","0");        
        %>
        <%
            if (session.getAttribute("user") != null) {
                
        %>
    </head>
    <body>
        <%           
            HttpSession sesion = request.getSession();
            String usuario;
            String nivel;
            
            if (sesion.getAttribute("user") != null && sesion.getAttribute("nivel") != null) {
                usuario = sesion.getAttribute("user").toString();
                nivel = sesion.getAttribute("nivel").toString();
                
            } else {
                out.print("<script>location.replace('login.jsp');</script>");
            }
            
        %>

        <%  String rut = session.getAttribute("user").toString();
            
            EmpresaDAO dao2 = new EmpresaDAO();
            ArrayList<Empresa> dCon = dao2.listaEmpresa(rut);            
            for (Empresa temp : dCon) {
        %>                 
        <div class="wrapper">
            <div class="container">
                <div class="img-container">
                    <img src="img/empresa_icono.png" alt="">
                </div>
                <div class="content">
                    <div class="head">
                        <p><%= temp.getNombre()%> </p>
                        <span><%= temp.getRut() + "-" + temp.getDv()%> </span>
                    </div>
                    <div class="data">
                        <div class="inner-data">
                            <p>Dirección</p>
                            <span><%= temp.getDireccion()%>  </span>
                        </div>
                        <div class="inner-data">
                            <p>Contacto</p>
                            <span><%= "+562"+temp.getTelefono()+" "+temp.getCorreo()%></span>
                        </div> 
                    </div>  
                    <br> 
                    <br>
                   &nbsp;&nbsp;&nbsp;&nbsp;<a href='formulario_orden_compra_1.jsp' title="Pedir Habitación" class="link"><img src="img/pedir_habitacion.png" alt="Pedir Habitacion" width="40" height="40" border="0"></a> &nbsp;&nbsp;&nbsp;
                    &nbsp;<a href='ordenes_compra.jsp' title="Ver Ordenes De Compra" class="link"><img src="img/o_compra.png" alt="Ordenes Compra" width="40" height="40" border="0"></a>
                    &nbsp;&nbsp;&nbsp;<a href="listaHuesped.jsp" title="Ver Huespedes"><img src="img/huesped.png" alt="Pedir Habitacion" width="40" height="40" border="0"></a>&nbsp;&nbsp;&nbsp;
                    <a href='cambiarClave.jsp'title="Cambiar Clave" class="link"><img src="img/cambiarpass.png" alt="Cambiar Clave" width="40" height="40" border="0"></a>  
                    &nbsp;&nbsp;&nbsp;<a href='index_p.jsp'title="Ir A Inicio" class="link"><img src="img/inicio_p.png" alt="Inicio" width="40" height="40" border="0"></a>

                </div>

                <div class="floating-icon">
                    <a class="x" title="Cerrar Sesión" href='SvLogOut'>X</a>
                </div>
            </div>
        </div>


        <%
                }
                
            } else {
                response.getWriter().print("Por Favor Inicie Sesion.");                    
                response.sendRedirect("index.jsp");
            }
        %>


    </body>
</html>
