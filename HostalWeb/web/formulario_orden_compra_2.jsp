<%-- 
    Document   : formulario_orden_compra
    Created on : 21-05-2018, 17:13:05
    Author     : 420NiggaBytes
--%>


<%@page import="modelo.Huesped"%>
<%@page import="dao.HuespedDAO"%>
<%@page import="modelo.Empresa"%>
<%@page import="dao.EmpresaDAO"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.Habitacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.HabitacionesDAO"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/steps_forms_2.css" rel="stylesheet" type="text/css"/>
        <link href="css/pasoscss.css" rel="stylesheet" type="text/css"/>        
        <script src="js/validar_steps_2_1.js" type="text/javascript"></script>
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Roboto:400' rel='stylesheet' type='text/css'>
        <title>Pedir Habitacion</title>
        <%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
        %>
        <%
            if (session.getAttribute("user") != null) {

        %>
    </head>
    <body>
        <div class="container">
            <ul class="progressbar">
                <li class="active">Paso 1</li>
                <li class="active">Paso 2</li>               
                <li>Detalle</li>
            </ul>
        </div>
        <br>  
        <form action="insertarHuespedHabitacion" method="post" id="huesped_habitacion">
            <div id="main-container">
                <h3 align="center">Seleccionar Habitaciones</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Nro</th><th>Nombre Habitacion</th><th>Tipo Cama</th><th>Accesorio</th><th>Precio</th><th>Capacidad</th><th>Disponibilidad</th><th>Seleccionar</th>
                        </tr>
                    </thead>        
                    <%

                        int numero = Integer.parseInt(request.getParameter("num_trab"));
                        Date fecha_inicio = Date.valueOf(request.getParameter("fecha_inicio"));
                        Date fecha_fin = Date.valueOf(request.getParameter("fecha_fin"));
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
                        String fecha = formato.format(fecha_inicio);
                        String fecha2 = formato.format(fecha_fin);
                        HabitacionesDAO dao3 = new HabitacionesDAO();
                        ArrayList<Habitacion> dCon1 = dao3.listaHabitacionFechaCap(numero, fecha, fecha2);

                        for (Habitacion temp : dCon1) {

                    %>

                    <tr>
                        <td><p><%=temp.getId_habitacion()%> </p></td>
                        <td><p><%=temp.getNombre_habitacion()%></p></td>
                        <td><p><%=temp.getTipo_cama()%></p></td>
                        <td><p><%=temp.getAccesorios()%></p></td>  
                        <td><p><%=temp.getPrecio_habitacion()%></p></td> 
                        <td><p><%=temp.getCapacidad()%></p></td> 
                        <td><p><%=temp.getEstado_habitacion()%></p></td>                   
                        <td><p align="center"><input type="checkbox" id="habitacion" name="id_habitacion" value="<%=temp.getId_habitacion()%>"></p></td>
                    </tr>       
                    <%

                        }%>
                </table> 
                <br>
                <h3 align="center">Seleccionar Trabajadores</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Nro</th><th>Rut</th><th>Nombre</th><th>Cargo</th><th>Correo</th><th>Telefono</th><th>Tipo Servicio</th><th>Seleccionar</th>
                        </tr>
                    </thead>   
                    <%

                        String rut = session.getAttribute("user").toString();

                        EmpresaDAO dao1 = new EmpresaDAO();
                        ArrayList<Empresa> dCons = dao1.listaEmpresa(rut);
                        for (Empresa temps : dCons) {
                            int id_empresa = temps.getIdEmpresa();
                            HuespedDAO dao2 = new HuespedDAO();
                            ArrayList<Huesped> dCon = dao2.listarHuespedNoHospedado(id_empresa);
                            int i = 1;
                            for (Huesped temp : dCon) {


                    %>                 

                    <tr>
                    <input type="hidden" value="<%=temps.getIdEmpresa()%>" name="empresa_id">
                    <td><p><%=i%> </p></td>
                    <td><p><%=temp.getRut() + "-" + temp.getDv()%></p></td>
                    <td><p><%=temp.getNombre() + " " + temp.getApellido()%></p></td>
                    <td><p><%=temp.getCargo()%></p></td>  
                    <td><p><%=temp.getCorreo()%></p></td> 
                    <td><p><%=temp.getNumero_tefono()%></p></td> 
                    <td><p><select name ="tipo_servicio" id="servicio">
                                <option value="0" disabled selected>Seleccionar</option>
                                <option value="1">Ejecutivo</option>
                                <option value="2">Especial</option>
                                <option value="3">General</option>
                            </select></p></td>
                   <td><p align="center"><input type="checkbox" id="huesped" name="id_huesped" value="<%=temp.getId_huesped()%>"></p></td>
                    </tr>
                    <%
                                i++;
                            }
                        }


                    %>
                </table><br>
              <input type="button" id="btn_enviar" value="Siguiente" onclick="validarForm()"><br> 
                <p align="center"><a href="formulario_orden_compra_1.jsp">Volver</a></p>
                <br><br> <p align="center"><span align id="error" ></span></p>        
            </div>
        </form>
                    <%
            } else {
                response.sendRedirect("login.jsp");
            }
        %>
    </body>
</html>