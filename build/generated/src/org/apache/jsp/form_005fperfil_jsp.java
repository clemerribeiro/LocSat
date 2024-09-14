package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class form_005fperfil_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/banner.jsp");
    _jspx_dependants.add("/menu.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap-theme.min.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>       \n");
      out.write("        ");
      out.write("<img src=\"imagens/banner.png\" alt=\"\" title=\"\" width=\"100%\" height=\"150px\"/>");
      out.write("\n");
      out.write("        ");
      out.write("<div class=\"menu\">\n");
      out.write("    <ul>\n");
      out.write("        <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("        <li><a href=\"listar_perfil.jsp\">Perfis</a></li>\n");
      out.write("        <li><a href=\"listar_menu.jsp\">Menus</a></li>\n");
      out.write("        <li><a href=\"listar_usuario.jsp\">Usuários</a></li>\n");
      out.write("    </ul>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"estilo/menu.css\" type=\"text.css\"/>");
      out.write("\n");
      out.write("        <h3>Cadastrar Perfil</h3>\n");
      out.write("        <form action=\"gerenciar_perfil.do\" method=\"POST\">\n");
      out.write("            <input type=\"hidden\" name=\"idperfil\" id=\"idperfil\" value=\"\"/>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"from-group col-sm-8\">\n");
      out.write("                    <label for=\"nome\" class=\"control_label\">Nome</label>\n");
      out.write("                    <input type=\"text\" name=\"nome\" id=\"nome\" value=\"\" class=\"form-control\" required=\"\"\n");
      out.write("                           maxlength=\"45\"/>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <button class=\"btn btn-success\">Gravar</button>\n");
      out.write("                <a href=\"listar_perfil.jsp\" class=\"btn btn-warning\">Voltar</a>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
