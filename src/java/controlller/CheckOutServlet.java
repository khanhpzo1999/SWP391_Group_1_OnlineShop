/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlller;

import dao.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Order;
import model.User;

/**
 *
 * @author Nhat Anh
 */
public class CheckOutServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        if (session.getAttribute("account") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = "";
        String email = "";
        String phone = "";
        String address = "";
        String note = "";
        float totalPaid = 0;
        int discount = 0;
        if (request.getParameter("name") != null) {
            name = request.getParameter("name");
        }
        if (request.getParameter("email") != null) {
            email = request.getParameter("email");
        }
        if (request.getParameter("phone") != null) {
            phone = request.getParameter("phone");
        }
        if (request.getParameter("address") != null) {
            address = request.getParameter("address");
        }
        if (request.getParameter("note") != null) {
            address = request.getParameter("note");
        }
        if (request.getParameter("totalpaid") != null) {
            totalPaid = Float.parseFloat(request.getParameter("totalpaid"));
        }
        if (request.getParameter("discount") != null) {
            discount = Integer.parseInt(request.getParameter("discount"));
        }
        User user = (User) session.getAttribute("account");
        Order order = new Order(name, email, phone, address, note, 0, discount, totalPaid, user.getId());

        OrderDAO dao = new OrderDAO();
        if (session.getAttribute("cart") != null) {
            ArrayList<Cart> list = (ArrayList) session.getAttribute("cart");
            try {
                int check = dao.insertOrder(order, list);
                if (check == 1) {
                    session.removeAttribute("cart");
                }
                response.sendRedirect("./list");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else{
            response.sendRedirect("./cart");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
