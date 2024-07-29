package DAO;

import java.util.List;
import POJO.Admin;
import POJO.Bill;
import POJO.Billdetails;
import POJO.CustomerDetails;
import POJO.Login;
import POJO.NewCustomer;
import POJO.Paybill;
import POJO.Payment;
import POJO.Payment1;
import POJO.Rbill;
import POJO.Tax;

public interface AdminDao {

        public Admin LoginAdmin(String adminUsername, String adminpassword);

        public boolean addCustomer(NewCustomer n);

        boolean Update(NewCustomer a);

        boolean Update1(NewCustomer a);

        boolean update2(Login l);

        public List<NewCustomer> UpdateCustomerbyMeter_no(String Meter_no);

        public boolean Calculatebill(Bill b);

        public CustomerDetails FullCustomerDetails(String Meter_no);

        public List<Paybill> Adminpaybill(String Meter_no, String month);

        public boolean Adminpayment(Payment p);

        public boolean AdmindeleteBill(String Month);

        public boolean billdetails(Billdetails b);

        public NewCustomer CustomerDetails(String Meter_no);

        public Tax Taxinfo(Tax t);

        public Rbill bill(String month);

        public Payment1 rpay(Payment1 p1);

}
