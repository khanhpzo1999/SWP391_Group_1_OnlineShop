/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlller;

import dao.ProductDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author Computer
 */
public class UpdateProductServlet extends HttpServlet {

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
        String pid = request.getParameter("id");
        ProductDAO dao = new ProductDAO();
        Product p = dao.getProductByName(Integer.parseInt(pid));
        request.setAttribute("p", p);
        request.setAttribute("pid", pid);
        request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
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
        String product_name = request.getParameter("product_name");
        String product_price = request.getParameter("product_price");
        String product_description = request.getParameter("product_description");
        int pid = Integer.parseInt(request.getParameter("pid"));
        String image = request.getParameter("image");
//        System.out.println("C:\\Users\\Nhat Anh\\Downloads\\image\\"+image);
        String absolutepath = "C:\\Users\\Nhat Anh\\Downloads\\image\\" + image;
        String newpath = "C:\\SWP391\\FULearning_Fall2022_SWP391\\Day1\\SourceCode\\SWP391_Group_1_OnlineShop\\web\\img\\"
                + System.currentTimeMillis() + image;
        String pthumbnail = "img\\" + System.currentTimeMillis() + image;
        try {
            File fileToMove = new File(absolutepath);
//            boolean isMoved = fileToMove.renameTo(new File(newpath));
//            if (!isMoved) {
//                throw new FileSystemException(newpath);
//            }
            Files.copy(fileToMove.toPath(), new File(newpath).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dao.updateProduct(product_name, Float.parseFloat(product_price), product_description,pthumbnail, pid);
        } catch (Exception e) {
            Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        response.sendRedirect("productManagement");
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
