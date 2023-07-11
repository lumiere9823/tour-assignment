package controller.admin;

import dal.TourDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Tour;

@WebServlet(name = "UpdateTourServlet", urlPatterns = {"/update_Tour"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB 
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100)
public class UpdateTourServlet extends HttpServlet {

    private static final String UPLOAD_DIRECTORY = "D:\\PRJ\\TourAssignment\\web\\tour"; // Change this to your desired upload directory

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TourDAO tourDao = new TourDAO();
        Tour tour;
        HttpSession session = request.getSession();
        try {
            tour = tourDao.getTourById(id);
            if (tour != null) {
                session.setAttribute("tour", tour);
                response.sendRedirect("admin/edit_tours.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateTourServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

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
        newTour.setId(id);
        newTour.setName(name);
        newTour.setAuthor(author);
        newTour.setPrice(price);
        newTour.setCategory(category);
        newTour.setStatus(status);
        newTour.setPhoto(fileName);
        newTour.setUser_email("admin");

        HttpSession session = request.getSession();
        TourDAO tourDao = new TourDAO();

        try {
            if (tourDao.updateTour(newTour)) {
                session.setAttribute("successMsg", "Update newTour sucess");
                response.sendRedirect("admin/edit_tours.jsp");
            } else {
                session.setAttribute("failedMsg", "Update newTour failed");
                response.sendRedirect("admin/edit_tours.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateTourServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
