/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.productDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.user;
import model.Cart;
import model.product;

/**
 *
 * @author ASUS
 */
public class GioHangServlet extends HttpServlet {

    private productDAO productdao = new productDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        String msp = request.getParameter("ma_san_pham");
        String command = request.getParameter("command");
        ArrayList<Long> listBuy = null;
        String url = "/giohang.jsp";
        try {
            listBuy = (ArrayList<Long>) session.getAttribute("cartID");
            long idBuy = 0;
            if (request.getParameter("cartID") != null) {
                idBuy = Long.parseLong(request.getParameter("ma_san_pham"));
                product sp = productdao.getProduct(idBuy);
                switch (command) {
                    case "insert":
                        if (listBuy == null) {
                            listBuy = new ArrayList<>();
                            session.setAttribute("cartID", listBuy);
                        }
                        if (listBuy.indexOf(idBuy) == -1) {
                            cart.insertToCart(sp, 1);
                            listBuy.add(idBuy);
                        }
                        url = "/giohang.jsp";
                        break;
                    case "plus":
                        if (listBuy == null) {
                            listBuy = new ArrayList<>();
                            session.setAttribute("cart", listBuy);
                        }
                        if (listBuy.indexOf(idBuy) != -1) {
                            cart.insertToCart(sp, 1);
                            listBuy.add(idBuy);
                        }
                        url = "/giohang.jsp";
                        break;
                    case "sub":
                        if (listBuy == null) {
                            listBuy = new ArrayList<>();
                            session.setAttribute("cart", listBuy);
                        }
                        if (listBuy.indexOf(idBuy) != -1) {
                            cart.subToCart(sp, 1);
                            listBuy.add(idBuy);
                        }
                        url = "/giohang.jsp";
                        break;
                    case "remove":
                        cart.removeToCart(sp);
                        while (listBuy.indexOf(idBuy) != -1) {

                            listBuy.remove(idBuy);
                        }
                        url = "/giohang.jsp";
                        break;
                    default:
                        break;
                }
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            }
        } catch (Exception e) {
        }
    }
}
