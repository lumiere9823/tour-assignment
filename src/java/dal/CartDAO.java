/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cart;

/**
 *
 * @author bravee06
 */
public class CartDAO extends DBContext {

    public boolean addCart(Cart c) throws SQLException {
        String sql = "INSERT INTO [tourDB].[dbo].[Cart]\n"
                + "(\n"
                + "		 [tid]\n"
                + "		,[userid]\n"
                + "		,[tourname]\n"
                + "		,[author]\n"
                + "		,[price]\n"
                + "		,[total]\n"
                + ")\n"
                + "VALUES\n"
                + "(\n"
                + "		 ?\n"
                + "		,?\n"
                + "		,?\n"
                + "		,?\n"
                + "		,?\n"
                + "		,?\n"
                + ")";
        try ( PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, c.getTid());
            ps.setInt(2, c.getUserId());
            ps.setString(3, c.getTourname());
            ps.setString(4, c.getAuthor());
            ps.setDouble(5, c.getPrice());
            ps.setDouble(6, c.getTotal());
            ps.executeUpdate();

            
        }
        return true;
    }

    public boolean deleteTour(int cid) throws SQLException {
        String sql = "delete from [Cart] where cid = ?";
        try ( PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, cid);

            if (ps.executeUpdate() == 1) {
                return true;
            }

        }
        return false;
    }

    public List<Cart> getTourByUser(int userID) throws SQLException {
        List<Cart> list = new ArrayList<>();
        double totalPrice = 0;
        String sql = "SELECT\n"
                + "*\n"
                + "FROM\n"
                + "[Cart]\n"
                + "WHERE\n"
                + "userid=?";
        try ( PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cart c = new Cart();
                c.setCid(rs.getInt(1));
                c.setTid(rs.getInt(2));
                c.setUserId(rs.getInt(3));
                c.setTourname(rs.getString(4));
                c.setAuthor(rs.getString(5));
                c.setPrice(rs.getDouble(6));

                totalPrice += rs.getDouble(7);
                c.setTotal(totalPrice);
                list.add(c);
            }

        }
        return list;
    }

}
