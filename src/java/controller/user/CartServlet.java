/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.CartDAO;
import dal.TourDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Tour;
import model.Cart;

/**
 *
 * @author bravee06
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            try{
                int tid = Integer.parseInt(request.getParameter("id"));
                int userid= Integer.parseInt(request.getParameter("uid"));
                TourDAO tourDAO = new TourDAO();
                Tour b = tourDAO.getTourById(tid);
                CartDAO cartDao = new CartDAO();
                Cart c = new Cart();
                c.setTid(tid);
                c.setAuthor(b.getAuthor());
                c.setTourname(b.getName());
                c.setPrice(b.getPrice());
                c.setUserId(userid);
                c.setTotal(b.getPrice());
                
                HttpSession session = request.getSession();
                if(cartDao.addCart(c)){
                    session.setAttribute("addCart","Tour Added to cart");
                    response.sendRedirect("cart.jsp");
                    
                    
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
}
