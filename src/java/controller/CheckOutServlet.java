package controller;

import dao.BillDAO;
import dao.BillDetailDAO;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bill;
import model.BillDetail;
import model.Cart;
import model.product;
import model.user;
import tools.SendMail;

public class CheckOutServlet extends HttpServlet {

    private final BillDAO billDAO = new BillDAO();
    private final BillDetailDAO billDetailDAO = new BillDetailDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String payment = request.getParameter("payment");
        String address = request.getParameter("address");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        user users = (user) session.getAttribute("user");
        String url = "/index.jsp";
        try {
            long ID = new Date().getTime();
            Bill bill = new Bill();
            bill.setBillID(ID);
            bill.setAddress(address);
            bill.setPayment(payment);
            bill.setUserID(users.getUserID());
            bill.setDate(new Timestamp(new Date().getTime()));
            bill.setTotal(cart.total());
            billDAO.insertBill(bill);
            for (Map.Entry<product, Integer> list : cart.getList().entrySet()) {
                billDetailDAO.insertBillDetail(new BillDetail(0, ID, list.getKey().getProductID(), list.getKey().getProductPrice(), list.getValue()));
            }
            SendMail sm = new SendMail();
            SendMail.sendMail(users.getUserEmail(), "Bui Thanh Hai", "Hello,  " + users.getUserEmail() + "\nTotal: " + cart.total());
            cart = new Cart();
            session.setAttribute("cart", cart);
        } catch (Exception e) {
        }
         response.sendRedirect("/web/index.jsp"); 
    }
}
