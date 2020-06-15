<!DOCTYPE html>


<%@page import="dao.userDAO"%>
<%@page import="model.user"%>
<html lang="en">


    <head>

        <!-- start: Meta -->
        <meta charset="utf-8">
        <title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>
        <meta name="description" content="Bootstrap Metro Dashboard">
        <meta name="author" content="Dennis Ji">
        <meta name="keyword"
              content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <!-- end: Meta -->

        <!-- start: Mobile Specific -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- end: Mobile Specific -->

        <!-- start: CSS -->
        <link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
        <link id="base-style" href="css/style.css" rel="stylesheet">
        <link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">
        <link
            href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext'
            rel='stylesheet' type='text/css'>
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
        <%             user users = new user();
            if (session.getAttribute("admin") != null) {
                users = (user) session.getAttribute("admin");
            } else {
                users.setUserEmail("");
            }

        %>   
        <!-- start: Header -->
        <div class="navbar">
            <div class="navbar-inner">
                <div class="container-fluid">

                    <a class="brand" href="index.html"><span>Metro</span></a>

                    <div class="nav-no-collapse header-nav">
                        <ul class="nav pull-right">

                            <li class="dropdown">
                                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="halflings-icon white user"></i> <%=users.getUserEmail()%>
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="dropdown-menu-title">
                                        <span>Account Settings</span>
                                    </li>
                                    <li><a href="#"><i class="halflings-icon user"></i> Profile</a></li>
                                    <li><a  href="dangxuat" ><i class="halflings-icon off"></i> Logout</a></li>
                                </ul>
                            </li> 
                        </ul>
                    </div> 

                </div>
            </div>
        </div> 



    </body>

</html>