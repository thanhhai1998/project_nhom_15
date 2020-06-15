<%-- 
    Document   : addproduct
    Created on : Feb 8, 2020, 2:38:04 PM
    Author     : ASUS
--%>


<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.productDAO"%>
<%@page import="model.product"%>
<%@page import="dao.userDAO"%>
<%@page import="model.user"%>
<%@page import="dao.categoryDAO"%>
<%@page import="model.category"%> 
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>

        <!-- start: Meta -->
        <meta charset="utf-8">
        <title>Delete product</title>
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
        <style>

        </style>



    </head>

    <body>

        <!-- start: Header -->
        <%             user users = (user) session.getAttribute("admin");
            if (users == null) {
                response.sendRedirect("/web/login_admin.jsp");
            } else {        %> 
        <% categoryDAO dao = new categoryDAO();%>
        <%
            productDAO pro = new productDAO();
            String id = "";
            product prod = new product();
            if (request.getParameter("product") != null) {
                id = request.getParameter("product");
                prod = pro.getProduct(Long.parseLong(id));
            }

        %>
        <form method="get" action="deleteproduct" enctype='multipart/form-data'>
            <table>
                Xóa sàn phẩm <%=prod.getProductName()%> 
                <input name="id" id="id" value="<%=prod.getProductID()%>" style="position: fixed;left: 100000px" />
                <tr>
                    <td> 
                    </td>
                    <td>

                        <button type="submit"   name="command" class="btn btn-primary">Xóa</button>
                    </td>
                </tr>
            </table>
        </form>
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
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <!--        <script src="js/jquery-1.9.1.min.js"></script>-->

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"  type="text/javascript"></script> 
        <script type="text/javascript">
            $(document).ready(function () {
                $("#btnDK").click(function () {
                    var fullname = $("#fullname").val();
                    var password = $("#password").val()
                    $.post('addproduct', {
                        'name': fullname,
                        'image': password,
                        'price': $("#email").val(), 'category_id': $('#category_id').val()}, function (data) {
                        window.clearTimeout();
                        $("#user-result").html(data);
                        $("#fullname").val("");
                        $("#email").val("");
                        $("#password").val("");
                    })
                })
            });
        </script> <% }%>
    </body>

</html>