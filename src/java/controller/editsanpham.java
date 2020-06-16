/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.productDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.product;
import model.user;

/**
 *
 * @author ASUS
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

public class editsanpham extends HttpServlet {

    productDAO dao = new productDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        String url = "";
        product pro = new product();
        HttpSession session = request.getSession();
        pro.setProductID(Long.parseLong(request.getParameter("id")));
        pro.setProductName(request.getParameter("name"));
        pro.setProductImage(request.getParameter("image"));
        pro.setProductPrice(Long.parseLong(request.getParameter("price")));
        dao.editProduct(pro, Long.parseLong(request.getParameter("category_id")));
        response.sendRedirect("/web/quanlysanpham.jsp");
        response.getWriter().write("Sua san pham thanh cong !!");

    }

}

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controller;
//
//import dao.productDAO;
//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.Part;
//import model.product;
//import model.user;
//
///**
// *
// * @author ASUS
// */
////@WebServlet("/")
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
//public class addproduct extends HttpServlet {
//
//    productDAO dao = new productDAO();
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String command = request.getParameter("command");
//        String url = "";
//        product pro = new product();
//        HttpSession session = request.getSession();
//        PrintWriter out = response.getWriter();
//        Part part = request.getPart("file");
//        String fileName = extractFileName(part);
//
//        String savePath = "C:\\Users\\ASUS\\Desktop\\java\\project\\web\\web\\img\\" + File.separator + fileName;
//        File fileSaveDir = new File(savePath);
//        part.write(savePath + File.separator);
//
//        pro.setProductID(new java.util.Date().getTime());
//        pro.setProductName(request.getParameter("name"));
//        pro.setProductImage(savePath);
//        pro.setProductPrice(Long.parseLong(request.getParameter("price")));
//        dao.insertProduct(pro, Long.parseLong(request.getParameter("category_id")));
//        response.getWriter().write("Dang ky thanh cong !!");
//
//    }
//
//    private String extractFileName(Part part) {
//        String contentDisp = part.getHeader("content-disposition");
//        String[] items = contentDisp.split(";");
//        for (String s : items) {
//            if (s.trim().startsWith("filename")) {
//                return s.substring(s.indexOf("=") + 2, s.length() - 1);
//            }
//        }
//        return "";
//    }
//}
//package controller;
//
//import dao.productDAO;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.Part;
//import model.product;
//import model.user;
//
///**
// *
// * @author ASUS
// */
////@WebServlet("/")
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
//public class addproduct extends HttpServlet {
//
//    productDAO dao = new productDAO();
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String command = request.getParameter("command");
//        String url = "";
//        product pro = new product();
//        HttpSession session = request.getSession();
//        PrintWriter out = response.getWriter();
//        Part part = request.getPart("file");
//        String fileName = extractFileName(part);
//        InputStream inputStream = null;
//        inputStream = part.getInputStream();
//        pro.setProductID(new java.util.Date().getTime());
//        pro.setProductName(request.getParameter("name")); 
//        pro.setProductPrice(Long.parseLong(request.getParameter("price")));
//        dao.insertProduct(pro, Long.parseLong(request.getParameter("category_id")),inputStream);
//        response.getWriter().write("Dang ky thanh cong !!");
//
//    }
//
//    private String extractFileName(Part part) {
//        String contentDisp = part.getHeader("content-disposition");
//        String[] items = contentDisp.split(";");
//        for (String s : items) {
//            if (s.trim().startsWith("filename")) {
//                return s.substring(s.indexOf("=") + 2, s.length() - 1);
//            }
//        }
//        return "";
//    }
//}
