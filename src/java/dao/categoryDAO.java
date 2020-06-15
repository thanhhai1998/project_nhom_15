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
import model.category;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class categoryDAO {

    // lấy danh sách loại
    public ArrayList<category> getListCategory() throws SQLException {
        Connection connection = DBconnect.getConnecttion();
        String sql = "SELECT * from category";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<category> list = new ArrayList<>();
        while (rs.next()) {
            category cate = new category();
            cate.setCategoryID(rs.getInt("category_id"));
            cate.setCategoryName(rs.getString("category_name"));
            list.add(cate);
        }
        return list;
    }

    public String getCategoryName(long id) throws SQLException {
        Connection connection = DBconnect.getConnecttion();
        String sql = "SELECT category_name from category where category_id = '" + id + "'";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString("category_name");
        }
        return "";
    }

    public static void main(String[] args) throws SQLException {
        categoryDAO dao = new categoryDAO();
        for (category ds : dao.getListCategory()) {
            System.out.print(ds.getCategoryID() + "-" + ds.getCategoryName());
        }
    }
}
