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
import javax.servlet.http.HttpSession;
import model.user;

/**
 *
 * @author ASUS
 */
public class editusers extends HttpServlet {

    userDAO dao = new userDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        String url = "";
        user pro = new user();
        HttpSession session = request.getSession();
        pro.setUserID(Long.parseLong(request.getParameter("id")));
        pro.setFullname(request.getParameter("fullname"));
        pro.setUserEmail(request.getParameter("email"));
        pro.setUserPass(request.getParameter("password"));
        dao.edit(pro);
        response.sendRedirect("/web/quanlynguoidung.jsp");
        response.getWriter().write("Sua thong tin thanh cong !!");

    }

}
