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
import model.Product;

/**
 *
 * @author Nhat Anh
 */
public class SearchComingProduct extends HttpServlet {

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
        ProductDAO dao = new ProductDAO();
        String name = request.getParameter("search");
        try (PrintWriter out = response.getWriter()) {
            ArrayList<Product> list = dao.searchProduct(name, true);
            if (list != null && list.size() > 0) {
                for (Product product : list) {
                    out.println(
                        "<div class=\"col-lg-4 col-md-6\">\n"
                        + "                                    <div class=\"single-product\">\n"
                        + "                                        <img class=\"img-fluid\" src=\""+ product.getProduct_thumbnail() +"\" alt=\"\">\n"
                        + "                                        <div class=\"product-details\">\n"
                        + "                                            <h6>"+ product.getProduct_name() +"</h6>\n"
                        + "                                            <div class=\"price\">\n"
                        + "                                                <h6>$"+ product.getProduct_price() +"</h6>\n"
                        + "                                            </div>\n"
                        + "                                            <div class=\"prd-bottom\">\n"
                        + "\n"
                        + "                                                <a href=\"javascript:void(0)\"\n"
                        + "                                                   onclick=\"addToCart("+ product.getPid() +")\"\n"
                        + "                                                   class=\"social-info\">\n"
                        + "                                                    <span class=\"ti-bag\"></span>\n"
                        + "                                                    <p class=\"hover-text\">add to bag</p>\n"
                        + "                                                </a>\n"
                        + "                                                <a href=\"\" class=\"social-info\">\n"
                        + "                                                    <span class=\"lnr lnr-heart\"></span>\n"
                        + "                                                    <p class=\"hover-text\">Wishlist</p>\n"
                        + "                                                </a>\n"
                        + "                                                <a href=\"\" class=\"social-info\">\n"
                        + "                                                    <span class=\"lnr lnr-move\"></span>\n"
                        + "                                                    <p class=\"hover-text\">view more</p>\n"
                        + "                                                </a>\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                </div>"
                );
                    out.println();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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
