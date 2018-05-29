<%-- 
    Document   : formulario_orden_compra
    Created on : 21-05-2018, 17:13:05
    Author     : 420NiggaBytes
--%>

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
                <li>Paso 3</li>
                <li>Detalle</li>
            </ul>
        </div>
        <br>  
        <form>
            <div id="main-container">
                <table>
                    <thead>
                        <tr>
                            <th>Capacidad</th><th>Nombre Habitacion</th><th>Descripcion</th><th>Estado Habitacion</th><th>Precio</th><th>Seleccionar</th>
                        </tr>
                    </thead>                            
                    <tr>
                        <td><p>2</p></td>
                        <td><p>Habitacion 1</p></td>
                        <td><p>Habitacion Cama doble</p></td>
                        <td><p>Disponible</p></td>
                        <td><p>$30000</p></td>
                        <td><p><input type="checkbox" id="check"></p></td>
                    </tr>  
                </table> 
                <br>
                <button>Submit</button>
                <a href="formulario_orden_compra_3.jsp">Step 3</a>
            </div>
            
      </form>
    </body>
</html>
