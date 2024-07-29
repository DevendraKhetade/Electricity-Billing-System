package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAO.AddAdminDao;
import POJO.Admin;
import Utility.DButility;

public class AddAdminDaoImpl implements AddAdminDao {

    @Override
    public boolean AddAdmin(Admin a) {
        Connection con = DButility.getConnect();
        String sql = "insert into admin (adminUsername, adminEmail, adminpassword) values(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a.getAdminUsername());
            ps.setString(2, a.getAdminEmail());
            ps.setString(3, a.getAdminpassword());

            int i = ps.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean DeleteAdmin(String emailId) {
        Connection con = DButility.getConnect();
        String sql = "delete from admin where adminEmail = ? ;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emailId);
            int i = ps.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean UpdateAdmin(Admin a1) {
        Connection con = DButility.getConnect();
        String sql = "update admin set adminUsername =?,adminpassword=? where adminEmail=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a1.getAdminUsername());
            ps.setString(2, a1.getAdminpassword());
            ps.setString(3, a1.getAdminEmail());
            int i = ps.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Admin searchByEmailId(String emailId) {
        Connection con = DButility.getConnect();
        String sql = "select * from admin where adminEmail=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emailId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Admin c = new Admin();
                c.setAdminUsername(rs.getString(1));
                c.setAdminEmail(rs.getString(2));
                c.setAdminpassword(rs.getString(3));
                return c;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Admin> getAllAdmin() {
        Connection con = DButility.getConnect();
        List<Admin> l = new ArrayList<>();
        String sql = "select * from admin;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Admin c1 = new Admin();
                c1.setAdminUsername(rs.getString(1));
                c1.setAdminEmail(rs.getString(2));
                c1.setAdminpassword(rs.getString(3));
                l.add(c1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return l;
    }

}
