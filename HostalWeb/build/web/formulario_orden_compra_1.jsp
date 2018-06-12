<%-- 
    Document   : formulario_orden_compra
    Created on : 21-05-2018, 17:13:05
    Author     : 420NiggaBytes
--%>

<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/formulario.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Roboto:400' rel='stylesheet' type='text/css'>
        <title>Pedir Habitacion</title>
    </head>
    <body>
        <div class="container">
            <ul class="progressbar">
                <li class="active">Paso 1</li>
                <li>Paso 2</li>
                <li>Paso 3</li>
                <li>Detalle</li>
            </ul>
        </div><br>
        <form action="formulario_orden_compra_2.jsp" method="post">
            <h1>Paso 1:</h1>
            <h5>Cantidad Trabajadores</h5>
            <select name ="num_trab">
                <% LocalDate localDate = LocalDate.now();   
                    for (int i = 1; i <= 10; i++) {
                %>                
                <option value="<%out.print(i);%>"><%out.print(i);%></option>  
                <%   }
                %> 
            </select>  
             <h5>Fecha Inicio<h5>
            <input type="date" name="fecha_inicio" id="fechaInicio" min="<%=localDate%>" ><br>
            <h5>Fecha Fin</h5>
            <input type="date" name="fecha_fin" id="fechaFin" min="<%=localDate%>"><br><br>
            <button type="submit">Submit</button>  
            <a href="formulario_orden_compra_2.jsp">Step 2</a>
            
        </form> 



    </body>
</html>
