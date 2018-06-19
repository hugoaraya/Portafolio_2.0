<%-- 
    Document   : formulario_orden_compra
    Created on : 21-05-2018, 17:13:05
    Author     : 420NiggaBytes
--%>

<%@page import="modelo.Orden_compra"%>
<%@page import="dao.Orden_CompraDAO"%>
<%@page import="modelo.Habitacion"%>
<%@page import="dao.HabitacionesDAO"%>
<%@page import="modelo.Huesped"%>
<%@page import="dao.HuespedDAO"%>
<%@page import="modelo.Empresa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.EmpresaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/detalle_1.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

        <link href='https://fonts.googleapis.com/css?family=Roboto:400' rel='stylesheet' type='text/css'>

        <title>Pedir Habitacion</title>
    </head>
    <body>
        <div class="container">
            <ul class="progressbar">
                <li class="active">Paso 1</li>
                <li class="active">Paso 2</li>
                <li class="active">Detalle</li>               
            </ul>
        </div>
        <div class="login-page">
            <div class="form">
                <h4 align="center">Detalle compra</h4><br>
                <form action="indexEmpresa.jsp" method="post" class="login-form"> 
                    <p>Nro Orden: 666</p>
                    <p>Fecha: 12/07/2018</p>
                    <p>Comercio:www.doñaclarita.cl</p>                     
                    <p>Total: $9999</p>
                    <button type="submit">Finalizar</button>

                </form>
            </div>
        </div>  






    </body>
</html>

