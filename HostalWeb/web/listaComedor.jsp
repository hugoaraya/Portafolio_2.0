<%-- 
    Document   : listaHabitaciones
    Created on : 29-05-2018, 20:09:45
    Author     : 420NiggaBytes
--%>

<%@page import="modelo.Plato"%>
<%@page import="dao.PlatoDAO"%>
<%@page import="dao.HabitacionesDAO"%>
<%@page import="modelo.Habitacion"%>
<%@page import="java.util.ArrayList"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/tabla_h.css"> 
        
        <title>Perfil Administrador</title>    
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
                    <a class="x" title="Volver" href='indexAdmin.jsp'>X</a>
              </div>
        <div id="main-container">
            <table>
                <thead>
                    <tr>
                        <th>Nro</th><th>Nombre Plato</th><th><button onclick="location.href='agregarPlato.jsp'">Nueva</button></th>
                    </tr>
               </thead>   
               <%            
                  
                   PlatoDAO dao2 = new PlatoDAO();                   
                   ArrayList<Plato> dCon = dao2.listarPlato();

                   for (Plato temp : dCon) {
                    
               %>                 

               <tr>
                   <td><p><%=temp.getId()%> </p></td>
                   <td><p><%=temp.getNombre_plato()%></p></td>
                   
                   <td><p><button onclick="location.href='modificarPlato.jsp?id=<%=temp.getId()%>'">Modificar</button></p></td>
               </tr>               
                    
               <%
                   
                   }
              
                } else {
                response.sendRedirect("login.jsp");
            }
        %>
        </table>
        </div>
               
    </body>
</html>
