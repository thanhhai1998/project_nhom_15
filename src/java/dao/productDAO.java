/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBconnect;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.product;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.user;

/**
 *
 * @author ASUS
 */
 /**
 *
 * @author ASUS
 */
 /**
 *
 * @author ASUS
 *//**
 *
 * @author ASUS
 */
public class productDAO {

    public ArrayList<product> getListProductByCategory(long category_id) throws SQLException {
        Connection connection = DBconnect.getConnecttion();
        String sql = "SELECT * from product where category_id = '" + category_id + "'";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<product> list = new ArrayList<>();
        while (rs.next()) {
            product pro = new product();
            pro.setProductID(rs.getLong("product_id"));
            pro.setProductName(rs.getString("product_name"));
            pro.setProductImage(rs.getString("product_image"));
            pro.setProductPrice(rs.getDouble("product_price"));
            pro.setProductDescription(rs.getString("product_description"));
            list.add(pro);
        }
        return list;
    }

    public ArrayList<product> getAllProduct() throws SQLException {
        Connection connection = DBconnect.getConnecttion();
        String sql = "SELECT * from product";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<product> list = new ArrayList<>();
        while (rs.next()) {
            product pro = new product();
            pro.setProductID(rs.getLong("product_id"));
            pro.setProductName(rs.getString("product_name"));
            pro.setProductImage(rs.getString("product_image"));
            pro.setProductPrice(rs.getDouble("product_price"));
            pro.setCategoryID(rs.getLong("category_id"));
            pro.setProductDescription(rs.getString("product_description"));
            list.add(pro);
        }
        return list;
    }
// public ArrayList<product> getAllProduct() throws SQLException {
//        Connection connection = DBconnect.getConnecttion();
//        String sql = "SELECT * from product";
//        PreparedStatement ps = connection.prepareCall(sql);
//        ResultSet rs = ps.executeQuery();
//        ArrayList<product> list = new ArrayList<>();
//        while (rs.next()) {
//            product pro = new product();
//            pro.setProductID(rs.getLong("product_id"));
//            pro.setProductName(rs.getString("product_name"));
//            byte[] imgData = rs.getBytes("product_image"); // blob field  
//             
//
//            String encode = Base64.getEncoder().encodeToString(imgData); 
//            pro.setProductImage(encode);
//            pro.setProductPrice(rs.getDouble("product_price"));
//            pro.setProductDescription(rs.getString("product_description"));
//            list.add(pro);
//        }
//        return list;
//    }

    public boolean insertProduct(product u, Long category_id) {
        Connection connection = DBconnect.getConnecttion();
        String sql = "INSERT INTO product VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1, u.getProductID());
            ps.setLong(2, category_id);
            ps.setString(3, u.getProductName());
            ps.setString(4, u.getProductImage());
            ps.setDouble(5, u.getProductPrice());
            ps.setString(6, "");
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean editProduct(product u, Long category_id) {
        Connection connection = DBconnect.getConnecttion();
        String sql = "UPDATE product SET product_name = ?, product_price = ?,product_image = ?,category_id = ? WHERE product_id = ?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, u.getProductName());
            ps.setDouble(2, u.getProductPrice());
            ps.setString(3, u.getProductImage());
            ps.setLong(4, category_id);
            ps.setLong(5, u.getProductID());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void delete(Long id) {
        String sql = "DELETE FROM product WHERE product_id=?";
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

    public product getProduct(long productID) throws SQLException {
        Connection connection = DBconnect.getConnecttion();
        String sql = "SELECT * FROM product  WHERE product_id = '" + productID + "'";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        product product = new product();
        while (rs.next()) {
            product.setProductID(rs.getLong("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductImage(rs.getString("product_image"));
            product.setCategoryID(rs.getLong("category_id"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setProductDescription(rs.getString("product_description"));
        }
        return product;
    }

    public static void main(String[] args) throws SQLException {
        productDAO dao = new productDAO();
        for (product p : dao.getListProductByCategory(2)) {
        }
    }
}
