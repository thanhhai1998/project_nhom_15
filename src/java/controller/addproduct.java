///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controller;
//
//import dao.productDAO;
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import model.product;
//import model.user;
//
///**
// *
// * @author ASUS
// */ 
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
//
//public class addproduct extends HttpServlet {
//
//    productDAO dao = new productDAO();
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
//
//    @Override
//    productDAO dao = new productDAO();
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
//
//    @Override//    productDAO dao = new productDAO();
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
//
//    @Override//    productDAO dao = new productDAO();
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
//
//    @Override//    productDAO dao = new productDAO();
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String command = request.getParameter("command");
//        String url = "";
//        product pro = new product();
//        HttpSession session = request.getSession();
//
//        pro.setProductID(new java.util.Date().getTime());
//        pro.setProductName(request.getParameter("name"));
//        pro.setProductImage(request.getParameter("image"));
//        pro.setProductPrice(Long.parseLong(request.getParameter("price")));
//        dao.insertProduct(pro, Long.parseLong(request.getParameter("category_id")));
//        response.getWriter().write("Them san pham thanh cong !!");
//
//          response.sendRedirect("/web/quanlysanpham.jsp");
//    }
//    
//}
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package controller;

import dao.productDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.product;
import model.user;

/**
 *
 * @author ASUS
 */
//@WebServlet("/")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class addproduct extends HttpServlet {

    productDAO dao = new productDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String command = request.getParameter("command");
        final String path = "img" + "/";
        String url = "";
        product pro = new product();
        HttpSession session = request.getSession();

        OutputStream outp = null;
        InputStream filecontent = null;
        PrintWriter out = response.getWriter();
        Part part = request.getPart("file");
        String fileName = extractFileName(part);
//        File imageSaveDirectory = new File("C:\\Users\\ASUS\\Desktop\\java\\project\\web\\web\\img" + File.separator + fileName);
//        if (!imageSaveDirectory.exists()) {
//            imageSaveDirectory.mkdir();
//        }
//        try {
//            outp = new FileOutputStream(new File());
//            filecontent = part.getInputStream();
//
//            int read = 0;
//            final byte[] bytes = new byte[1024];
//            while ((read = filecontent.read(bytes)) != -1) {
//                outp.write(bytes, 0, read);
//            }
//        } catch (Exception e) {
//        }
//        while ((read = filecontent.read(bytes)) != -1) {
//            outp.write(bytes, 0, read);
//        }
//        String savePath = path + "/" + File.separator + fileName;
//        File fileSaveDir = new File(savePath);
//        part.write(savePath + File.separator);

        pro.setProductID(new java.util.Date().getTime());
        pro.setProductName(request.getParameter("name"));
        pro.setProductImage(path
                + fileName);
        pro.setProductPrice(Long.parseLong(request.getParameter("price")));
        dao.insertProduct(pro, Long.parseLong(request.getParameter("category_id")));
        response.sendRedirect("/web/quanlysanpham.jsp");

    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
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
