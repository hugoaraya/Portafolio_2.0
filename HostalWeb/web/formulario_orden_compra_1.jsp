<%-- 
    Document   : formulario_orden_compra
    Created on : 21-05-2018, 17:13:05
    Author     : 420NiggaBytes
--%>

<%@page import="java.time.temporal.ChronoUnit"%>
<%@page import="java.time.LocalDate"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/formulario_1.css" rel="stylesheet" type="text/css"/>
        <link href="css/pasoscss.css" rel="stylesheet" type="text/css"/>
        <script src="js/validar_steps_1.js" type="text/javascript"></script>
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
                <li>Paso 2</li>               
                <li>Detalle</li>
            </ul>
        </div><br>
        <form action="formulario_orden_compra_2.jsp" method="post" id="steps">
            <h1>Paso 1:</h1>
            <h5>Cantidad Trabajadores</h5>
            <select name ="num_trab" id="numtrab">
                <option value="0" disabled selected>Seleccionar</option>
                <option 
                <% LocalDate localDate = LocalDate.now();
                LocalDate tomorrow = localDate.plus(1, ChronoUnit.DAYS);
                    for (int i = 1; i <= 10; i++) {
                %>                
                <option value="<%out.print(i);%>"><%out.print(i);%></option>  
                <%   }
                %> 
            </select>  
             <h5>Fecha Inicio<h5>
            <input type="date" name="fecha_inicio" id="fechaInicio" min="<%=localDate%>" ><br>
            <h5>Fecha Fin</h5>
            <input type="date" name="fecha_fin" id="fechaFin" min="<%=tomorrow%>"><br><br>
            <input type="button" id="btn_enviar" value="Siguiente" onclick="validarForm()"><br> 
            <p align="center"><a href="indexEmpresa.jsp">Volver</a></p>
            <br><br> <p align="center"><span align id="error" ></span></p>
        </form> 
            <%
            } else {
                response.sendRedirect("login.jsp");
            }
        %>


    </body>
</html>
