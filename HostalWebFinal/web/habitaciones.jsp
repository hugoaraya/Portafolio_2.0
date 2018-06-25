<%-- 
    Document   : habitaciones
    Created on : 24-06-2018, 21:22:46
    Author     : 420NiggaBytes
--%>

<%@page import="modelo.Habitacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.HabitacionesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link href="css/habitacion_list.css" rel="stylesheet" type="text/css"/>
        <title>Habitaciones</title>
    </head>
    <body>         
        <h2 align="center" color="white">Lista de Habitaciones</h2>        
       <div class="tbl-content">
            <table cellpadding="0" cellspacing="0" border="0">
                <thead>                   
                <th>Nro</th>
                <th>Nombre Habitacion</th>
                <th>Tipo Cama</th>
                <th>Accesorio</th>
                <th>Precio</th>
                <th>Capacidad</th>
                <th>Disponibilidad</th>
                
                </thead>   
                <%

                    HabitacionesDAO dao2 = new HabitacionesDAO();
                    ArrayList<Habitacion> dCon = dao2.listaHabitacion();

                    for (Habitacion temp : dCon) {

                %>                 
                <tbody>
                <tr>
                    <td><%=temp.getId_habitacion()%></td>
                    <td><%=temp.getNombre_habitacion()%></td>
                    <td><%=temp.getTipo_cama()%></td>
                    <td><%=temp.getAccesorios()%></td>  
                    <td><%=temp.getPrecio_habitacion()%></td> 
                    <td><%=temp.getCapacidad()%></td> 
                    <td><%=temp.getEstado_habitacion()%></td> 
                    
                </tr>       
                <%

                    }

                %>
                </tbody>
            </table>
       </div>
                <p align='center'><button type="button" onclick="location.href='index.jsp'">Volver</button></p>
    </body>
</html>
