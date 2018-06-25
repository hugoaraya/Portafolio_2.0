<%@page import="modelo.Empresa"%>
<%@page import="dao.EmpresaDAO"%>
<%@page import="modelo.Huesped"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.HuespedDAO"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/tabla_huesped_n.css"> 
        <title>Perfil Empresa</title>    
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
                    <a class="x" title="Volver" href='indexEmpresa.jsp'>X</a>
              </div>
           
        <div id="main-container">
            <table>
                <thead>
                    <tr>
                        <th>Nro</th><th>Rut</th><th>Nombre</th><th>Cargo</th><th>Correo</th><th>Telefono</th><th>Estado</th><th> <button onclick="location.href='agregarHuesped.jsp'">Nuevo</button></th>
                    </tr>
               </thead>   
               <%            
                   
                   String rut = session.getAttribute("user").toString();
            
            EmpresaDAO dao1 = new EmpresaDAO();
            ArrayList<Empresa> dCons = dao1.listaEmpresa(rut);            
            for (Empresa temps : dCons) {
                int id_empresa = temps.getIdEmpresa();            
                   HuespedDAO dao2 = new HuespedDAO();                   
                   ArrayList<Huesped> dCon = dao2.listarHuesped(id_empresa);
                   int i = 1;     
                   for (Huesped temp : dCon) {
                      
                    
               %>                 

               <tr>
                   <td><p><%=i%> </p></td>
                   <td><p><%=temp.getRut()+"-"+temp.getDv()%></p></td>
                   <td><p><%=temp.getNombre()+" "+temp.getApellido()%></p></td>
                   <td><p><%=temp.getCargo()%></p></td>  
                   <td><p><%=temp.getCorreo()%></p></td> 
                   <td><p><%=temp.getNumero_tefono()%></p></td> 
                   <td><p><%=temp.getEstado_huesped()%></p></td> 
                   <td><p> <button onclick="location.href='modificarHuesped.jsp?id=<%=temp.getId_huesped()%>'">Modificar</button></p></td>
               </tr>       
               <%
                   i++;
                   }
}
              
                } else {
                response.sendRedirect("login.jsp");
            }
        %>
        </table>
        </div>
               
    </body>
</html>