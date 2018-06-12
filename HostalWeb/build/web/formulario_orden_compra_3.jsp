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
        <link href="css/steps.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Roboto:400' rel='stylesheet' type='text/css'>

        <title>Pedir Habitacion</title>
    </head>
    <body>
        <div class="container">
            <ul class="progressbar">
                <li class="active">Paso 1</li>
                <li class="active">Paso 2</li>
                <li class="active">Paso 3</li>
                <li>Detalle</li>
            </ul>
        </div>

        <form>
            <div id="main-container">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                        </tr>
                    </thead>   
                    <%

                        

                    %>                 

                    <tr>
                        <td><p><%=%> </p></td>


                    </tr>       
                    <%

                        }


                    %>




                    <br>
                    <button>Submit</button>
                    <a href="formulario_orden_compra_1.jsp">Step 1</a>
                    <a href="indexEmpresa.jsp">Volver</a>
            </div>             
        </form>


    </body>
</html>

