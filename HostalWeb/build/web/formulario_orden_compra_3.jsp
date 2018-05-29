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
                <li class="active">Paso 3</li>
                <li>Detalle</li>
            </ul>
        </div>
        <br>  
        <form>
            <div id="main-container">
                <table>
                    <thead>
                        <tr>
                            <th>Nombre Huesped</th><th>Rut Huesped</th><th>Cargo</th><th>Correo</th><th>Telefono</th><th>Seleccionar</th>
                        </tr>
                    </thead>                            
                    <tr>
                        <td><p>Juan Perez</p></td>
                        <td><p>1273745-6</p></td>
                        <td><p>Ejecutivo</p></td>
                        <td><p>juanperez@empresa.cl</p></td>
                        <td><p>2222222</p></td>
                        <td><p><input type="checkbox" id="check"></p></td>
                    </tr>  
                </table> 
                <br>
                <button>Submit</button>
                <a href="formulario_orden_compra_1.jsp">Step 1</a>
                <a href="indexEmpresa.jsp">Volver</a>
            </div>
            
      </form>
    </body>
</html>
