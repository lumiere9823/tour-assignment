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

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("home.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("fname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String pass = request.getParameter("pass");
        String check = request.getParameter("check");
        System.out.println(check);
        User user = new User();
        user.setName(name);
        user.setPassword(pass);
        user.setEmail(email);
        user.setPhone(phone);
        HttpSession session = request.getSession();
        
        if (check != null) {
            UserDao userDao = new UserDao();
            if (userDao.userRegister(user)) {
                session.setAttribute("successMsg", "Register Success");
                response.sendRedirect("register.jsp");
            } else {
                session.setAttribute("failedMsg", "Something wrong on server");
                response.sendRedirect("register.jsp");
            }
        }else{
            session.setAttribute("errorMsg", "Must agree all term of us !");
            response.sendRedirect("register.jsp");
        }

    }

}
