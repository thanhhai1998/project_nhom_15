package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.userDAO;
import model.user;

public final class header_005fadmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <!-- start: Meta -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>\n");
      out.write("        <meta name=\"description\" content=\"Bootstrap Metro Dashboard\">\n");
      out.write("        <meta name=\"author\" content=\"Dennis Ji\">\n");
      out.write("        <meta name=\"keyword\"\n");
      out.write("              content=\"Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina\">\n");
      out.write("        <!-- end: Meta -->\n");
      out.write("\n");
      out.write("        <!-- start: Mobile Specific -->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <!-- end: Mobile Specific -->\n");
      out.write("\n");
      out.write("        <!-- start: CSS -->\n");
      out.write("        <link id=\"bootstrap-style\" href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/bootstrap-responsive.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link id=\"base-style\" href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("        <link id=\"base-style-responsive\" href=\"css/style-responsive.css\" rel=\"stylesheet\">\n");
      out.write("        <link\n");
      out.write("            href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext'\n");
      out.write("            rel='stylesheet' type='text/css'>\n");
      out.write("        <!-- end: CSS -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("                    <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n");
      out.write("                    <link id=\"ie-style\" href=\"css/ie.css\" rel=\"stylesheet\">\n");
      out.write("            <![endif]-->\n");
      out.write("\n");
      out.write("        <!--[if IE 9]>\n");
      out.write("                    <link id=\"ie9style\" href=\"css/ie9.css\" rel=\"stylesheet\">\n");
      out.write("            <![endif]-->\n");
      out.write("\n");
      out.write("        <!-- start: Favicon -->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"img/favicon.ico\">\n");
      out.write("        <!-- end: Favicon -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");
             user users = new user();
            if (session.getAttribute("admin") != null) {
                users = (user) session.getAttribute("admin");
            } else {
                users.setUserEmail("");
            }

        
      out.write("   \n");
      out.write("        <!-- start: Header -->\n");
      out.write("        <div class=\"navbar\">\n");
      out.write("            <div class=\"navbar-inner\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("                    <a class=\"brand\" href=\"index.html\"><span>Metro</span></a>\n");
      out.write("\n");
      out.write("                    <div class=\"nav-no-collapse header-nav\">\n");
      out.write("                        <ul class=\"nav pull-right\">\n");
      out.write("\n");
      out.write("                            <li class=\"dropdown\">\n");
      out.write("                                <a class=\"btn dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                                    <i class=\"halflings-icon white user\"></i> ");
      out.print(users.getUserEmail());
      out.write("\n");
      out.write("                                    <span class=\"caret\"></span>\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu\">\n");
      out.write("                                    <li class=\"dropdown-menu-title\">\n");
      out.write("                                        <span>Account Settings</span>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"halflings-icon user\"></i> Profile</a></li>\n");
      out.write("                                    <li><a  href=\"dangxuat\" ><i class=\"halflings-icon off\"></i> Logout</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li> \n");
      out.write("                        </ul>\n");
      out.write("                    </div> \n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div> \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
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
