/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.TourDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.util.UUID;
import model.Tour;

/**
 *
 * @author bravee06
 */
@WebServlet(name = "AddTourServlet", urlPatterns = {"/add_tour"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB 
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100)

public class AddTourServlet extends HttpServlet {

    private static final String UPLOAD_DIRECTORY = "D:\\PRJ\\TourAssignment\\web\\tour"; // Change this to your desired upload directory

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));
        String category = request.getParameter("category");
        String status = request.getParameter("status");

        // Create the upload directory if it doesn't exist
        File uploadDir = new File(UPLOAD_DIRECTORY);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Get the uploaded file
        Part filePart = request.getPart("bimg");
        String fileName = filePart.getSubmittedFileName();

        // Save the file to the upload directory
        filePart.write(UPLOAD_DIRECTORY + File.separator + fileName);
        Tour newTour = new Tour();

        newTour.setName(name);
        newTour.setAuthor(author);
        newTour.setPrice(price);
        newTour.setCategory(category);
        newTour.setStatus(status);
        newTour.setPhoto(fileName);
        newTour.setUser_email("admin");

        HttpSession session = request.getSession();
        TourDAO bookDao = new TourDAO();

        if(bookDao.addTour(newTour)){
            session.setAttribute("successMsg", "Add tour sucess");
            response.sendRedirect("admin/add_tour.jsp");
        }else{
            session.setAttribute("failedMsg", "Add tour failed");
            response.sendRedirect("admin/add_tour.jsp");
        }
    }

}
