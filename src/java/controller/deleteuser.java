/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class deleteuser extends HttpServlet {

    
    userDAO dao = new userDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String id = req.getParameter("id");
        dao.delete(Long.parseLong(id));

          response.sendRedirect("/web/quanlynguoidung.jsp");
//        response.getWriter().write("Xoa san pham thanh cong !!");

    }
}
