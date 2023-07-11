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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})

public class LoginServlet extends HttpServlet {

   
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao userDao = new UserDao();
        try{
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            HttpSession session = request.getSession();
            if(email.equals("admin@gmail.com") && pass.equals("a")){
                User user = userDao.userLogin(email, pass);
                session.setAttribute("userobj", user);
                response.sendRedirect("admin/home.jsp");
            }else{
                User user = userDao.userLogin(email, pass);
                if(user != null){
                    session.setAttribute("userobj", user);
                    response.sendRedirect("index.jsp");
                }else{
                    response.sendRedirect("login.jsp");
                }
                
            }
        }catch(Exception e){
            System.out.println(e);
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
