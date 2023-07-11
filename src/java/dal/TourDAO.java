/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Tour;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bravee06
 */
public class TourDAO extends DBContext {
    public List<Tour> getAllNewTour(){
        List<Tour> listNew = new ArrayList<>();
        Tour b = null;
        String sql = "select * from [tourDB].[dbo].[Tour] where category=? and status = ?";
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.setString(1, "New");
            st.setString(2, "Active");
            ResultSet rs = st.executeQuery();
            
            while(rs.next() ){
                b = new Tour();
                b.setId(rs.getInt(1));
                b.setName(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getDouble(4));
                b.setCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));
                b.setUser_email(rs.getString(8));
                listNew.add(b);
                
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listNew;
    }
    
    public List<Tour> getAllRecentTour(){
        List<Tour> listRecent = new ArrayList<>();
        Tour b = null;
        String sql = "select * from [tourDB].[dbo].[Tour] where status = ? order by id DESC";
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.setString(1, "Active");
           
            ResultSet rs = st.executeQuery();
           
            while(rs.next()){
                b = new Tour();
                b.setId(rs.getInt(1));
                b.setName(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getDouble(4));
                b.setCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));
                b.setUser_email(rs.getString(8));
                listRecent.add(b);
               
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listRecent;
    }
    
    public List<Tour> getAllOldTour(){
        List<Tour> listOld = new ArrayList<>();
        Tour b = null;
        String sql = "select * from [tourDB].[dbo].[Tour] where category = ? ";
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.setString(1, "Old");
           
            ResultSet rs = st.executeQuery();
           
            while(rs.next()){
                b = new Tour();
                b.setId(rs.getInt(1));
                b.setName(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getDouble(4));
                b.setCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));
                b.setUser_email(rs.getString(8));
                listOld.add(b);
                
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listOld;
    }
    
    public List<Tour> getOldTour(){
        List<Tour> listOld = new ArrayList<>();
        Tour b = null;
        String sql = "select * from [tourDB].[dbo].[Tour] where category = ? ";
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.setString(1, "Old");
           
            ResultSet rs = st.executeQuery();
            int i = 1;
            while(rs.next() && i <= 4){
                b = new Tour();
                b.setId(rs.getInt(1));
                b.setName(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getDouble(4));
                b.setCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));
                b.setUser_email(rs.getString(8));
                listOld.add(b);
                i++;
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listOld;
    }
    public List<Tour> getRecentTour(){
        List<Tour> listRecent = new ArrayList<>();
        Tour b = null;
        String sql = "select * from [tourDB].[dbo].[Tour] where status = ? order by id DESC";
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.setString(1, "Active");
           
            ResultSet rs = st.executeQuery();
            int i = 1;
            while(rs.next() && i <= 4){
                b = new Tour();
                b.setId(rs.getInt(1));
                b.setName(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getDouble(4));
                b.setCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));
                b.setUser_email(rs.getString(8));
                listRecent.add(b);
                i++;
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listRecent;
    }
    
    public List<Tour> getNewTour(){
        List<Tour> listNew = new ArrayList<>();
        Tour b = null;
        String sql = "select * from [tourDB].[dbo].[Tour] where category=? and status = ?";
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.setString(1, "New");
            st.setString(2, "Active");
            ResultSet rs = st.executeQuery();
            int i = 1;
            while(rs.next() && i <= 4){
                b = new Tour();
                b.setId(rs.getInt(1));
                b.setName(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getDouble(4));
                b.setCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));
                b.setUser_email(rs.getString(8));
                listNew.add(b);
                i++;
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listNew;
    }

    public Tour getTourById(int id) throws SQLException {
        Tour b = null;
        try {
            String sql = "select * from Tour where id=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                b = new Tour();
                b.setId(rs.getInt(1));
                b.setName(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getDouble(4));
                b.setCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));
                b.setUser_email(rs.getString(8));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return b;
    }
    
    public List<Tour> getTourByOld(String user_email, String cate) throws SQLException {
        List<Tour> listOld = new ArrayList<>();
        Tour b = null;

        String sql = "select * from [Tour] where category = ? and user_email=? ";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, cate);
            st.setString(2, user_email);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                b = new Tour();
                b.setId(rs.getInt(1));
                b.setName(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getDouble(4));
                b.setCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));
                b.setUser_email(rs.getString(8));
                listOld.add(b);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listOld;
    }
    
    public List<Tour> getTourBySearch(String ch) {
        List<Tour> listBook = new ArrayList<>();
        Tour b = null;

        String sql = "select * from [Tour] where name like '%" + ch + "%' and status=?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, "Active");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                b = new Tour();
                b.setId(rs.getInt(1));
                b.setName(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getDouble(4));
                b.setCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));
                b.setUser_email(rs.getString(8));
                listBook.add(b);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listBook;
    }
    
    public List<Tour> getTourByName(String name) throws SQLException {
        List<Tour> a = null;
        Tour b = null;
        try {
            String sql = "select * from Tour where name like '%" + name + "%'";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                b = new Tour();
                b.setId(rs.getInt(1));
                b.setName(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getDouble(4));
                b.setCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));
                b.setUser_email(rs.getString(8));
                
                a.add(b);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return a;
    }
    
    public List<Tour> getAllTour() {
        List<Tour> listBook = new ArrayList<>();
        String sql = "select * from Tour";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String author = rs.getString(3);
                Double price = rs.getDouble(4);
                String category = rs.getString(5);
                String status = rs.getString(6);
                String img = rs.getString(7);
                String user_email = rs.getString(8);
                Tour newTour = new Tour(id, name, author, price, category, status, img, user_email);
                listBook.add(newTour);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listBook;
    }

    public boolean addTour(Tour tour) {

        String sql = "INSERT INTO [tourDB].[dbo].[Tour] "
                + "([name], [author], [price], [category], [status], [photo], [user_email]) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set the parameter values of the PreparedStatement
            statement.setString(1, tour.getName());
            statement.setString(2, tour.getAuthor());
            statement.setDouble(3, tour.getPrice());
            statement.setString(4, tour.getCategory());
            statement.setString(5, tour.getStatus());
            statement.setString(6, tour.getPhoto());
            statement.setString(7, tour.getUser_email());

            // Execute the SQL statement
            if (statement.executeUpdate() == 1) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(int id){
        String sql = "DELETE FROM [tourDB].[dbo].[Tour]\n"
                + "    WHERE id=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,id);
            if(st.executeUpdate() == 1){
                return true;
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }
    
    public boolean oldTourDelete(String email, String cate) {
        String sql = "DELETE FROM [tourDB].[dbo].[Tour]\n"
                + "    WHERE category = ? and user_email=?  ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cate);
            st.setString(2, email);
            if (st.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updateTour(Tour tour) throws SQLException {
        
        String sql = "UPDATE [tourDB].[dbo].[Tour] \n"
                + "SET\n"
                + "		 [name]=?"
                + "		,[author]=?\n"
                + "		,[price]=?\n"
                + "		,[category]=?\n"
                + "		,[status]=?\n"
                + "		,[photo]=?\n"
                + "		,[user_email]=?\n"
                + "WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set the parameter values of the PreparedStatement
            statement.setString(1, tour.getName());
            statement.setString(2, tour.getAuthor());
            statement.setDouble(3, tour.getPrice());
            statement.setString(4, tour.getCategory());
            statement.setString(5, tour.getStatus());
            statement.setString(6, tour.getPhoto());
            statement.setString(7, tour.getUser_email());
            statement.setInt(8, tour.getId());

            // Execute the SQL statement
            if (statement.executeUpdate() == 1) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;

    }
}
