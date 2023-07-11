/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bravee06
 */
@WebServlet(name = "RemoveTourCartServlet", urlPatterns = {"/remove_tour"})
public class RemoveTourCartServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      int cid = Integer.parseInt(request.getParameter("cid"));
      
      HttpSession session = request.getSession();
      CartDAO cd = new CartDAO();
        try {
            if(cd.deleteBook(cid)){
                session.setAttribute("succMsg","Remove success");
                response.sendRedirect("cart.jsp");
            }else{
                session.setAttribute("failMsg","Remove unsuccess wrong on server");
                response.sendRedirect("cart.jsp");
            }} catch (SQLException ex) {
            Logger.getLogger(RemoveTourCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

   
}
