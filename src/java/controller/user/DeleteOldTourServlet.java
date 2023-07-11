/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.TourDAO;
import jakarta.servlet.annotation.WebServlet;
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
@WebServlet(name = "DeleteOldTourServlet", urlPatterns = {"/delete_old_tour"})
public class DeleteOldTourServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String em = request.getParameter("em");
        System.out.println(em);
        TourDAO bd = new TourDAO();
        HttpSession session = request.getSession();
        if(bd.oldTourDelete(em, "Old")){
            System.out.println("abc ");
             session.setAttribute("succMsg","Remove success");
                response.sendRedirect("old_tour.jsp");
            }else{
             System.out.println("abc1 ");
                session.setAttribute("failMsg","Remove unsuccess wrong on server");
                response.sendRedirect("old_tour.jsp");
        }
        
    }

}
