package dao;

import connect.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import model.Bill;
import model.user;

public class BillDAO {

    public void insertBill(Bill bill) throws SQLException {
        Connection connection = DBconnect.getConnecttion();
        String sql = "INSERT INTO bill VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setLong(1, bill.getBillID());
        ps.setLong(2, bill.getUserID());
        ps.setDouble(3, bill.getTotal());
        ps.setString(4, bill.getPayment());
        ps.setString(5, bill.getAddress());
        ps.setTimestamp(6, bill.getDate());
        ps.executeUpdate();
    }

    public ArrayList<Bill> getAllBill() throws SQLException {
        Connection connection = DBconnect.getConnecttion();
        String sql = "SELECT * from bill";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Bill> list = new ArrayList<>();
        while (rs.next()) {
            Bill pro = new Bill();
            pro.setUserID(rs.getLong("user_id"));
            pro.setBillID(rs.getLong("bill_id"));
            pro.setTotal(rs.getLong("total"));
            pro.setPayment(rs.getString("payment"));
            pro.setAddress(rs.getString("address"));
            pro.setDate(rs.getTimestamp("date"));
            list.add(pro);
        }
        return list;
    }

    public void delete(Long id) {
        String sql = "DELETE FROM bill WHERE bill_id=?";
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

    public static void main(String[] args) throws SQLException {
        new BillDAO().insertBill(new Bill(0, 0, 0, "s", "s", new Timestamp(new Date().getTime())));
    }
}
