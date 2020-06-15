<%-- 
    Document   : index
    Created on : Feb 3, 2020, 2:50:11 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.productDAO"%>
<%@page import="model.product"%>
<%@page  import="model.Cart"%>
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
        <%
            productDAO pro = new productDAO();
            String id = "";
            product prod = new product();
            if (request.getParameter("product") != null) {
                id = request.getParameter("product");
                prod = pro.getProduct(Long.parseLong(id));
            }
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <section class="duongdan row m-0">
                <a href="#"> <i class="fa fa-home"></i> Trang chủ</a> <span class="ml-1 mr-1">/</span> <p>Sản phẩm</p> <span class="ml-1 mr-1">/</span> <p><%=prod.getProductName()%></p>
        </section>
        <section class="chitietsanpham">
            <div class="chitietsanpham_content row m-0">
                <div class="col-md-6">
                    <div class="hinhsanpham">
                        <div id="demo" class="carousel slide" data-ride="carousel">

                            <!-- Indicators -->
                            <ul class="carousel-indicators">
                                <li data-target="#demo" data-slide-to="0" class="active"></li>
                                <li data-target="#demo" data-slide-to="1"></li>
                                <li data-target="#demo" data-slide-to="2"></li>
                                <li data-target="#demo" data-slide-to="3"></li>
                                <li data-target="#demo" data-slide-to="4"></li>
                            </ul>

                            <!-- The slideshow -->
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="<%=prod.getProductImage()%>" alt="Los Angeles">
                                </div>
                                <div class="carousel-item">
                                    <img src="./img/dongho22.jpg" alt="Los Angeles">
                                </div>
                                <div class="carousel-item">
                                    <img src="./img/dongho222.jpg" alt="Los Angeles">
                                </div>
                                <div class="carousel-item">
                                    <img src="./img/dongho2222.jpg" alt="Los Angeles">
                                </div>
                                <div class="carousel-item">
                                    <img src="./img/dongho22222.jpg" alt="Los Angeles">
                                </div>
                            </div>

                            <!-- Left and right controls -->
                            <a class="carousel-control-prev" href="#demo" data-slide="prev">
                                <span class="carousel-control-prev-icon"><i class="fa fa-angle-left"></i></span>
                            </a>
                            <a class="carousel-control-next" href="#demo" data-slide="next">
                                <span class="carousel-control-next-icon"><i class="fa fa-angle-right"></i></span>
                            </a>

                        </div>
                    </div>
                    <div>
                        <img src="./img/abc.png" class="hinhtangkem" />
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="giavaten">
                        <div class="ten">
                            <p><%=prod.getProductName()%></p>
                        </div>
                        <div class="gia">
                            <p>Giá:<span><%=prod.getProductPrice()%>đ</span></p>
                        </div>
                    </div>
                    <div >
                        <a class="btn btn-success btnDatmua" href="GioHangServlet?command=insert&ma_san_pham=<%=prod.getProductID()%>&cartID=<%=System.currentTimeMillis()%>">THÊM VÀO GIỎ HÀNG <i class="fa fa-shopping-cart ml-auto"></i> </a>
                    </div>
                    <div class="thongso">
                        <div class="title">
                            BẢO HIỂM, HẬU MÃI HÀNG ĐẦU VIỆT NAM
                        </div>
                        <div class="table">
                            <table>
                                <tr>
                                    <td>
                                        Bảo hiểm Xwatch <i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        Cho cả lỗi người dùng ĐẦU TIÊN tại Việt Nam
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Bảo hành Xwatch <i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        5 năm tiêu chuẩn Thuỵ Sỹ
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Thẩm định thật giả<i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        Miễn phí
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Đổi trả<i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        30 ngày
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Giao hàng <i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        Miễn phí toàn quốc
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="table2">
                            <table>
                                <tr>
                                    <td>
                                        Phân nhóm <i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        Đồng hồ Orient
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Nhãn hiệu<i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        Orient
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Nguồn gốc<i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        Nhật bản    
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Dòng sản phẩm<i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        Orient Star
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Kiểu máy <i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        Đồng hồ cơ
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Đồng hồ dành cho <i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        Nam
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Kích cỡ <i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        39.5mm
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Chất liệu vỏ <i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        Thép không gỉ 316L
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Chất liệu dây <i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        Thép không gỉ 316L
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Chất liệu kính <i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        Kính Sapphire
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Độ chịu nước <i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        100 m
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Bảo hành quốc tế<i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </td>
                                    <td>
                                        1
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="hinhanhkhac mt-5">
                <img src="./img/og1929-24agsr-t-1.jpg"   alt="">
                <img src="./img/ovigalchinhhang.png" alt="">
                <img src="./img/artboard-1-2-1-1.png" class="mb-0" alt="">
                <img src="./img/49-1.jpg" alt="">
                <img src="./img/baohime.png" />

            </div>

        </section>
        <section class="sanphamlienquan" style="text-align: center;">
            <h3>SẢN PHẨM LIÊN QUAN</h3>
            <div style="height: 2px; width: 100px; background:black; margin: auto;margin-bottom: 30px;"></div>

            <div class="sanphamlienquan_content owl-carousel owl2 owl-theme">
                <div class=" pr-5 ">
                    <a class="card " href="#">
                        <img src="./img/dongho1.jpg" />
                        <h6 class="masp">SET0T002S0</h6>
                        <div class="">- - - -</div>
                        <h5 class="gia">9,530,000</h5>
                    </a>
                </div>
                <div class=" pr-5">
                    <a class="card " href="#">
                        <img src="./img/dongho1.jpg" />
                        <h6 class="masp">SET0T002S0</h6>
                        <div class="">- - - -</div>
                        <h5 class="gia">9,530,000</h5>
                    </a>
                </div>
                <div class=" pr-5">
                    <a class="card " href="#">
                        <img src="./img/dongho1.jpg" />
                        <h6 class="masp">SET0T002S0</h6>
                        <div class="">- - - -</div>
                        <h5 class="gia">9,530,000</h5>
                    </a>
                </div>
                <div class="pr-5 ">
                    <a class="card " href="#">
                        <img src="./img/dongho1.jpg" />
                        <h6 class="masp">SET0T002S0</h6>
                        <div class="">- - - -</div>
                        <h5 class="gia">9,530,000</h5>
                    </a>
                </div>
                <div class="pr-5 ">
                    <a class="card " href="#">
                        <img src="./img/dongho1.jpg" />
                        <h6 class="masp">SET0T002S0</h6>
                        <div class="">- - - -</div>
                        <h5 class="gia">9,530,000</h5>
                    </a>
                </div>
                <div class=" ">
                    <a class="card " href="#">
                        <img src="./img/dongho1.jpg" />
                        <h6 class="masp">SET0T002S0</h6>
                        <div class="">- - - -</div>
                        <h5 class="gia">9,530,000</h5>
                    </a>
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
    </body>
</html>
