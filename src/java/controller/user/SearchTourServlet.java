/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.TourDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Tour;

@WebServlet(name = "SearchTourServlet", urlPatterns = {"/searchTour"})
public class SearchTourServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
            String ch = request.getParameter("ch");
            TourDAO bd = new TourDAO();
            List<Tour> listTour = bd.getTourBySearch(ch);
            HttpSession session = request.getSession();
            session.setAttribute("listTour",listTour);
            request.getRequestDispatcher("search.jsp").forward(request, response);
        
    }
}
