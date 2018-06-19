<%-- 
    Document   : ordenes_pedido
    Created on : 15-05-2018, 23:23:19
    Author     : 420NiggaBytes
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.Orden_compra"%>
<%@page import="modelo.Empresa"%>
<%@page import="dao.Orden_CompraDAO"%>
<%@page import="dao.EmpresaDAO"%>
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
        <link rel="stylesheet" type="text/css" href="css/tabla_ordenes.css"> 
        <title>Perfil Empresa</title>    
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
            <a class="x" title="Volver" href='indexEmpresa.jsp'>X</a>
        </div>
        <div id="main-container">
            <table>
                <thead>
                    <tr>
                        <th>Nro Orden</th><th>Nombre Empresa</th><th>Rut Empresa</th><th>Fecha Orden</th><th>Detalle</th>
                    </tr>
                </thead>   
                <%                   String rut = session.getAttribute("user").toString();
                    EmpresaDAO dao2 = new EmpresaDAO();
                    Orden_CompraDAO dao = new Orden_CompraDAO();
                    ArrayList<Empresa> dCon = dao2.listaEmpresa(rut);
                    for (Empresa temp : dCon) {
                        ArrayList<Orden_compra> dor = dao.listaOrdenCompra(temp.getIdEmpresa());
                        for (Orden_compra ordenes : dor) {
                            SimpleDateFormat formato
                                    = new SimpleDateFormat("dd/MM/YYYY");
                            String fecha = formato.format(ordenes.getFecha());

                %>                 

                <tr>
                    <td><p><%=ordenes.getNro_orden()%> </p></td>
                    <td><p><%=ordenes.getNombre_empresa()%></p></td>
                    <td><p><%=ordenes.getRut() + "-" + ordenes.getDv()%></p></td>
                    <td><p><%=fecha%></p></td>                   
                    <td><p><a href="detalle_orden_compra.pdf?nro_orden=<%=ordenes.getNro_orden()%>" title="Ver Factura"><img src="img/search.png" alt="Ver Detalle" width="40" height="40" border="0"></a></p></td>
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
