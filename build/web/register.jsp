<%-- 
    Document   : index
    Created on : Feb 3, 2020, 2:50:11 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Title</title>

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> 
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
              integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/owl.carousel.min.css">
        <link rel="stylesheet" href="./css/main.css">
        <style>

        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <section class="formDangky ">

                <div class="dangnhap_content">
                    <div class="duongdan row m-0 " style="background: #111111">
                        <a href="#"> <i class="fa fa-home"></i> Trang chủ</a>    <span class="ml-1 mr-1">/</span> <p>Đăng ký</p>

                    </div>
                    <div class="tables">
                        <table>
                            <tr>
                                <td>
                                    Tài khoản
                                </td>
                                <td>
                                    <input type="text" name="fullname" id="fullname" placeholder="nhập tài khoản">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Mật khẩu
                                </td>
                                <td>
                                    <input type="password" name="password" id="password" placeholder="nhập mật khẩu truy cập">
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    Phone
                                </td>
                                <td>
                                    <input type="text" name="DienThoai" placeholder="nhập phone number" required>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Địa chỉ 
                                </td>
                                <td>
                                    <input type="text" name="DiaChi" placeholder="nhập địa chỉ" required>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Email
                                </td>
                                <td>
                                    <input type="email" name="Email" id="email" placeholder="email" >
                                    <span id="user-result"></span>
                                </td>
                            </tr>
                            <tr>
                                <td> 
                                </td>
                                <td>

                                    <button type="submit" id="btnDK" name="command" class="btn btn-primary">Đăng ký</button>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </section>

            <section class="intro">
                <div class="intro_content">
                    <div class="">
                        <ul>
                            <li><a href="#"><img src="./img/logocitizen.png" style="height: 20px;" /></a></li>
                            <li><a href="#"><img src="./img/elixa (1).jpg" /></a></li>
                            <li><a href="#"><img src="./img/Ogival_Fish.png" /></a></li>
                            <li><a href="#"><img src="./img/020e6a5f09554ff153344de8df47a26c.jpeg" /></a></li>
                            <li><a href="#"><img src="./img/OP.png" /></a></li>
                            <li><a href="#"><img src="./img/Orient_Watch_logo.png" /></a></li>
                            <li><a href="#"><img src="./img/Seiko-Logo-Watches.png" style="height: 20px;" /></a></li>
                        </ul>
                    </div>

                </div>
            </section>
        <jsp:include page="footer.jsp"></jsp:include>




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
        <script>
            $('.owl-carousel').owlCarousel({
                loop: true,
                margin: 10,
                nav: true,
                responsive: {
                    0: {
                        items: 1
                    },
                    600: {
                        items: 3
                    },
                    1000: {
                        items: 3
                    }
                }
            })
        </script>
        <script>
            $(window).scroll(function () {
                if (window.scrollY > $('.header_bottom').height() + 200) {
                    $('.header_bottom').addClass('positionfixed');
                }
                else {
                    $('.header_bottom').removeClass('positionfixed');
                }
            })
        </script>
        <script>
            $('.btnDropdownmenuHeader').click(function () {
                $($(this).data('asd')).toggleClass('show');
            })
            $(window).on('click', function (e) {
                if (!e.target.closest('.btnDropdownmenuHeader')) {
                    $('#asd').removeClass('show');
                }
            })
        </script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"  type="text/javascript"></script> 
        <script type="text/javascript">
            $(document).ready(function () {
                var x_timer;
                $("#email").keyup(function (e) {
                    clearTimeout(x_timer);
                    var user_name = $(this).val();
                    x_timer = setTimeout(function () {
                        check_username_ajax(user_name);
                    }, 1);
                });
                function check_username_ajax(username) {
                    //   $("#user-result").html('<img src="img/ajax-loader.gif" />');
                    $.post('CheckEmailServlet', {'username': username}, function (data) {
                        $("#user-result").html(data);
                    });
                }
                $("#btnDK").click(function () {
                    var fullname = $("#fullname").val();
                    var password = $("#password").val()
                    $.post('adduser', {
                        'fullname': fullname,
                        'password': password,
                        'email': $("#email").val()}, function (data) {
                        window.clearTimeout();
                        $("#user-result").html(data);
                        $("#fullname").val("");
                        $("#email").val("");
                        $("#password").val("");
                    })
                })
            });
        </script> 
    </body>
</html>
