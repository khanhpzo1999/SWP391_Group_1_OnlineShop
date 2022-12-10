/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author Nhat Anh
 */
public class ViewListComingProductServlet extends HttpServlet {

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
//        String id = request.getParameter("id");
//        String page = request.getParameter("page");
//        ProductDAO dao = new ProductDAO();
//        List<Product> listAllComingProduct = dao.getListComingProduct();
//        if (page == null) {
//            List<Product> listProductByCategory = dao.getProductBypage(listAllComingProduct, 1);
//            request.setAttribute("listProductByCategory", listProductByCategory);
//        } else {
//            List<Product> listProductByCategory = dao.getProductBypage(listAllComingProduct, Integer.parseInt(page));
//            request.setAttribute("listProductByCategory", listProductByCategory);
//        }
//        List<Product> listComingProduct= dao.getListComingProduct();
//        double productSize = listAllComingProduct.size();
//        double productPerPage = 9;
//        request.setAttribute("id", Integer.parseInt(id));
//        request.setAttribute("totalPage", Math.ceil(productSize / productPerPage));
//        request.setAttribute("listCategory", listComingProduct);
//        request.setAttribute("listAllComingProduct", listAllComingProduct);
//        request.getRequestDispatcher("category.jsp").forward(request, response);

        ProductDAO dao = new ProductDAO();
        List<Product> listComingProduct = dao.getListComingProduct();
        request.setAttribute("listAllComingProduct", listComingProduct);
        request.getRequestDispatcher("viewlistcomingproduct.jsp").forward(request, response);
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
