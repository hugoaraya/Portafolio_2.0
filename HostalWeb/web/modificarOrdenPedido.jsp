<%-- 
    Document   : agregarHabitacion
    Created on : 29-05-2018, 17:55:42
    Author     : 420NiggaBytes
--%>
<%@page import="modelo.Orden_pedido"%>
<%@page import="modelo.Orden_pedido"%>
<%@page import="dao.Orden_pedidoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Proveedor</title>        
        <link href="css/form_orden_pedido.css" rel="stylesheet" type="text/css"/>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
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
            Orden_pedidoDAO daoco = new Orden_pedidoDAO();
            Orden_pedido con = new Orden_pedido();
            con = daoco.getOrdenPorId(Integer.parseInt(id));

        %>

        <div class="login-page">
            <div class="form">
                <h4 align="center">Formulario Estado Orden de Pedido</h4>
                <form name="modificar_orden" action="modificarEstadoOrden" method="post" class="login-form">
                    <input type="hidden" name="idordenpedido" value="<%=con.getId_orden_pedido()%>">           
                    <div class="row">  
                        <select name="estado_orden_id" id="type">                            
                            <option name="estado_orden_id" value="2">Aceptar</option>
                            <option name="estado_orden_id" value="3">Rechazar</option>
                        </select>                    
                    </div>
                    <div class="row" id="row_dim">
                        Comentarios:
                        <textarea type="text" name="comentarios" placeholder="Comentarios"></textarea>                       
                    </div>
                    <button type="submit" value="Enviar">Enviar</button>
                    <br>         
                    <p class="message"><a href="ordenes_pedido.jsp">Volver</a></p>
                </form>
            </div>
        </div>

        <%          } else {
                response.getWriter().print("Por Favor Inicie Sesion.");
                response.sendRedirect("index.jsp");
            }
        %>
        <script>
            $(function () {
                $('#row_dim').hide();
                $('#type').change(function () {
                    if ($('#type').val() === '3') {
                        $('#row_dim').show();
                    } else {
                        $('#row_dim').hide();
                    }
                });
            });
        </script>        
    </body>
</html>
