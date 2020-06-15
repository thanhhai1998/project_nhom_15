package controller;

import dao.userDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.user;

public class adduser extends HttpServlet {

    userDAO usersDAO = new userDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        String url = "";
        user users = new user();
        HttpSession session = request.getSession();

        users.setUserID(new java.util.Date().getTime());
        users.setFullname(request.getParameter("fullname"));
        users.setUserEmail(request.getParameter("email"));
        users.setUserPass(request.getParameter("password"));
        usersDAO.insertUser(users);
        session.setAttribute("user", users);
        response.getWriter().write("Tao tai khoan thanh cong !!");

    }
}
