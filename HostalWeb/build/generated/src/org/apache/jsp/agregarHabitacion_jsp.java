package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class agregarHabitacion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        ");

            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Expires", "0");
            response.setDateHeader("Expires", -1);
        
      out.write(" \n");
      out.write("        ");

            if (session.getAttribute("user") != null) {

        
      out.write("\n");
      out.write("\n");
      out.write("        <SCRIPT type=\"text/javascript\">\n");
      out.write("            window.history.forward();\n");
      out.write("            function noBack() {\n");
      out.write("                window.history.forward();\n");
      out.write("            }\n");
      out.write("        </SCRIPT>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
             HttpSession sesion = request.getSession();
            String usuario;
            String nivel;

            if (sesion.getAttribute("user") != null && sesion.getAttribute("nivel") != null) {
                usuario = sesion.getAttribute("user").toString();
                nivel = sesion.getAttribute("nivel").toString();
            } else {
                out.print("<script>location.replace('index.jsp');</script>");
            }

        
      out.write("\n");
      out.write("        <form action=\"SvAgregarHabitacion\" method=\"post\">\n");
      out.write("            <SELECT NAME=\"tipo_cama\">\n");
      out.write("                <OPTION VALUE=\"Individual\">Individual</OPTION>\n");
      out.write("                <OPTION VALUE=\"Doble Cama\">Doble Cama</OPTION>\n");
      out.write("                <OPTION VALUE=\"Tiple Cama\">Tiple Cama</OPTION>\n");
      out.write("                <OPTION VALUE=\"Doble Camarote\">Doble Camarote</OPTION>             \n");
      out.write("            </SELECT>\n");
      out.write("            <input type=\"text\" name=\"accesorios\">\n");
      out.write("            <input type=\"number\" name=\"precio\" min=\"0\">\n");
      out.write("            <input type=\"text\" name=\"descripcion\">  \n");
      out.write("            <input type=\"text\" name=\"nombre\">\n");
      out.write("           <SELECT NAME=\"estado\">\n");
      out.write("                <OPTION VALUE=\"1\">Disponible</OPTION>\n");
      out.write("                <OPTION VALUE=\"2\">Ocupada</OPTION>                   \n");
      out.write("            </SELECT>\n");
      out.write("            <input type=\"number\" name=\"capacidad\" min=\"0\">\n");
      out.write("            <input type=\"submit\">\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("    ");
            } else {
            response.getWriter().print("Por Favor Inicie Sesion.");
            response.sendRedirect("index.jsp");
        }
    
      out.write("\n");
      out.write("</body>\n");
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
