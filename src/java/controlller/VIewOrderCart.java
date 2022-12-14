/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlller;

import dao.DAODiscount;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Discount;
import model.Product;

/**
 *
 * @author long
 */
public class VIewOrderCart extends HttpServlet {

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
        ProductDAO dao = new ProductDAO();
        if (session.getAttribute("account") != null) {
            ArrayList<Cart> list = null;
            int total = 0;

            if (session.getAttribute("cart") != null) {
                list = (ArrayList) session.getAttribute("cart");

                if (request.getParameter("remove") != null) {
                    int id = Integer.parseInt(request.getParameter("remove"));
                    Product product = dao.getOne(id);
                    if (product != null) {
                        for (Cart c : list) {
                            if (c.getProduct().getPid() == product.getPid()) {
                                list.remove(c);
                                break;
                            }
                        }
                    }
                }
                
                if(request.getParameter("update") != null){
                    int id = Integer.parseInt(request.getParameter("update"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    Product product = dao.getOne(id);
                    if (product != null) {
                        for (Cart c : list) {
                            if (c.getProduct().getPid() == product.getPid()) {
                                c.setQuantity(quantity);
                                break;
                            }
                        }
                    }
                }

                for (Cart c : list) {
                    total += c.getQuantity() * c.getProduct().getProduct_price();
                }
            }

            request.setAttribute("cart", list);
            session.setAttribute("cart", list);
            request.setAttribute("total", total);
            request.getRequestDispatcher("viewordercart.jsp").forward(request, response);
        } else {
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
        if (request.getParameter("coupon") != null) {
            DAODiscount disDAO = new DAODiscount();
            Discount discount = disDAO.checkCoupon(request.getParameter("coupon"));
            PrintWriter out = response.getWriter();
            if (discount == null) {
                out.println(0);
            } else {
                out.println(discount.getDiscount_number());
            }
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
