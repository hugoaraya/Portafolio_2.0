<%-- 
    Document   : listaHabitaciones
    Created on : 29-05-2018, 20:09:45
    Author     : 420NiggaBytes
--%>

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
            <a href="agregarHabitacion.jsp">Habitacion</a>
        <div id="main-container">
            <table>
                <thead>
                    <tr>
                        <th>Nro</th><th>Nombre Habitacion</th><th>Tipo Cama</th><th>Accesorio</th><th>Precio</th><th>Capacidad</th><th>Disponibilidad</th><th>   </th>
                    </tr>
               </thead>   
               <%            
                  
                   HabitacionesDAO dao2 = new HabitacionesDAO();                   
                   ArrayList<Habitacion> dCon = dao2.listaHabitacion();

                   for (Habitacion temp : dCon) {
                    
               %>                 

               <tr>
                   <td><p><%=temp.getId_habitacion()%> </p></td>
                   <td><p><%=temp.getNombre_habitacion()%></p></td>
                   <td><p><%=temp.getTipo_cama()%></p></td>
                   <td><p><%=temp.getAccesorios()%></p></td>  
                   <td><p><%=temp.getPrecio_habitacion()%></p></td> 
                   <td><p><%=temp.getCapacidad()%></p></td> 
                   <td><p><%=temp.getEstado_habitacion()%></p></td> 
                   <td><p><a href="modificarHabitacion.jsp?id=<%=temp.getId_habitacion()%>" title="Modificar"><img src="img/x.png" alt="Modificar" width="40" height="40" border="0"></a></p></td>
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
