<%-- 
    Document   : newjsp
    Created on : 17-05-2018, 17:33:31
    Author     : 420NiggaBytes
--%>

<%@page import="com.sun.xml.rpc.processor.modeler.j2ee.xml.parameterModeType"%>
<%@page import="modelo.Producto"%>
<%@page import="dao.Orden_ProductoDAO"%>
<%@page import="modelo.Orden_pedido"%>
<%@page import="modelo.Proveedor"%>
<%@page import="modelo.Proveedor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.Orden_pedidoDAO"%>
<%@page import="dao.ProveedorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
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

        <table>
            <thead>
                <tr>
                    <th>Nro.Orden</th>
                    <th>Nombre</th>
                    <th>Familia</th>
                    <th>Tipo de Producto</th>
                    <th>Descripcion</th>
                    <th>Stock</th>
                    <th>Stock Critico</th>
                    <th>Precio</th>
                </tr>
            </thead>   
            <%                //array de los datos  de la orden de pedido                   
                ArrayList<Producto> pro = (ArrayList<Producto>) request.getAttribute("lista");
                int total = 0;
                for (Producto productos : pro) {
                    total += productos.getPrecio();

            %>                 

            <tr>                
                <td><p><%=productos.getNombre()%></p></td>
                <td><p><%=productos.getFamilia()%></p></td>
                <td><p><%=productos.getTipo_producto()%></p></td>
                <td><p><%=productos.getDescripcion()%></p></td>
                <td><p><%=productos.getStock()%></p></td>
                <td><p><%=productos.getStock_critico()%></p></td>
                <td><p><%=productos.getPrecio()%></p></td>
            </tr>               

            <%
                }

            %>            
        </table>
            <h3>Total: <%=total%></h3>
    </div>
    <%

    %>
</body>
</html>
