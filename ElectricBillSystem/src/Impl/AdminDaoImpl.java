package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import DAO.AdminDao;
import POJO.Admin;
import POJO.Bill;
import POJO.Billdetails;
import POJO.CustomerDetails;
import POJO.Login;
import POJO.NewCustomer;
import POJO.Paybill;
import POJO.Tax;
import POJO.Payment;
import POJO.Payment1;
import POJO.Rbill;
import Utility.DButility;

public class AdminDaoImpl implements AdminDao {
     LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDateTime = dt.format(format);

    @Override
    public Admin LoginAdmin(String adminUsername, String adminpassword) {
        Connection con = DButility.getConnect();
        String sql = "Select * from admin where adminUsername =? and adminpassword =? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, adminUsername);
            ps.setString(2, adminpassword);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Admin a = new Admin();
                a.setAdminUsername(rs.getString("adminUsername"));
                a.setAdminEmail(rs.getString("adminEmail"));
                a.setAdminpassword(rs.getString("adminpassword"));
                return a;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addCustomer(NewCustomer n) {
        Connection con = DButility.getConnect();
        String sql1 = "insert into customer (Customer_name,Meter_no,Customer_address,City,State,Cust_phone,Meter_location ,Meter_type ,Phase_type ,Bill_type)values(?,?,?,?,?,?,?,?,?,?)";
        String sql2 = "insert into Customer_Details(Meter_no,Customer_name,Customer_address,City,State,Cust_phone)values(?,?,?,?,?,?)";
        String sql3 = "update Customer_Details set Meter_location =? ,Meter_type=?,Phase_type=? ,Bill_type=?where Meter_no = ?";
        String sql4 = "insert into login(Meter_no,Customer_name)values(?,?)";

        try {
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1, n.getCustomer_name());
            ps1.setString(2, n.getMeter_no());
            ps1.setString(3, n.getCustomer_address());
            ps1.setString(4, n.getCity());
            ps1.setString(5, n.getState());
            ps1.setString(6, n.getCust_phone());
            ps1.setString(7, n.getMeter_location());
            ps1.setString(8, n.getMeter_type());
            ps1.setString(9, n.getPhase_type());
            ps1.setString(10, n.getBill_type());
            int i = ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setString(1, n.getMeter_no());
            ps2.setString(2, n.getCustomer_name());
            ps2.setString(3, n.getCustomer_address());
            ps2.setString(4, n.getCity());
            ps2.setString(5, n.getState());
            ps2.setString(6, n.getCust_phone());
            int j = ps2.executeUpdate();

            PreparedStatement ps3 = con.prepareStatement(sql3);
            ps3.setString(1, n.getMeter_location());
            ps3.setString(2, n.getMeter_type());
            ps3.setString(3, n.getPhase_type());
            ps3.setString(4, n.getBill_type());
            ps3.setString(5, n.getMeter_no());
            int k = ps3.executeUpdate();

            PreparedStatement ps4 = con.prepareStatement(sql4);
            ps4.setString(1, n.getMeter_no());
            ps4.setString(2, n.getCustomer_name());
            int l = ps4.executeUpdate();

            if (i > 0 || j > 0 || k > 0 || l > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Update(NewCustomer a) {
        Connection con = DButility.getConnect();
        String sql5 = "update Customer_Details set Customer_name=?,Customer_address=?,City=?,State=?,Cust_phone=?, Meter_location =?,Meter_type=?,Phase_type=? ,Bill_type=? where Meter_no = ?;";
        try {
            PreparedStatement ps5 = con.prepareStatement(sql5);
            ps5.setString(1, a.getCustomer_name());
            ps5.setString(2, a.getCustomer_address());
            ps5.setString(3, a.getCity());
            ps5.setString(4, a.getState());
            ps5.setString(5, a.getCust_phone());
            ps5.setString(6, a.getMeter_location());
            ps5.setString(7, a.getMeter_type());
            ps5.setString(8, a.getPhase_type());
            ps5.setString(9, a.getBill_type());
            ps5.setString(10, a.getMeter_no());
            int i = ps5.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<NewCustomer> UpdateCustomerbyMeter_no(String Meter_no) {
        Connection con = DButility.getConnect();
        String sql6 = "select * from Customer  where Meter_no =?";
        try {
            PreparedStatement ps6 = con.prepareStatement(sql6);
            ps6.setString(1, Meter_no);
            ResultSet rs = ps6.executeQuery();
            List<NewCustomer> clist = new LinkedList<>();
            while (rs.next()) {
                NewCustomer a = new NewCustomer();
                a.setCustomer_name(rs.getString("Customer_name"));
                a.setMeter_no(rs.getString("Meter_no"));
                a.setCustomer_address(rs.getString("Customer_address"));
                a.setCity(rs.getString("City"));
                a.setState(rs.getString("State"));
                a.setCust_phone(rs.getString("Cust_phone"));
                a.setMeter_location(rs.getString("Meter_location"));
                a.setMeter_type(rs.getString("Meter_type"));
                a.setPhase_type(rs.getString("Phase_type"));
                a.setBill_type(rs.getString("Bill_type"));
                clist.add(a);
            }
            return clist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean Update1(NewCustomer a) {
        Connection con = DButility.getConnect();
        String sql7 = "update Customer set Customer_name=?,Customer_address=?,City=?,State=?,Cust_phone=?, Meter_location =?,Meter_type=?,Phase_type=? ,Bill_type=? where Meter_no = ?;";
        try {
            PreparedStatement ps7 = con.prepareStatement(sql7);
            ps7.setString(1, a.getCustomer_name());
            ps7.setString(2, a.getCustomer_address());
            ps7.setString(3, a.getCity());
            ps7.setString(4, a.getState());
            ps7.setString(5, a.getCust_phone());
            ps7.setString(6, a.getMeter_location());
            ps7.setString(7, a.getMeter_type());
            ps7.setString(8, a.getPhase_type());
            ps7.setString(9, a.getBill_type());
            ps7.setString(10, a.getMeter_no());
            int j = ps7.executeUpdate();
            if (j > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update2(Login l) {
        Connection con = DButility.getConnect();
        String c = "update login set Customer_name = ? where Meter_no = ?";
      try {
        PreparedStatement b = con.prepareStatement(c);
        b.setString(1, l.getCustomer());
        b.setString(2, l.getMeter_no());
        int j = b.executeUpdate();
        if (j > 0) {
            return true;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
        return false;
    }

    @Override
    public boolean Calculatebill(Bill b) {
        Connection con = DButility.getConnect();
        String units = b.getUnit();
        int unit_consumed = Integer.parseInt(units);
        int totalbill = 0;
        String sql8 = "Select * from tax";
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql8);
            while (rs.next()) {
                totalbill += unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                totalbill += Integer.parseInt(rs.getString("meter_rent"));
                totalbill += Integer.parseInt(rs.getString("service_charge"));
                totalbill += Integer.parseInt(rs.getString("service_tax"));
                totalbill += Integer.parseInt(rs.getString("GST"));
                totalbill += Integer.parseInt(rs.getString("fixed_tax"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        String q = "insert into bill(meter_no,month,units,totalbill)values(?,?,?,?)";
        String a = "insert into billdetails(meter_no,month,units,totalbill)values(?,?,?,?)";
        String sql10 = "update Customer_Details set month=?,units=?,totalbill=? where Meter_no = ?";

        try {

            PreparedStatement pqs = con.prepareStatement(q);
            pqs.setString(1, b.getMeter_no());
            pqs.setString(2, b.getMonth());
            pqs.setString(3, b.getUnit());
            pqs.setDouble(4, totalbill);
            int m = pqs.executeUpdate();

            PreparedStatement pq3 = con.prepareStatement(a);
            pq3.setString(1, b.getMeter_no());
            pq3.setString(2, b.getMonth());
            pq3.setString(3, b.getUnit());
            pq3.setDouble(4, totalbill);
            int k = pq3.executeUpdate();

            PreparedStatement ps10 = con.prepareStatement(sql10);
            ps10.setString(1, b.getMonth());
            ps10.setString(2, b.getUnit());
            ps10.setInt(3, totalbill);
            ps10.setString(4, b.getMeter_no());
            int j = ps10.executeUpdate();

            if (m > 0 || j > 0 || k > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public CustomerDetails FullCustomerDetails(String Meter_no) {
        Connection con = DButility.getConnect();
        String sql11 = "select * from Customer_Details where Meter_no =?";
        try {
            PreparedStatement ps11 = con.prepareStatement(sql11);
            ps11.setString(1, Meter_no);
            ResultSet rs = ps11.executeQuery();
            if (rs.next()) {
                CustomerDetails e = new CustomerDetails();
                e.setMeter_no(rs.getString(1));
                e.setCustomer_name(rs.getString(2));
                e.setCustomer_address(rs.getString(3));
                e.setCity(rs.getString(4));
                e.setState(rs.getString(5));
                e.setCust_phone(rs.getString(6));
                e.setMeter_location(rs.getString(7));
                e.setMeter_type(rs.getString(8));
                e.setPhase_type(rs.getString(9));
                e.setBill_type(rs.getString(10));
                e.setMonth(rs.getString(11));
                e.setUnit(rs.getString(12));
                e.setTotalbill(rs.getString(13));
                return e;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Paybill> Adminpaybill(String Meter_no, String month) {
        Connection con = DButility.getConnect();
        String sql6 = "select meter_no,month,totalbill from bill where meter_no =? and month = ?";
        try {
            PreparedStatement ps6 = con.prepareStatement(sql6);
            ps6.setString(1, Meter_no);
            ps6.setString(2, month);
            ResultSet rs = ps6.executeQuery();
            List<Paybill> pblist = new LinkedList<>();
            while (rs.next()) {
                Paybill b = new Paybill();
                b.setMeter_no(rs.getString("meter_no"));
                b.setMonth(rs.getString("month"));
                b.setTotalbill(rs.getString("totalbill"));
                pblist.add(b);
            }
            return pblist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean Adminpayment(Payment p) {
        Bill b1 = new Bill();
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDateTime = dt.format(format);

        double totalBill = calculateBill(p.getMeter_no());
        Connection con = DButility.getConnect();
        String sql = "insert into payment(PaymentDate,Meter_no,totalBill,PaymentStatus)values(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(formattedDateTime));
            ps.setString(2, p.getMeter_no());
            ps.setDouble(3, totalBill);
            ps.setString(4, p.getPaymentStatus());
            int i = ps.executeUpdate();

            if (i > 0) {

                new AdminDaoImpl().AdmindeleteBill(b1.getMonth());
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private double calculateBill(String Meter_no) {
        Connection con = DButility.getConnect();
        String sql = "select totalbill from bill where Meter_no=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Meter_no);
            ResultSet rs = ps.executeQuery();
            double totalBill = 0;
            while (rs.next()) {
                totalBill += rs.getDouble("totalbill");
            }
            return totalBill;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean AdmindeleteBill(String Month) {
        Connection con = DButility.getConnect();
        String sql = "delete from bill where month =? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Month);
            int i = ps.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean billdetails(Billdetails b) {
        Connection con = DButility.getConnect();
        String z = "update billdetails set status = ? where meter_no =? and month = ?";
        try {
            PreparedStatement pq9 = con.prepareStatement(z);
            pq9.setString(1, b.getStatus());
            pq9.setString(2, b.getMeter_no());
            pq9.setString(3, b.getMonth());
            int o = pq9.executeUpdate();
            if (o > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public NewCustomer CustomerDetails(String Meter_no) {
        Connection con = DButility.getConnect();
        String sql11 = "select * from customer where Meter_no =?";
        try {
            PreparedStatement ps11 = con.prepareStatement(sql11);
            ps11.setString(1, Meter_no);
            ResultSet rs = ps11.executeQuery();
            if (rs.next()) {
                NewCustomer e =  new NewCustomer();
                e.setCustomer_name(rs.getString(2));
                e.setMeter_no(rs.getString(3));
                e.setCustomer_address(rs.getString(4));
                e.setCity(rs.getString(5));
                e.setState(rs.getString(6));
                e.setCust_phone(rs.getString(7));
                e.setMeter_location(rs.getString(8));
                e.setMeter_type(rs.getString(9));
                e.setPhase_type(rs.getString(10));
                e.setBill_type(rs.getString(11));
                e.setDays(rs.getString(12));
                return e;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Tax Taxinfo(Tax t) {
        Connection con = DButility.getConnect();
        String sql11 = "select * from tax";
        try {
            PreparedStatement ps11 = con.prepareStatement(sql11);
            ResultSet rs = ps11.executeQuery();
            if (rs.next()) {
                Tax e =  new Tax();
                e.setCost_per_unit(rs.getString(1));
                e.setMeter_rent(rs.getString(2));
                e.setService_charge(rs.getString(3));
                e.setService_tax(rs.getString(4));
                e.setGST(rs.getString(5));
                e.setFixed_tax(rs.getString(6));
                return e;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Rbill bill(String month) {
        Connection con = DButility.getConnect();
        String sql11 = "select month,units,totalbill,status from billdetails where month =?";
        try {
            PreparedStatement ps11 = con.prepareStatement(sql11);
            ps11.setString(1,month);
            ResultSet rs = ps11.executeQuery();
            if (rs.next()) {
                Rbill e =  new Rbill();
                e.setMonth(rs.getString(1));
               e.setUnit(rs.getString(2));
               e.setTotalbill(rs.getString(3));
               e.setStatus(rs.getString(4));
                return e;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Payment1 rpay(Payment1 p1) {
        Connection con = DButility.getConnect();
        String sql11 = "select PaymentDate ,PaymentStatus from payment";
        try {
            PreparedStatement ps11 = con.prepareStatement(sql11);
            ResultSet rs = ps11.executeQuery();
            if (rs.next()) {
                Payment1 p =  new Payment1();
                p.setPaymentDate(rs.getTimestamp(1).toLocalDateTime());
                p.setPaymentStatus(rs.getString(2));
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
