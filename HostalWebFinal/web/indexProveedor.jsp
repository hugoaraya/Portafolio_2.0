<%-- 
    Document   : indexProveedor
    Created on : 15-05-2018, 14:13:07
    Author     : 420NiggaBytes
--%>
<%@page import="modelo.Proveedor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProveedorDAO"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Proveedor</title>       
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css"> 
        <%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
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
            
            ProveedorDAO dao2 = new ProveedorDAO();
            ArrayList<Proveedor> dCon = dao2.listaProveedor(rut);
            int i = 0;
            for (Proveedor temp : dCon) {
        %>                 
        <div class="wrapper">
            <div class="container">
                <div class="img-container">
                    <img src="img/proveedor.png" alt="">
                </div>
                <div class="content">
                    <div class="head">
                        <p><%= temp.getNombre()%> </p>
                        <span><%= temp.getRut() + "-" + temp.getDv()%> </span>
                    </div>
                    <div class="data">
                        <div class="inner-data">
                            <p>Dirección</p>
                            <span><%= temp.getDireccion() + temp.getIdProveedor()%>  </span>
                        </div>
                        <div class="inner-data">
                            <p>Rubro</p>
                            <span><%= temp.getRubro()%></span>
                        </div> 
                    </div>  
                    <br> 
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='ordenes_pedido.jsp' title="Ver Ordenes Pedido" class="link"><img src="img/IconoOrdenCompra.png" alt="Ordenes Pedido" width="40" height="40" border="0"></a>&nbsp;&nbsp;&nbsp;
                    
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
