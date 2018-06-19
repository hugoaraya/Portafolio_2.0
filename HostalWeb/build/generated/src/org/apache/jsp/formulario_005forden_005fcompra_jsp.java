package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class formulario_005forden_005fcompra_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"css/formulario.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>      \n");
      out.write("        <form id=\"regForm\" action=\"\">\n");
      out.write("\n");
      out.write("            <h1>Register:</h1>\n");
      out.write("\n");
      out.write("            <!-- One \"tab\" for each step in the form: -->\n");
      out.write("            <div class=\"tab\">Name:\n");
      out.write("                <p><input placeholder=\"First name...\" oninput=\"this.className = ''\"></p>\n");
      out.write("                <p><input placeholder=\"Last name...\" oninput=\"this.className = ''\"></p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"tab\">Contact Info:\n");
      out.write("                <p><input placeholder=\"E-mail...\" oninput=\"this.className = ''\"></p>\n");
      out.write("                <p><input placeholder=\"Phone...\" oninput=\"this.className = ''\"></p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"tab\">Birthday:\n");
      out.write("                <p><input placeholder=\"dd\" oninput=\"this.className = ''\"></p>\n");
      out.write("                <p><input placeholder=\"mm\" oninput=\"this.className = ''\"></p>\n");
      out.write("                <p><input placeholder=\"yyyy\" oninput=\"this.className = ''\"></p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"tab\">Login Info:\n");
      out.write("                <p><input placeholder=\"Username...\" oninput=\"this.className = ''\"></p>\n");
      out.write("                <p><input placeholder=\"Password...\" oninput=\"this.className = ''\"></p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div style=\"overflow:auto;\">\n");
      out.write("                <div style=\"float:right;\">\n");
      out.write("                    <button type=\"button\" id=\"prevBtn\" onclick=\"nextPrev(-1)\">Previous</button>\n");
      out.write("                    <button type=\"button\" id=\"nextBtn\" onclick=\"nextPrev(1)\">Next</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Circles which indicates the steps of the form: -->\n");
      out.write("            <div style=\"text-align:center;margin-top:40px;\">\n");
      out.write("                <span class=\"step\"></span>\n");
      out.write("                <span class=\"step\"></span>\n");
      out.write("                <span class=\"step\"></span>\n");
      out.write("                <span class=\"step\"></span>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        <script src=\"js/formulario.js\" type=\"text/javascript\"></script>\n");
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
