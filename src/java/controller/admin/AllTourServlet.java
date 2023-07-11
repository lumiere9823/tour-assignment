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
import java.util.List;
import model.Tour;

/**
 *
 * @author bravee06
 */
@WebServlet(name = "AllTourServlet", urlPatterns = {"/all_tour"})
public class AllTourServlet extends HttpServlet {

  

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TourDAO tourDao = new TourDAO();
        HttpSession session = request.getSession();
        List<Tour> listTour = tourDao.getAllTour();
        if(listTour != null){
            
    
        session.setAttribute("listTour", listTour);
        response.sendRedirect("admin/all_tours.jsp");
        }else{
            System.out.println("Dont exist book");
        }
        
        
        
        
    }

   
}
