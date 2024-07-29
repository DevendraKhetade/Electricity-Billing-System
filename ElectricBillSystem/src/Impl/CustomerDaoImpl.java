package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import DAO.CustmerDao;
import POJO.NewCustomer;
import POJO.NewCustomer1;
import POJO.Paybill;
import POJO.Payment;
import POJO.Payment1;
import POJO.Rbill;
import POJO.Bill;
import POJO.Billdetails;
import POJO.Login;
import POJO.Signin;
import POJO.Tax;
import Utility.DButility;

public class CustomerDaoImpl implements CustmerDao {

    @Override
    public boolean CustomerSignin(Signin s) {
        Connection con = DButility.getConnect();
        String sql = "update login set Username =?,Password =? where Meter_no=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getUsername());
            ps.setString(2, s.getPassword());
            ps.setString(3, s.getMeter_no());
            int i = ps.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
        return false;
    }

    @Override
    public boolean CustomerLogin(Login l) {
        Connection con = DButility.getConnect();
        // String username = l.getUsername();
        // String password = l.getPassword();
        // String meternum = l.getMeter_no();
        String sql1 = "select *  from login where Username = ? and Password = ? and Meter_no = ?";
        try {
            PreparedStatement pe = con.prepareStatement(sql1);
            pe.setString(1, l.getUsername());
            pe.setString(2, l.getPassword());
            pe.setString(3, l.getMeter_no());
            ResultSet rs = pe.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                System.out.println("invalid login");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public int NewCustomer(String Customer_name, String Meter_no, String Customer_address, String City, String State,
            String Cust_phone, String Meter_location, String Meter_type, String Phase_type, String Bill_type) {
        Connection con = DButility.getConnect();
        String sql2 = "insert into customer (Customer_name,Meter_no,Customer_address,City,State,Cust_phone,Meter_location ,Meter_type ,Phase_type ,Bill_type)values(?,?,?,?,?,?,?,?,?,?)";
        String sql3 = "insert into Customer_Details(Meter_no,Customer_name,Customer_address,City,State,Cust_phone)values(?,?,?,?,?,?)";
        String sql4 = "update Customer_Details set Meter_location =? ,Meter_type=?,Phase_type=? ,Bill_type=?where Meter_no = ?";
        String sql5 = "insert into login(Meter_no,Customer_name)values(?,?)";

        try {
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setString(1, Customer_name);
            ps2.setString(2, Meter_no);
            ps2.setString(3, Customer_address);
            ps2.setString(4, City);
            ps2.setString(5, State);
            ps2.setString(6, Cust_phone);
            ps2.setString(7, Meter_location);
            ps2.setString(8, Meter_type);
            ps2.setString(9, Phase_type);
            ps2.setString(10, Bill_type);
            int i = ps2.executeUpdate();

            PreparedStatement ps3 = con.prepareStatement(sql3);
            ps3.setString(1, Meter_no);
            ps3.setString(2, Customer_name);
            ps3.setString(3, Customer_address);
            ps3.setString(4, City);
            ps3.setString(5, State);
            ps3.setString(6, Cust_phone);
            int j = ps3.executeUpdate();

            PreparedStatement ps4 = con.prepareStatement(sql4);
            ps4.setString(1, Meter_location);
            ps4.setString(2, Meter_type);
            ps4.setString(3, Phase_type);
            ps4.setString(4, Bill_type);
            ps4.setString(5, Meter_no);
            int k = ps4.executeUpdate();

            PreparedStatement ps5 = con.prepareStatement(sql5);
            ps5.setString(1, Meter_no);
            ps5.setString(2, Customer_name);
            int l = ps5.executeUpdate();

            if (i > 0 || j > 0 || k > 0 || l > 0) {
                System.out.println("New Customer Added Successfully");
            } else {
                System.out.println("Failed To Add Customer");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Login> GetCustomerbyMeter_no(String Meter_no) {
        Connection con = DButility.getConnect();
        String sql6 = "select * from login where Meter_no =?";

        try {
            PreparedStatement ps6 = con.prepareStatement(sql6);
            ps6.setString(1, Meter_no);
            ResultSet rs = ps6.executeQuery();
            List<Login> llist = new LinkedList<>();
            while (rs.next()) {
                Login a = new Login();
                a.setMeter_no(rs.getString("Meter_no"));
                a.setUsername(rs.getString("Username"));
                a.setCustomer(rs.getString("Customer_name"));
                a.setPassword(rs.getString("Password"));
                llist.add(a);
                return llist;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<NewCustomer> Customer(String Meter_no) {
        Connection con = DButility.getConnect();
        String sql6 = "select * from Customer where Meter_no =?";
        try {
            PreparedStatement ps6 = con.prepareStatement(sql6);
            ps6.setString(1, Meter_no);
            ResultSet rs = ps6.executeQuery();
            List<NewCustomer> cdlist = new LinkedList<>();
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
                cdlist.add(a);
            }
            return cdlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public NewCustomer1 GetCustomer(String Meter_no) {
        Connection con = DButility.getConnect();
        String sql11 = "select * from customer where Meter_no =?";
        try {
            PreparedStatement ps11 = con.prepareStatement(sql11);
            ps11.setString(1, Meter_no);
            ResultSet rs = ps11.executeQuery();
            if (rs.next()) {
                NewCustomer1 e = new NewCustomer1();
                e.setMeter_no(rs.getString(3));
                e.setCustomer_name(rs.getString(2));
                e.setCustomer_address(rs.getString(4));
                e.setCity(rs.getString(5));
                e.setState(rs.getString(6));
                e.setCust_phone(rs.getString(7));
                e.setMeter_location(rs.getString(8));
                e.setMeter_type(rs.getString(9));
                e.setPhase_type(rs.getString(10));
                e.setBill_type(rs.getString(11));
                return e;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Bill searchbill(String Meter_no,String month) {
        Connection con = DButility.getConnect();
        String sql = "select * from billdetails where meter_no = ? and month = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Meter_no);
            ps.setString(2, month);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Bill b1 = new Bill();
                b1.setMeter_no(rs.getString(1));
                b1.setMonth(rs.getString(2));
                b1.setUnit(rs.getString(3));
                b1.setTotalbill(rs.getString(4));
                b1.setStatus(rs.getString(5));
                return b1;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Paybill> paybill(String Meter_no, String month) {
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
    public boolean payment(Payment p) {
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
                Bill b1  =  new Bill();
                new CustomerDaoImpl().deleteBill(b1.getMonth());
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
    public boolean deleteBill(String Month) {
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
    public List<Login> login(String Meter_no) {
        Connection con = DButility.getConnect();
        String l = "select *  from login where Meter_no =?";
        try {
            PreparedStatement po = con.prepareStatement(l);
            po.setString(1, Meter_no);
            ResultSet rs = po.executeQuery();
            List<Login> qList = new LinkedList<>();
            while (rs.next()) {
                Login l1 = new Login();
                l1.setMeter_no(rs.getString("Meter_no"));
                l1.setUsername(rs.getString("Username"));
                l1.setCustomer(rs.getString("Customer_name"));
                l1.setPassword(rs.getString("Password"));
                qList.add(l1);
            }
            return qList;
                } catch (Exception e) {
                    e.printStackTrace();
        }

        return null;
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

    @Override
    public List<Login> UpdateLoginbyMeter_no(String Meter_no) {
        Connection con = DButility.getConnect();
        String sql6 = "select * from login where Meter_no =?";
        try {
            PreparedStatement ps6 = con.prepareStatement(sql6);
            ps6.setString(1, Meter_no);
            ResultSet rs = ps6.executeQuery();
            List<Login> clist = new LinkedList<>();
            while (rs.next()) {
                Login a = new Login();
                a.setMeter_no(rs.getString("Meter_no"));
                a.setUsername(rs.getString("Username"));
                a.setCustomer(rs.getString("Customer_name"));
                a.setPassword(rs.getString("Password"));
                clist.add(a);
            }
            return clist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean Update(Login l) {
        Connection con = DButility.getConnect();
        String sql5 = "update login set USername=?,Password = ? where Meter_no = ?;";
        try {
            PreparedStatement ps5 = con.prepareStatement(sql5);
            ps5.setString(1, l.getUsername());
            ps5.setString(2, l.getPassword());
            ps5.setString(3, l.getMeter_no());
            int i = ps5.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
