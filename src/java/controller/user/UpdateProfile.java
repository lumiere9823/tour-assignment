/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author bravee06
 */
@WebServlet(name = "UpdateProfile", urlPatterns = {"/update_profile"})
public class UpdateProfile extends HttpServlet {

   
 
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            int id = Integer.parseInt("id");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String password = request.getParameter("pass");
            HttpSession session = request.getSession();
            UserDao ud = new UserDao();
            User us = new User();
            us.setId(id);
            us.setName(name);
            us.setPhone(phone);
            us.setPassword(password);
            if(ud.checkPassword(id, password)){
                if(ud.updateProfile(us)){
                      session.setAttribute("successMsg", "Update profile  sucess");
            response.sendRedirect("sell_book.jsp");
        }else{
            session.setAttribute("failedMsg", "Update failed");
            response.sendRedirect("sell_book.jsp");
            
        }
       
    }
        }catch(Exception e){
           e.printStackTrace();
        }

  
}
}
