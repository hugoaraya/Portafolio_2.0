package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.HabitacionesDAO;
import modelo.Habitacion;
import java.util.ArrayList;

public final class listaHabitaciones_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("          <div class=\"floating-icon\">\n");
      out.write("                    <a class=\"x\" title=\"Volver\" href='indexEmpresa.jsp'>X</a>\n");
      out.write("              </div>\n");
      out.write("        <div id=\"main-container\">\n");
      out.write("            <table>\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Nro</th><th>Nombre Habitacion</th><th>Tipo Cama</th><th>Accesorio</th><th>Precio</th><th>Capacidad</th><th>Disponibilidad</th>\n");
      out.write("                    </tr>\n");
      out.write("               </thead>   \n");
      out.write("               ");
            
                   String rut = session.getAttribute("user").toString();
                   HabitacionesDAO dao2 = new HabitacionesDAO();                   
                   ArrayList<Habitacion> dCon = dao2.listaHabitacion();

                   for (Habitacion temp : dCon) {
                     int nro = 1;
               
      out.write("                 \n");
      out.write("\n");
      out.write("               <tr>\n");
      out.write("                   <td><p>");
      out.print(nro);
      out.write(" </p></td>\n");
      out.write("                   <td><p>");
      out.print(temp.getNombre_habitacion());
      out.write("</p></td>\n");
      out.write("                   <td><p>");
      out.print(temp.getTipo_cama());
      out.write("</p></td>\n");
      out.write("                   <td><p>");
      out.print(temp.getAccesorios());
      out.write("</p></td>  \n");
      out.write("                   <td><p>");
      out.print(temp.getPrecio_habitacion());
      out.write("</p></td> \n");
      out.write("                   <td><p>");
      out.print(temp.getCapacidad());
      out.write("</p></td> \n");
      out.write("                   <td><p>");
      out.print(temp.getEstado_habitacion());
      out.write("</p></td> \n");
      out.write("                   <td><p><a href=\"detalle_orden_compra.pdf?nro_orden=");
      out.print(temp.getId_habitacion());
      out.write("\" title=\"Ver Factura\"><img src=\"img/search.png\" alt=\"Ver Detalle\" width=\"40\" height=\"40\" border=\"0\"></a></p></td>\n");
      out.write("               </tr>               \n");
      out.write("                    nro++;\n");
      out.write("               ");

                   }
               
      out.write("\n");
      out.write("        </table>\n");
      out.write("        </div>\n");
      out.write("               \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
