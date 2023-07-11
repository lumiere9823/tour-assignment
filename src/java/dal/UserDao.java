/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author bravee06
 */
public class UserDao extends DBContext {

    public boolean checkPassword(int id, String ps) {
        try {
            String sql = "select * from [User] where id = ? and password = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, ps);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public boolean updateProfile(User us) {
        try {
            String sql = "UPDATE [User] \n"
                    + "SET\n"
                    + "		 [name]=?\n"
                    + "		,[email]=?\n"
                    + "		,[phone]=?\n"
                    + "		,[password]=?\n"
                    + "WHERE id=?";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, us.getName());
            st.setString(2, us.getEmail());
            st.setString(3, us.getPhone());
            st.setString(4, us.getPassword());
            st.setInt(5, us.getId());
            int i = st.executeUpdate();
            if (i == 1) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<User> getAllUser() {
        List<User> listUser = null;
        try {
            String sql = "select * from [User]";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User newUser = new User();
                newUser.setId(rs.getInt("id"));
                newUser.setPassword(rs.getString("password"));
                newUser.setEmail(rs.getString("email"));
                newUser.setName(rs.getString("name"));
                listUser.add(newUser);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listUser;
    }

    public User userLogin(String email, String password) {
        User user = null;
        try {
            String sql = "select * from [User] where email = ? and password = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPhone(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setAddress(rs.getString(6));
                user.setLandmark(rs.getString(7));
                user.setCity(rs.getString(8));
                user.setState(rs.getString(9));
                user.setZip(rs.getString(10));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return user;

    }

    public boolean userRegister(User user) {
        try {
            String sql = "INSERT INTO [User]\n"
                    + "(\n"
                    + "		 [name]\n"
                    + "		,[email]\n"
                    + "		,[phone]\n"
                    + "		,[password]\n"
                    + ")\n"
                    + "VALUES\n"
                    + "(\n"
                    + "?,?,?,?	\n"
                    + ")";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user.getName());
            st.setString(2, user.getEmail());
            st.setString(3, user.getPhone());
            st.setString(4, user.getPassword());
            if (st.executeUpdate() == 1) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
