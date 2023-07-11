/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.TourDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author bravee06
 */
@WebServlet(name = "DeleteTourServlet", urlPatterns = {"/delete_tour"})
public class DeleteTourServlet extends HttpServlet {

   
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("id"));
       TourDAO bookDao = new TourDAO();
       HttpSession session = request.getSession();
       if(bookDao.delete(id)){
           session.setAttribute("successMsg", "Delete Tour Success Please Load Page Again");
           response.sendRedirect("all_tour");
       }else{
           session.setAttribute("failedMsg", "Delete Book Failed");
           response.sendRedirect("all_tour");
       }
       
    }

    
}
