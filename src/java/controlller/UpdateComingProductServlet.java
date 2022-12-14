/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlller;

import dao.DAOComingProduct;
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
import model.ComingProduct;

/**
 *
 * @author hung tran
 */
public class UpdateComingProductServlet extends HttpServlet {

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
        String id = request.getParameter("id");
        DAOComingProduct dao = new DAOComingProduct();
        ComingProduct cp = dao.getById(id);
        request.setAttribute("id", id);
        request.setAttribute("cpInfor", cp);
        request.getRequestDispatcher("updatecomingproduct.jsp").forward(request, response);
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
        DAOComingProduct dao = new DAOComingProduct();
        String product_name = request.getParameter("product_name");
        float product_price = Float.parseFloat(request.getParameter("product_price"));
        boolean product_coming = true;
//        String product_thumbnail = request.getParameter("product_thumbnail");
        boolean product_status = false;
        String product_description = request.getParameter("product_description");
        int product_quantity = 0;
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        String id = request.getParameter("id");
         String image = request.getParameter("image");
//        System.out.println("C:\\Users\\Nhat Anh\\Downloads\\image\\"+image);
        String absolutepath = "C:\\Users\\Nhat Anh\\Downloads\\image\\" + image;
        String newpath = "C:\\SWP391\\FULearning_Fall2022_SWP391\\Day1\\SourceCode\\SWP391_Group_1_OnlineShop\\web\\img\\"
                + System.currentTimeMillis() + image;
        String product_thumbnail = "img\\" + System.currentTimeMillis() + image;
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
            dao.updateComingProduct(product_name, product_price, product_coming, product_thumbnail, product_status, product_description, product_quantity, category_id, Integer.parseInt(id));
        } catch (Exception ex) {
            Logger.getLogger(UpdateComingProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("view-coming-product.jsp");
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
