/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author admin
 */
@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/ChangePasswordServlet"})
public class ChangePasswordServlet extends HttpServlet {

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
        processRequest(request, response);
        UserDAO dao = new UserDAO();
        String old_password = request.getParameter("old_password");
        String password = request.getParameter("password");
        String re_password = request.getParameter("re_password");
        User user = (User) request.getSession().getAttribute("account");

        if (dao.checkOldPassword(user, old_password) == null) {
            request.setAttribute("errorMessage", "Old Password not correct");
            request.getRequestDispatcher("change-password.jsp").forward(request, response);
        } else if (old_password.length() < 6) {
            request.setAttribute("errorMessage", "Old Password must exceed 6 characters");
            request.getRequestDispatcher("change-password.jsp").forward(request, response);
        } else if (password.length() < 6) {
            request.setAttribute("errorMessage", "Password must exceed 6 characters");
            request.getRequestDispatcher("change-password.jsp").forward(request, response);
        } else if (!password.equals(re_password)) {
            request.setAttribute("errorMessage", "Password and Re password not match");
            request.getRequestDispatcher("change-password.jsp").forward(request, response);
        } else {
            dao.changePassword(user, password);
            request.setAttribute("successMessage", "Change password successful!");
            request.getRequestDispatcher("change-password.jsp").forward(request, response);
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
