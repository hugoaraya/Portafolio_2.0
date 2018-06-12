package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class formulario_005forden_005fcompra_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/formulario.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css\">\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Roboto:400' rel='stylesheet' type='text/css'>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <ul class=\"progressbar\">\n");
      out.write("                <li class=\"active\">Paso 1</li>\n");
      out.write("                <li>Paso 2</li>\n");
      out.write("                <li>Paso 3</li>\n");
      out.write("                <li>Detalle</li>\n");
      out.write("            </ul>\n");
      out.write("        </div><br>\n");
      out.write("        <form>\n");
      out.write("            <h1>Paso 1:</h1>\n");
      out.write("            <h5>Cantidad Trabajadores</h5>\n");
      out.write("            <select name =\"num_trab\">\n");
      out.write("                ");

                    for (int i = 1; i <= 10; i++) {
                
      out.write("                \n");
      out.write("                <option value=\"");
out.print(i);
      out.write('"');
      out.write('>');
out.print(i);
      out.write("</option>  \n");
      out.write("                ");
   }
                
      out.write(" \n");
      out.write("            </select>  \n");
      out.write("            <h5>Fecha Entrada:</h5>\n");
      out.write("            <input placeholder=\"Password\" type=\"date\" required=\"\">\n");
      out.write("            <h5>Fecha Salida:</h5>\n");
      out.write("            <input placeholder=\"Password\" type=\"date\" required=\"\">\n");
      out.write("            <br>\n");
      out.write("            <button onclick=\"formulario_orden_compra_2.jsp\">Submit</button>\n");
      out.write("            \n");
      out.write("        </form> \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
