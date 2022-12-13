/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlller;

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
import model.Product;
import model.User;

/**
 *
 * @author Nhat Anh
 */
public class AddToCart extends HttpServlet {

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
        if(session.getAttribute("account") == null){
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
        User user = (User) session.getAttribute("account");
        
        ArrayList<Cart> cart = null;
        Product product = null;
        
        if(session.getAttribute("cart") != null){
            cart = (ArrayList)session.getAttribute("cart");
            System.out.println(cart);
        }
        
        // truong hop trong cart == null
        if(cart == null || cart.size() == 0){
//            System.out.println("Truong hop cart null");
            if(request.getParameter("id") != null && request.getParameter("id") != ""){
                int id = Integer.parseInt(request.getParameter("id"));
                product = dao.getOne(id);
                cart = new ArrayList<>();
                if(product != null){
                    Cart new_item = new Cart(product, user.getId(), 1);
                    cart.add(new_item);
                    session.setAttribute("cart", cart);
                }
            } 
        }
        else if(cart != null && cart.size() > 0){
            System.out.println("Truong hop cart not null");
            if(request.getParameter("id") != null && request.getParameter("id") != ""){
                int id = Integer.parseInt(request.getParameter("id"));
                product = dao.getOne(id);
                
                if(product != null){
                    // truong hop da co san pham
                    boolean flag = false;
                    for (Cart c: cart){
                        if(c.getProduct().getPid() == product.getPid()){
                            c.setQuantity(c.getQuantity() + 1);
                            flag = true;
                            System.out.println("Da co san pham");
                            break;
                        }
                    }
                    //truong hop chua co
                    if(flag == false){
                        System.out.println("Chua co san pham");
                        Cart new_item = new Cart(product, user.getId(), 1);
                        cart.add(new_item);
                    }
                }
                session.setAttribute("cart", cart);
            } 
        }
        response.sendRedirect("./list");
        
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
        processRequest(request, response);
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
