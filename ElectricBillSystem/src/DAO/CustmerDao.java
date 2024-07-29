package DAO;

import java.util.List;

import POJO.Bill;
import POJO.Billdetails;
import POJO.Login;
import POJO.NewCustomer;
import POJO.NewCustomer1;
import POJO.Paybill;
import POJO.Payment;
import POJO.Payment1;
import POJO.Rbill;
import POJO.Signin;
import POJO.Tax;

public interface CustmerDao {

        public boolean CustomerSignin(Signin s);

        public boolean CustomerLogin(Login l);

        public List<Login> login(String Meter_no);

        public int NewCustomer(String Customer_name, String Meter_no,
                        String Customer_address, String City, String State, String Cust_phone, String Meter_location,
                        String Meter_type, String Phase_type,
                        String Bill_type);

        public List<Login> GetCustomerbyMeter_no(String Meter_no);

        public List<NewCustomer> Customer(String Meter_no);

        public NewCustomer1 GetCustomer(String Meter_no);

        public Bill searchbill(String Meter_no, String month);

        public List<Paybill> paybill(String Meter_no, String month);

        public boolean payment(Payment p);

        public boolean deleteBill(String Month);

        public boolean billdetails(Billdetails b);

        public NewCustomer CustomerDetails(String Meter_no);

        public Tax Taxinfo(Tax t);

        public Rbill bill(String month);

        public Payment1 rpay(Payment1 p1);

        public List<Login> UpdateLoginbyMeter_no(String Meter_no);

        public boolean Update(Login l); 


}
