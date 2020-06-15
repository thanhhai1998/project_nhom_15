 
<%@page import="java.sql.PreparedStatement"%>
<%@page import="connect.DBconnect"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.productDAO"%>
<%@page import="model.product"%>
<%@page import="dao.userDAO"%>
<%@page import="model.user"%>
<html lang="en">
    <head>

        <!-- start: Meta -->
        <meta charset="utf-8">
        <title>QUản lý sp</title>
        <meta name="description" content="Bootstrap Metro Dashboard">
        <meta name="author" content="Dennis Ji">
        <meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <!-- end: Meta -->

        <!-- start: Mobile Specific -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- end: Mobile Specific -->

        <!-- start: CSS -->
        <link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
        <link id="base-style" href="css/style.css" rel="stylesheet">
        <link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
        <!-- end: CSS -->


        <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
                <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
                <link id="ie-style" href="css/ie.css" rel="stylesheet">
        <![endif]-->

        <!--[if IE 9]>
                <link id="ie9style" href="css/ie9.css" rel="stylesheet">
        <![endif]-->

        <!-- start: Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico">
        <!-- end: Favicon -->




    </head>

    <body>
        <!-- start: Header -->
        <%             user users = (user) session.getAttribute("admin");
            if (users == null) {
                response.sendRedirect("/web/login_admin.jsp");
            } else {        %>

        <% userDAO dao = new userDAO();%>
        <jsp:include page="header_admin.jsp"></jsp:include>
            <!-- start: Header -->

            <div class="container-fluid-full">
                <div class="row-fluid">

                    <!-- start: Main Menu -->
                    <div id="sidebar-left" class="span2">
                        <div class="nav-collapse sidebar-nav">

                            <ul class="nav nav-tabs nav-stacked main-menu">
                                <li><a href="/web/quanlysanpham.jsp"><i class="icon-bar-chart"></i><span class="hidden-tablet">Product</span></a></li>	
                                <li><a href="/web/quanlynguoidung.jsp"><i class="icon-bar-chart"></i><span class="hidden-tablet">User</span></a></li>	
                                <li><a href="/web/quanlyhoadon.jsp"><i class="icon-bar-chart"></i><span class="hidden-tablet">Bill</span></a></li>	
                            </ul>
                        </div>
                    </div>
                    <!-- end: Main Menu -->

                    <noscript>
                    <div class="alert alert-block span10">
                        <h4 class="alert-heading">Warning!</h4>
                        <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
                    </div>
                    </noscript>

                    <!-- start: Content -->
                    <div id="content" class="span10">

                        <ul class="breadcrumb">
                            <li>
                                <i class="icon-home"></i>
                                <a href="index.html">Home</a> 
                                <i class="icon-angle-right"></i>
                            </li>
                            <li><a href="#">Tables</a></li>
                        </ul>
                        <a class="btn btn-success" href="adduser.jsp" style="margin-bottom: 10px;float:right">
                            Add user
                        </a>
                        <div class="row-fluid sortable">		
                            <div class="box span12">
                                <div class="box-header" data-original-title>
                                    <h2><i class="halflings-icon user"></i><span class="break"></span>USer</h2>
                                    <div class="box-icon">
                                        <a href="#" class="btn-setting"><i class="halflings-icon wrench"></i></a>
                                        <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
                                        <a href="#" class="btn-close"><i class="halflings-icon remove"></i></a>
                                    </div>
                                </div>
                                <div class="box-content">
                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                        <thead>
                                            <tr>
                                                <th>User name</th>
                                                <th>Email</th>
                                                <th>Password</th> 
                                            </tr>
                                        </thead>   
                                        <tbody>

                                        <%
                                            for (user c : dao.getAllProduct()) {
                                        %>
                                        <tr>
                                            <td class="center"><%=c.getFullname()%></td>
                                            <td><%=c.getUserEmail()%> </td>
                                            <td class="center"><%=c.getUserPass()%></td>

    <td class="center">
                                                <a class="btn btn-success" href="#">
                                                    <i class="halflings-icon white zoom-in"></i>  
                                                </a>
                                                <a class="btn btn-info" href="edituser.jsp?product=<%=c.getUserID()%>">
                                                    <i class="halflings-icon white edit"></i>  
                                                </a>
                                                <a class="btn btn-danger" href="deleteuser.jsp?product=<%=c.getUserID()%>">
                                                    <i class="halflings-icon white trash"></i> 
                                                </a>
                                            </td>
                                        </tr>
                                        <% }%>
                                    </tbody>
                                </table>            
                            </div>
                        </div><!--/span-->


                    </div><!--/.fluid-container-->

                    <!-- end: Content -->
                </div><!--/#content.span10-->
            </div><!--/fluid-row-->


            <div class="clearfix"></div>

            <footer>

                <p>
                    <span style="text-align:left;float:left">&copy; 2013 <a href="http://jiji262.github.io/Bootstrap_Metro_Dashboard/" alt="Bootstrap_Metro_Dashboard">Bootstrap Metro Dashboard</a></span>

                </p>

            </footer>

            <!-- start: JavaScript-->

            <script src="js/jquery-1.9.1.min.js"></script>
            <script src="js/jquery-migrate-1.0.0.min.js"></script>

            <script src="js/jquery-ui-1.10.0.custom.min.js"></script>

            <script src="js/jquery.ui.touch-punch.js"></script>

            <script src="js/modernizr.js"></script>

            <script src="js/bootstrap.min.js"></script>

            <script src="js/jquery.cookie.js"></script>

            <script src='js/fullcalendar.min.js'></script>

            <script src='js/jquery.dataTables.min.js'></script>

            <script src="js/excanvas.js"></script>
            <script src="js/jquery.flot.js"></script>
            <script src="js/jquery.flot.pie.js"></script>
            <script src="js/jquery.flot.stack.js"></script>
            <script src="js/jquery.flot.resize.min.js"></script>

            <script src="js/jquery.chosen.min.js"></script>

            <script src="js/jquery.uniform.min.js"></script>

            <script src="js/jquery.cleditor.min.js"></script>

            <script src="js/jquery.noty.js"></script>

            <script src="js/jquery.elfinder.min.js"></script>

            <script src="js/jquery.raty.min.js"></script>

            <script src="js/jquery.iphone.toggle.js"></script>

            <script src="js/jquery.uploadify-3.1.min.js"></script>

            <script src="js/jquery.gritter.min.js"></script>

            <script src="js/jquery.imagesloaded.js"></script>

            <script src="js/jquery.masonry.min.js"></script>

            <script src="js/jquery.knob.modified.js"></script>

            <script src="js/jquery.sparkline.min.js"></script>

            <script src="js/counter.js"></script>

            <script src="js/retina.js"></script>

            <script src="js/custom.js"></script>
            <!-- end: JavaScript-->


            <% }%>
    </body>
</html>
