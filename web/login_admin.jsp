 
<!DOCTYPE html>

<%@page import="dao.userDAO"%>
<%@page import="model.user"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>


        <meta charset="utf-8">
        <title>Login</title>
        <meta name="description" content="Bootstrap Metro Dashboard">
        <meta name="author" content="Dennis Ji">
        <meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link id="bootstrap-style" href="~/Content/Admin/bootstrap.min.css" rel="stylesheet">
        <link href="~/Content/Admin/bootstrap-responsive.min.css" rel="stylesheet">
        <link id="base-style" href="~/Content/Admin/style.css" rel="stylesheet">
        <link id="base-style-responsive" href="~/Content/Admin/style-responsive.css" rel="stylesheet">
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
        <link rel="shortcut icon" href="~/img/favicon.ico">
        <!-- end: Favicon -->





    </head>

    <body>
         <%             user users = (user) session.getAttribute("admin");
            if (users != null) {
                response.sendRedirect("/web/quanlysanpham.jsp");
          } else {        %>
        <div class="container-fluid-full">
            <div class="row-fluid">

                <div class="row-fluid">
                    <div class="login-box">
                        <div class="icons">
                            <a href="index.html"><i class="halflings-icon fa fa-home" style=""></i></a>
                            <a href="#"><i class="halflings-icon cog"></i></a>
                        </div>
                        <h2>Login to your account</h2>
                        <table>
                            <tr>
                                <td>
                                    Tài khoản
                                </td>
                                <td>
                                    <input type="text" name="" id="email" placeholder="nhập tài khoản">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Mật khẩu
                                </td>
                                <td>
                                    <input type="password" name="" id="password" placeholder="nhập mật khẩu truy cập">
                                </td>
                            </tr>

                            <tr>
                                <td> 
                                </td>
                                <td>

                                    <button type="submit" class="btn btn-primary" id="btnDN">Đăng nhập</button>
                                </td>
                            </tr>
                        </table>
                        <hr>

                    </div><!--/span-->
                </div><!--/row-->


            </div><!--/.fluid-container-->

        </div><!--/fluid-row-->
        <!-- start: JavaScript-->

        <script src="~/Scripts/Admin/jquery-1.9.1.min.js"></script>




        <script src="~/Scripts/Admin/custom.js"></script>
        <!-- end: JavaScript-->

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
        <script src="./js/owl.carousel.min.js"></script>
       
         
        
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"  type="text/javascript"></script> 

        <script type="text/javascript">
            $(document).ready(function () {
                var x_timer;

               
                $("#btnDN").click(function () {

                    var password = $("#password").val()
                    $.post('login', {
                        'password': password,
                        'email_admin': $("#email").val()}, function (data) {

                        $("#user-result").html(data);
                        if (data == "Dang nhap thanh cong !!") {
                            window.location.replace("http://localhost:8080/web/quanlysanpham.jsp");
                        }
//                        $("#email").val("");
//                        $("#password").val("");
                    })
                })
            });
        </script> 
        <% } %>
    </body>
</html>

