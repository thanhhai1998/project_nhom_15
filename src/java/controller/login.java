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

public class login extends HttpServlet {

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
        if (request.getParameter("email_admin") != null && request.getParameter("email") == null) {
            users = usersDAO.login_admin(request.getParameter("email_admin"), request.getParameter("password"));
            if (users != null) {
                session.setAttribute("admin", users);
                url = "/Index.jsp";
                response.getWriter().write("Dang nhap thanh cong !!");
            } else {
                session.setAttribute("error", "Email hoặc mật khẩu không đúng.!");
                url = "/Login.jsp";
                response.getWriter().write("Email hoac mat khau khong dung.!!");
            }
        } else {
            users = usersDAO.login(request.getParameter("email"), request.getParameter("password"));
            if (users != null) {
                session.setAttribute("user", users);
                url = "/Index.jsp";
                response.getWriter().write("Dang nhap thanh cong !!");
            } else {
                session.setAttribute("error", "Email hoặc mật khẩu không đúng.!");
                url = "/Login.jsp";
                response.getWriter().write("Email hoac mat khau khong dung.!!");
            }
        }

    }
}
