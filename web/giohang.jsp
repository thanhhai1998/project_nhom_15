<%-- 
    Document   : index
    Created on : Feb 3, 2020, 2:50:11 PM
    Author     : ASUS
--%>

<%@page import="model.user"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Map"%>
<%@page import="model.product"%>
<%@page import="java.util.TreeMap"%>
<%@page import="model.Cart"%>
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
        <%             user users = (user) session.getAttribute("user");
            if (users == null) {
                response.sendRedirect("/web/login.jsp");
            } else {        %>
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            TreeMap<product, Integer> list = cart.getList();
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(0);
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <section class="giohang">
                <div class="duongdan row m-0 " style="background: #111111">
                    <a href="#"> <i class="fa fa-home"></i> Trang chủ</a>    <span class="ml-1 mr-1">/</span> <p>Giỏ hàng</p>

                </div>
                <div class="giohang_content">
                    <table>
                        <tr class="tr1">
                            <td >Danh sách sản phẩm</td>
                            <td>Giá</td>

                            <td>Số lượng</td>
                            <td>Cộng</td>
                        </tr>
                    <%
                        for (Map.Entry<product, Integer> ds : list.entrySet()) {
                    %>
                    <tr class="tr2">
                        <td class="row m-0">
                            <img src="<%=ds.getKey().getProductImage()%>"  />
                            <div class="info">

                                <p class="name"><%=ds.getKey().getProductName()%></p>
                                <p class="loaidongho">ĐỒNG HỒ SEIKO</p>
                                <button class="btn btnUpdate " style="border-radius:5px;" type="submit"><i class="fa fa-undo"></i></button>
                                <a href="GioHangServlet?command=remove&ma_san_pham=<%=ds.getKey().getProductID()%>&cartID=<%=System.currentTimeMillis()%>">     <button class="btn btnXoa btn-danger"><i class="fa fa-trash"></i></button></a>
                            </div>
                        </td>
                        <td><%=nf.format(ds.getKey().getProductPrice())%>đ</td>

                        <td><a href="GioHangServlet?command=sub&ma_san_pham=<%=ds.getKey().getProductID()%>&cartID=<%=System.currentTimeMillis()%>">-</a><input  class="tdSL p-1 text-center" type="number" disabled="" name="txtSoLuong" value="<%=ds.getValue()%>">
                            <a href="GioHangServlet?command=plus&ma_san_pham=<%=ds.getKey().getProductID()%>&cartID=<%=System.currentTimeMillis()%>">+</a>
                        </td>
                        <td><%=nf.format(ds.getValue() * ds.getKey().getProductPrice())%>đ</td>
                    </tr>
                    <% }%>
                </table>
                <div class="tongtoanbo mb-3">
                    <h4>TỔNG SỐ: <%=nf.format(cart.total())%>đ</h4>
                </div>
                <form action="CheckOutServlet" method="POST">
                    <div class="row m-0">
                        <div class="thongtinkhachhang  ">
                            <h5 class="my-3">THÔNG TIN KHÁCH HÀNG</h5>


                            <table>
                                <tr>
                                    <td>
                                        <label for="">Email</label>
                                    </td>
                                    <td>
                                        <input type="text" name="" disabled value="<%=users.getUserEmail()%>" class="form-control"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label> Điện thoại </label><sup>*</sup>
                                    </td>
                                    <td>
                                        <input type="text" name="" disabled  class="form-control"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <label for="">Địa chỉ</label> <sup>*</sup>
                                    </td>
                                    <td>
                                        <input type="text" name="address"class="form-control"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td> 
                                    </td>
                                    <td>
                                        <input type="submit" name=""class="btn btn-default "/>
                                    </td>
                                </tr>
                            </table>


                        </div>
                        <div class="hinhthucthanhtoan  ">
                            <h5 class="my-3">HÌNH THỨC THANH TOÁN</h5>
                            <div class="hinhthuc">
                                <input id="" type="radio" name="payment" value="Thanh toan truc tiep tại cua hang" checked="">
                                <label for="">Thanh toán trực tiếp tại cửa hàng</label>
                            </div>
                            <div class="hinhthuc">
                                <input id="" type="radio" name="payment" value="Thanh toan tai nha" checked="">
                                <label for="">Thanh toán khi nhận hàng</label>
                            </div>
                            <div class="row m-0">

                                <div class="col-md-6  p-0 pr-1">
                                    <div class="freeship">
                                        <i class="fa fa-car"></i> Miễn phí giao hàng
                                        TOÀN QUỐC
                                    </div>
                                </div>
                                <div class="col-md-6 p-0  pl-1">
                                    <div class="test">
                                        <i class="fa fa-thumbs-up"></i> Đồng kiểm khi
                                        NHẬN HÀNG
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div       </form>
            </div>

        </section>
        <% }%>
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
