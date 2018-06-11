<%-- 
    Document   : ordenes_pedido
    Created on : 15-05-2018, 23:23:19
    Author     : 420NiggaBytes
--%>

<%@page import="dao.Orden_pedidoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Proveedor"%>
<%@page import="modelo.Orden_pedido"%>
<%@page import="dao.ProveedorDAO"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/tabla_p_1.css"> 
        <title>Perfil Proveedor</title>    
        <%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
        %>
        <%
            if (session.getAttribute("user") != null) {

        %>

    </head>
    <body>
        <%            HttpSession sesion = request.getSession();
            String usuario;
            String nivel;

            if (sesion.getAttribute("user") != null && sesion.getAttribute("nivel") != null) {
                usuario = sesion.getAttribute("user").toString();
                nivel = sesion.getAttribute("nivel").toString();

            } else {
                out.print("<script>location.replace('login.jsp');</script>");
            }

        %>
                <div class="floating-icon">
                    <a class="x" href='indexProveedor.jsp'>X</a>
              </div>
        <div id="main-container">
            <table>
                <thead>
                    <tr>
                        <th>Nro Orden</th><th>Nombre Empleado</th><th>Fecha</th><th>Rut Proveedor</th><th>Estado Orden</th><th>Detalle</th><th>Opciones</th> 
                    </tr>
               </thead>   
               <%            String rut = session.getAttribute("user").toString();
                   ProveedorDAO dao2 = new ProveedorDAO();
                   Orden_pedidoDAO dao = new Orden_pedidoDAO();
                   ArrayList<Proveedor> dCon = dao2.listaProveedor(rut);

                   for (Proveedor temp : dCon) {
                       ArrayList<Orden_pedido> dor = dao.listaOrdenPedido(temp.getIdProveedor());
                       for (Orden_pedido ordenes : dor) {


               %>                 

               <tr>
                   <td><p><%=ordenes.getNro_orden()%> </p></td>
                   <td><p><%=ordenes.getNombre_empleado()%></p></td>
                   <td><p><%=ordenes.getFecha()%></p></td>
                   <td><p><%=ordenes.getRut()%></p></td>
                   <td><p><%=ordenes.getEstado_orden()%></p></td>
                   <td><p><a href="detalle_orden.pdf?nro_orden=<%=ordenes.getNro_orden()%>" title="Ver Detalle"><img src="img/search.png" alt="Ver Detalle" width="40" height="40" border="0"></a></p></td>
                   <td><p> <button onclick="location.href='modificarOrdenPedido.jsp?id=<%=ordenes.getId_orden_pedido()%>'">Modificar</button></p></td>

               </tr>               

               <%
                   }
               %>
        </table>
        </div>
                    <%
                }
            } else {
                response.sendRedirect("login.jsp");
            }
        %>
        


    </body>
</html>
