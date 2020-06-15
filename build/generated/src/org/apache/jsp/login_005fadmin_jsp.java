package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.userDAO;
import model.user;

public final class login_005fadmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("        <meta name=\"description\" content=\"Bootstrap Metro Dashboard\">\n");
      out.write("        <meta name=\"author\" content=\"Dennis Ji\">\n");
      out.write("        <meta name=\"keyword\" content=\"Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina\">\n");
      out.write("\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("        <link id=\"bootstrap-style\" href=\"~/Content/Admin/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"~/Content/Admin/bootstrap-responsive.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link id=\"base-style\" href=\"~/Content/Admin/style.css\" rel=\"stylesheet\">\n");
      out.write("        <link id=\"base-style-responsive\" href=\"~/Content/Admin/style-responsive.css\" rel=\"stylesheet\">\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>\n");
      out.write("        <!-- end: CSS -->\n");
      out.write("        <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("            <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n");
      out.write("            <link id=\"ie-style\" href=\"css/ie.css\" rel=\"stylesheet\">\n");
      out.write("        <![endif]-->\n");
      out.write("        <!--[if IE 9]>\n");
      out.write("            <link id=\"ie9style\" href=\"css/ie9.css\" rel=\"stylesheet\">\n");
      out.write("        <![endif]-->\n");
      out.write("        <!-- start: Favicon -->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"~/img/favicon.ico\">\n");
      out.write("        <!-- end: Favicon -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("         ");
             user users = (user) session.getAttribute("admin");
            if (users != null) {
                response.sendRedirect("/web/quanlysanpham.jsp");
          } else {        
      out.write("\n");
      out.write("        <div class=\"container-fluid-full\">\n");
      out.write("            <div class=\"row-fluid\">\n");
      out.write("\n");
      out.write("                <div class=\"row-fluid\">\n");
      out.write("                    <div class=\"login-box\">\n");
      out.write("                        <div class=\"icons\">\n");
      out.write("                            <a href=\"index.html\"><i class=\"halflings-icon fa fa-home\" style=\"\"></i></a>\n");
      out.write("                            <a href=\"#\"><i class=\"halflings-icon cog\"></i></a>\n");
      out.write("                        </div>\n");
      out.write("                        <h2>Login to your account</h2>\n");
      out.write("                        <table>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    Tài khoản\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"text\" name=\"\" id=\"email\" placeholder=\"nhập tài khoản\">\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    Mật khẩu\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"password\" name=\"\" id=\"password\" placeholder=\"nhập mật khẩu truy cập\">\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td> \n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("\n");
      out.write("                                    <button type=\"submit\" class=\"btn btn-primary\" id=\"btnDN\">Đăng nhập</button>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                        <hr>\n");
      out.write("\n");
      out.write("                    </div><!--/span-->\n");
      out.write("                </div><!--/row-->\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div><!--/.fluid-container-->\n");
      out.write("\n");
      out.write("        </div><!--/fluid-row-->\n");
      out.write("        <!-- start: JavaScript-->\n");
      out.write("\n");
      out.write("        <script src=\"~/Scripts/Admin/jquery-1.9.1.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"~/Scripts/Admin/custom.js\"></script>\n");
      out.write("        <!-- end: JavaScript-->\n");
      out.write("\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\n");
      out.write("                integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\n");
      out.write("                integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"\n");
      out.write("                integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"./js/owl.carousel.min.js\"></script>\n");
      out.write("       \n");
      out.write("         \n");
      out.write("        \n");
      out.write("        <script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js\"  type=\"text/javascript\"></script> \n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                var x_timer;\n");
      out.write("\n");
      out.write("               \n");
      out.write("                $(\"#btnDN\").click(function () {\n");
      out.write("\n");
      out.write("                    var password = $(\"#password\").val()\n");
      out.write("                    $.post('login', {\n");
      out.write("                        'password': password,\n");
      out.write("                        'email_admin': $(\"#email\").val()}, function (data) {\n");
      out.write("\n");
      out.write("                        $(\"#user-result\").html(data);\n");
      out.write("                        if (data == \"Dang nhap thanh cong !!\") {\n");
      out.write("                            window.location.replace(\"http://localhost:8080/web/quanlysanpham.jsp\");\n");
      out.write("                        }\n");
      out.write("//                        $(\"#email\").val(\"\");\n");
      out.write("//                        $(\"#password\").val(\"\");\n");
      out.write("                    })\n");
      out.write("                })\n");
      out.write("            });\n");
      out.write("        </script> \n");
      out.write("        ");
 } 
      out.write("\n");
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
