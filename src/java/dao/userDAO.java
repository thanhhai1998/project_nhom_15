/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayListâsd
import java.util.logging.Level;
import java.util.logging.Logger;
import model.product;
import model.user;

/**
 *
 * @author ASUS
 */
public class userDAO {

    public boolean checkEmail(String email) {
        Connection connection = DBconnect.getConnecttion();
        String sql = "SELECT * from users where user_email = '" + email + "'";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                connection.close();
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public user getUser(long productID) throws SQLException {
        Connection connection = DBconnect.getConnecttion();
        String sql = "SELECT * FROM users  WHERE user_id = '" + productID + "'";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        user pro = new user();
        while (rs.next()) {
            pro.setUserID(rs.getLong("user_id"));
            pro.setFullname(rs.getString("user_fullname"));
            pro.setUserEmail(rs.getString("user_email"));
            pro.setUserPass(rs.getString("user_pass"));
        }
        return pro;
    }

    public ArrayList<user> getAllProduct() throws SQLException {
        Connection connection = DBconnect.getConnecttion();
        String sql = "SELECT * from users";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<user> list = new ArrayList<>();
        while (rs.next()) {
            user pro = new user();
            pro.setUserID(rs.getLong("user_id"));
            pro.setFullname(rs.getString("user_fullname"));
            pro.setUserEmail(rs.getString("user_email"));
            pro.setUserPass(rs.getString("user_pass"));
            list.add(pro);
        }
        return list;
    }

    public void delete(Long id) {
        String sql = "DELETE FROM users WHERE user_id=?";
        Connection con = DBconnect.getConnecttion();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean edit(user u) {
        Connection connection = DBconnect.getConnecttion();
        String sql = "UPDATE users SET user_fullname = ?, user_email = ?,user_pass = ?  WHERE user_id = ?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, u.getFullname());
            ps.setString(2, u.getUserEmail());
            ps.setString(3, u.getUserPass());
            ps.setLong(4, u.getUserID());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean insertUser(user u) {
        Connection connection = DBconnect.getConnecttion();
        String sql = "INSERT INTO users VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1, u.getUserID());
            ps.setString(2, u.getFullname());
            ps.setString(3, u.getUserEmail());
            ps.setString(4, u.getUserPass());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public user login(String email, String password) {
        Connection con = DBconnect.getConnecttion();
        String sql = "select * from users where user_email='" + email + "' and  user_pass='" + password + "'";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user u = new user();
                u.setUserEmail(rs.getString("user_email"));
                u.setUserID(rs.getLong("user_id"));
                u.setFullname(rs.getString("user_fullname"));
                u.setUserPass(rs.getString("user_pass"));
                con.close();
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public user login_admin(String email, String password) {
        Connection con = DBconnect.getConnecttion();
        String sql = "select * from admin where user_email='" + email + "' and  user_pass='" + password + "'";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user u = new user();
                u.setUserEmail(rs.getString("user_email"));
                u.setUserID(rs.getLong("user_id"));
                u.setFullname(rs.getString("user_fullname"));
                u.setUserPass(rs.getString("user_pass"));
                con.close();
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
