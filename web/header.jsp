<%-- 
    Document   : header
    Created on : Feb 3, 2020, 2:46:47 PM
    Author     : ASUS
--%>
<%@page import="dao.categoryDAO"%>
<%@page import="model.category"%>
<%@page import="model.user"%>
<%@page import="dao.userDAO"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%             user users = new user();
            if (session.getAttribute("user") != null) {
                users = (user) session.getAttribute("user");
            } else {
                users.setUserEmail("");
            }

        %>   
        <% categoryDAO dao = new categoryDAO();%>
        <header class="header">
            <div class="header_content">
                <div class="row header_top">
                    <div class="col-md-8">
                        <p>Chào mừng đến với hệ thống đồng hồ chính hãng Xwatch!</p>

                    </div>
                    <div class="col-md-4 text-right">
                        <%=users.getUserEmail()%>
                        <%
                            if (users.getUserEmail() == "") {
                        %>
                        <a class="" href="./login.jsp" style="color:#c2c2c2"> <i class="fa fa-user mr-3"></i>Đăng nhập</a>
                        <a class="ml-3 mr-3"  href="./register.jsp" style="color:#c2c2c2">Đăng Ký</a>
                        <% } else { %>
                        <a class="ml-3 mr-3"  id="dangxuat"  href="dangxuat" style="color:#c2c2c2;cursor: pointer" >Đăng xuất</a>
                        <% }%>


                        <a class="ml-3 mr-3" href="./giohang.jsp"  style="color:#c2c2c2;cursor: pointer" ><i class="fa fa-shopping-cart"></i></a>

                    </div>
                </div>
                <div class="header_mid row m-0">
                    <div class="col-md-4">
                        <a id="logoshop" href="./index.jsp">

                            <img src="./img/logo2.png" alt="" >
                        </a>
                    </div>
                    <div class="input-group col-md-4">

                        <input type="text" class="form-control txtTimkiem" placeholder="Tìm kiếm sản phẩm">
                        <div class="input-group-prepend">
                            <button class="input-group-text"><i class="fa fa-search" aria-hidden="true"></i></button>
                        </div>
                        <br>
                        <span class="mt-2" style="color:white"> <span style="color:red;">Gợi ý từ khóa: </span>
                            Đồng hồ đeo tay,OPOrient,Citizen,Ogival,...</span>
                    </div>
                    <div class="col-md-2 row m-0">
                        <i class="fa fa-phone" style=" "></i> <a href="#" rel="nofollow" class="phone"><span class=" ">Mua
                                hàng</span><br>
                            1900.0325</a>
                    </div>
                    <div class="col-md-2">
                        <a href="#" class="diachi"><i class="fa fa-map-marker"></i> Địa chỉ
                            cửa hàng</a>
                    </div>
                </div>
                <div class="header_bottom row">
                    <button class="col-md-4 btnDropdownmenuHeader" data-asd="#asd">
                        <div  style="">
                            <p class="m-0 " > <i class="fa fa-bars"></i> Danh mục sản phẩm</p>

                        </div>
                        <div class="dropdown-menu" id="asd">
                            <%
                                for (category c : dao.getListCategory()) {
                            %>
                            <a class="dropdown-item" href="product.jsp?category=<%=c.getCategoryID()%>"><%=c.getCategoryName()%></a>
                            <% }%>
                        </div>
                    </button>


                    <div class="col-md-8 row ">

                        <li><a href="#">VỀ XWATCH</a></li>
                        <li><a href="#">ĐỒNG HỒ NAM</a></li>
                        <li><a href="#">ĐỒNG HỒ NỮ</a></li>
                        <li><a href="#">THẨM ĐỊNH</a></li>
                        <li><a href="#">KIẾN THỨC ĐỒNG HỒ</a></li>
                        <li><a href="#">LIÊN HỆ</a></li>

                    </div>
                </div>
            </div>
        </header>
         
    </body>
</html>
