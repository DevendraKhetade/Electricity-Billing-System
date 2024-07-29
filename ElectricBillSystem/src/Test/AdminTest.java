package Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import Impl.AdminDaoImpl;
import Impl.CustomerDaoImpl;
import POJO.Admin;
import POJO.Bill;
import POJO.Billdetails;
import POJO.CustomerDetails;
import POJO.Login;
import POJO.NewCustomer;
import POJO.NewCustomer1;
import POJO.Paybill;
import POJO.Payment;
import POJO.Payment1;
import POJO.Rbill;
import POJO.Signin;
import POJO.Tax;

public class AdminTest {
    static String getAlphaNumericString(int n) {
        String Meter_no = "0123456789";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (Meter_no.length() * Math.random());
            sb.append(Meter_no.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        boolean flag;
        List<NewCustomer> clist = null;
        List<NewCustomer> cdlist = null;
        List<Login> llist = null;
        List<Login> pList = null;
        List<Paybill> pblist = null;
        AdminDaoImpl adao = new AdminDaoImpl();
        CustomerDaoImpl cdao = new CustomerDaoImpl();
        NewCustomer n = new NewCustomer();
        Bill b1 = new Bill();
        Login l3 = new Login();
        Scanner sc = new Scanner(System.in);
        boolean o = true;
        while (o) {
            System.out.println("\n");
            System.out.println("---------Welcome to Electricity Billing System---------\n");
            System.out.println("--------------------------------------");
            System.out.println("Login in as:");
            System.out.println("          1. Admin                   ");
            System.out.println("          2. Customer                ");
            System.out.println("          3. Exit                      ");
            System.out.println("---------------------------------------");
            System.out.print("Enter Option: ");
            int Choice = sc.nextInt();
            switch (Choice) {
                case 1:
                    System.out.println("************************************");
                    System.out.println("           Admin login:-                ");
                    System.out.println("************************************");
                    System.out.println("Enter Username:");
                    String username = sc.next();

                    System.out.println("Enter Password:");
                    String password = sc.next();

                    Admin a = adao.LoginAdmin(username, password);
                    if (a == null) {
                        System.out.println("Wrong Credentials");
                        break;
                    }
                    System.out.println("Login Successfully");
                    System.out.println("welcome to " + a.getAdminUsername() + " as Admin");
                    boolean y = true;
                    while (y) {
                        String Meter_num = RandomString.getAlphaNumericString(6);
                        System.out.println("-------------------------");
                        System.out.println("1.New Customer");
                        System.out.println("2.Update");
                        System.out.println("3.Calculate Bill:");
                        System.out.println("4.Get full Customer Details by Meter number");
                        System.out.println("5.Make payment:");
                        System.out.println("6.Logout");
                        System.out.println("Enter your option: ");
                        int i = sc.nextInt();
                        if (i == 1) {
                            System.out.println("Enter Customer name:");
                            String cname = sc.next();

                            System.out.println("Meter no:" + Meter_num);

                            System.out.println("Enter Customer address:");
                            String caddress = sc.next();

                            System.out.println("Enter Customer city:");
                            String ccity = sc.next();

                            System.out.println("Enter Customer state:");
                            String cstate = sc.next();

                            System.out.println("Enter Customer Ph_no:");
                            String c_ph_no = sc.next();

                            System.out.println("Enter Meter Location \n(Whether it is Inside or Outside?):-");
                            String mloc = sc.next();

                            System.out.println("Enter Meter Type \n(Is your meter is Electric Meter, Solar Meter,Or Smart Meter):-");
                            String mtype = sc.next();

                            System.out.println("Enter Phase Type of Your Meter\n(Single Phase or 3-Phase):-");
                            String ptype = sc.next();

                            System.out.println("Type of your Bill?\n(Normal or Industrial):-");
                            String btype = sc.next();

                            NewCustomer c = new NewCustomer(cname, Meter_num, caddress, ccity, cstate, c_ph_no, mloc,mtype, ptype, btype);
                            boolean b = adao.addCustomer(c);
                            String a1 = (b) ? "New Customer Added Successfully" : "Failed To Add Customer";
                            System.out.println(a1);

                        }

                        if (i == 2) {
                            System.out.println("enter exiting meter no:");
                            String meternum = sc.next();
                            clist = adao.UpdateCustomerbyMeter_no(meternum);
                            n.setMeter_no(meternum);
                            if (clist == null || clist.isEmpty()) {
                                System.out.println("Please add customer information");
                            } else {
                                System.out.println("Enter Customer name:");
                                String Cname = sc.next();

                                System.out.println("Enter Customer address:");
                                String Caddress = sc.next();

                                System.out.println("Enter Customer city:");
                                String Ccity = sc.next();

                                System.out.println("Enter Customer state:");
                                String Cstate = sc.next();

                                System.out.println("Enter Customer Ph_no:");
                                String C_ph_no = sc.next();

                                System.out.println("Enter Meter Location \n(Whether it is Inside or Outside?):-");
                                String Mloc = sc.next();

                                System.out.println("Enter Meter Type \n(Is your meter is Electric Meter, Solar Meter,Or Smart Meter):-");
                                String Mtype = sc.next();

                                System.out.println("Enter Phase Type of Your Meter\n(Single Phase or 3-Phase):-");
                                String Ptype = sc.next();

                                System.out.println("Type of your Bill?\n(Normal or Industrial):-");
                                String Btype = sc.next();

                                n.setCustomer_name(Cname);
                                n.setCustomer_address(Caddress);
                                n.setCity(Ccity);
                                n.setState(Cstate);
                                n.setCust_phone(C_ph_no);
                                n.setMeter_location(Mloc);
                                n.setMeter_type(Mtype);
                                n.setPhase_type(Ptype);
                                n.setBill_type(Btype);

                                Login l = new Login();
                                l.setCustomer(Cname);
                                l.setMeter_no(meternum);

                                boolean b4 = adao.Update(n);
                                boolean b3 = adao.Update1(n);
                                boolean b9 = adao.update2(l);
                                String a2 = (b4 || b3 || b9) ? "Data Updated successfully" : "Error";
                                System.out.println(a2);
                            }
                        }
                        if (i == 3) {
                            System.out.println("enter exiting meter no:");
                            String meternum = sc.next();
                            clist = adao.UpdateCustomerbyMeter_no(meternum);
                            n.setMeter_no(meternum);
                            if (clist == null || clist.isEmpty()) {
                                System.out.println("Please add customer information");
                            } else {
                                System.out.println("Enter Total Units Consumed: ");
                                String unit = sc.next();

                                System.out.println("Enter Month:");
                                String month = sc.next();

                                Bill b = new Bill(meternum, unit, month);
                                boolean b5 = adao.Calculatebill(b);
                                if (b5) {
                                    System.out.println("Bill calculated successfully");
                                } else {
                                    System.err.println("Failed to Calculate");
                                }
                            }
                        }
                        if (i == 4) {
                            System.out.println("enter exiting meter no:");
                            String meternum = sc.next();
                            clist = adao.UpdateCustomerbyMeter_no(meternum);
                            n.setMeter_no(meternum);
                            if (clist == null || clist.isEmpty()) {
                                System.out.println("Please add customer information");
                            } else {
                                CustomerDetails c = adao.FullCustomerDetails(meternum);
                                if (c != null) {
                                    System.out.println(c);
                                } else {
                                    System.err.println("Enter Meter Number Doesnot exist");
                                }
                            }
                        }
                        if (i == 5) {
                            System.out.println("enter exiting meter no:");
                            String num1 = sc.next();
                            System.out.println("enter month:");
                            String month = sc.next();
                            pblist = adao.Adminpaybill(num1, month);
                            n.setMeter_no(num1);
                            b1.setMonth(month);
                            if (pblist == null || pblist.isEmpty()) {
                                System.out.println("Bill has not generated for the given meter number and month\n                   - OR - \nYour Bill has been paid for the mentioned month");
                            } else {
                                List<Paybill> f3 = adao.Adminpaybill(num1, month);
                                if (f3 != null) {
                                    System.out.println(f3);
                                    System.out.println("____________");
                                    System.out.println("Proceed for payment?\nEnter yes or no");
                                    String answer = sc.next().toLowerCase();
                                    sc.nextLine();
                                    if (answer.equals("yes")) {
                                        String paymentstatus = "Payment Successful";
                                        Payment p1 = new Payment();
                                        p1.setPaymentStatus(paymentstatus);
                                        p1.setMeter_no(num1);
                                        b1.setMonth(month);
                                        flag = adao.Adminpayment(p1);
                                        flag = adao.AdmindeleteBill(b1.getMonth());
                                        String status = "PAID";
                                        Billdetails bd = new Billdetails();
                                        bd.setStatus(status);
                                        bd.setMeter_no(num1);
                                        bd.setMonth(month);
                                        flag = adao.billdetails(bd);
                                        if (flag) {
                                            System.out.println("your payment has been done successfully!!!");
                                            LocalDate date = LocalDate.now();
                                            LocalTime time = LocalTime.now();
                                            System.out.println("payment done at: " + date + " " + time);
                                            System.out.println();
                                            System.out.println("Do you want to generate recipt??\nEnter yes or no");
                                            String option = sc.next().toLowerCase();
                                            sc.nextLine();
                                            if (option.equals("yes")) {
                                                System.out.println("************************************");
                                                System.out.println("  Electricity Bill payment Recipt                ");
                                                System.out.println("************************************");

                                                clist = adao.UpdateCustomerbyMeter_no(num1);
                                                n.setMeter_no(num1);
                                                if (clist == null || clist.isEmpty()) {
                                                    System.out.println("Please add customer information");
                                                } else {
                                                    NewCustomer c = adao.CustomerDetails(num1);
                                                    if (c != null) {
                                                        System.out.println(c);
                                                    } else {
                                                        System.err.println("Enter Meter Number Doesnot exist");
                                                    }
                                                    Tax t = adao.Taxinfo(null);
                                                    if (t != null) {
                                                        System.out.println(t);
                                                    } else {
                                                        System.err.println("Enter Meter Number Doesnot exist");
                                                    }
                                                    Rbill r = adao.bill(month);
                                                    if (r != null) {
                                                        System.out.println(r);
                                                    } else {
                                                        System.err.println("Enter Meter Number Doesnot exist");
                                                    }
                                                    Payment1 p = adao.rpay(null);
                                                    if (p != null) {
                                                        System.out.println(p);
                                                    } else {
                                                        System.err.println("Enter Meter Number Doesnot exist");
                                                    }
                                                }
                                            }
                                        } else
                                            System.out.println("error while making payment");
                                    } else if (answer.equals("no"))
                                        System.out.println("thank you for being with us");
                                    else
                                        System.out.println("please give answer in yes or no only!!");
                                } else {
                                    System.err.println("meter number is not available");
                                }
                            }
                        }
                        if (i == 6) {
                            System.out.println("Admin Logout Successfully");
                            y = false;
                        }
                    }
                    break;
                case 2:
                    boolean q = true;
                    while (q) {
                        System.out.println("************************************");
                        System.out.println("         Customer Menu                ");
                        System.out.println("************************************");
                        System.out.println();
                        System.out.println("Are you already a customer?");
                        System.out.println("--------------------------------------");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        System.out.println("3. Exit");
                        System.out.println("--------------------------------------");
                        System.out.print("Enter Option: ");
                        int selectedOption = sc.nextInt();
                        switch (selectedOption) {
                            case 1:
                                System.out.println("************************************");
                                System.out.println("           Customer login:-                ");
                                System.out.println("************************************");
                                System.out.println("enter exiting meter no:");
                                String meternum = sc.next();
                                pList = cdao.login(meternum);
                                l3.setMeter_no(meternum);
                                if (pList == null || pList.isEmpty()) {
                                    System.out.println("Please add customer information");
                                } else {
                                    System.out.println("Enter Username:");
                                    String c_username = sc.next();

                                    System.out.println("Enter Password:");
                                    String c_password = sc.next();

                                    Login l = new Login(c_username, c_password, meternum);
                                    boolean b2 = cdao.CustomerLogin(l);
                                    if (b2) {
                                        System.out.println("Login  Successfully");
                                        sc.nextLine();
                                        boolean w = true;
                                        while (w) {
                                            String Meter_num = RandomString.getAlphaNumericString(6);
                                            System.out.println("************************************");
                                            System.out.println("           Customer Menu:-                ");
                                            System.out.println("************************************");
                                            System.out.println("1.New Customer:");
                                            System.out.println("2.Update your username and password:");
                                            System.out.println("3.Yours Details:");
                                            System.out.println("4.Bill Details");
                                            System.out.println("5.Make Payment");
                                            System.out.println("6.logout");
                                            System.out.println("Enter choice:");
                                            int i = sc.nextInt();
                                            switch (i) {
                                                case 1:
                                                    System.out.println("Enter Customer name:");
                                                    String cname = sc.next();

                                                    System.out.println("Meter no:" + Meter_num);

                                                    System.out.println("Enter Customer address:");
                                                    String caddress = sc.next();

                                                    System.out.println("Enter Customer city:");
                                                    String ccity = sc.next();

                                                    System.out.println("Enter Customer state:");
                                                    String cstate = sc.next();

                                                    System.out.println("Enter Customer Ph_no:");
                                                    String c_ph_no = sc.next();

                                                    System.out.println("Enter Meter Location \n(Whether it is Inside or Outside?):-");
                                                    String mloc = sc.next();

                                                    System.out.println("Enter Meter Type \n(Is your meter is Electric Meter, Solar Meter,Or Smart Meter):-");
                                                    String mtype = sc.next();

                                                    System.out.println("Enter Phase Type of Your Meter\n(Single Phase or 3-Phase):-");
                                                    String ptype = sc.next();

                                                    System.out.println("Type of your Bill?\n(Normal or Industrial):-");
                                                    String btype = sc.next();

                                                    NewCustomer c = new NewCustomer(cname, Meter_num, caddress, ccity,cstate, c_ph_no, mloc, mtype, ptype, btype);
                                                    boolean b = adao.addCustomer(c);
                                                    String a1 = (b) ? "New Customer Added Successfully":"Failed To Add Customer";
                                                    System.out.println(a1);
                                                    break;

                                                case 2:
                                                    System.out.println("enter exiting meter no:");
                                                    String Meternum = sc.next();
                                                    clist = adao.UpdateCustomerbyMeter_no(Meternum);
                                                    n.setMeter_no(Meternum);
                                                    if (clist == null || clist.isEmpty()) {
                                                        System.out.println("Please add customer information");
                                                    } else {
                                                        System.out.println("Enter your username:");
                                                        String lname = sc.next();

                                                        System.out.println("Enter password:");
                                                        String lpass = sc.next();

                                                        l3.setUsername(lname);
                                                        l3.setPassword(lpass);
                                                        boolean b4 = cdao.Update(l3);
                                                        String a2 = (b4) ? "Data Updated successfully" : "Error";
                                                        System.out.println(a2);
                                                    }
                                                    break;

                                                case 3:
                                                    System.out.println("enter exiting meter no:");
                                                    String meter_no = sc.next();
                                                    cdlist = cdao.Customer(meter_no);
                                                    n.setMeter_no(meter_no);
                                                    if (cdlist == null || cdlist.isEmpty()) {
                                                        System.out.println("Please add customer information");
                                                    } else {
                                                        NewCustomer1 cd = cdao.GetCustomer(meter_no);
                                                        if (cd != null) {
                                                            System.out.println(cd);
                                                        } else {
                                                            System.err.println("Enter Meter Number Doesnot exist");
                                                        }
                                                    }
                                                    break;
                                                
                                                    case 4:
                                                    System.out.println("enter exiting meter no:");
                                                    String num = sc.next();
                                                    System.out.println("enter month:");
                                                    String mon = sc.next();
                                                    cdlist = cdao.Customer(num);
                                                    n.setMeter_no(num);
                                                    b1.setMonth(mon);
                                                    if (cdlist == null || cdlist.isEmpty()) {
                                                        System.out.println("Please add customer information");
                                                    } else {
                                                        Bill f3 = cdao.searchbill(num, mon);
                                                        if (f3 != null) {
                                                            System.out.println(f3);
                                                        } else {
                                                            System.err.println("meter number is not available");
                                                        }
                                                    }
                                                    break;

                                                case 5:
                                                    System.out.println("enter exiting meter no:");
                                                    String num1 = sc.next();
                                                    System.out.println("enter month:");
                                                    String month = sc.next();
                                                    pblist = cdao.paybill(num1, month);
                                                    n.setMeter_no(num1);
                                                    b1.setMonth(month);
                                                    if (pblist == null || pblist.isEmpty()) {
                                                        System.out.println("Bill has not been generated for the given month or Your Bill has been paid for the mentioned month");
                                                    } else {
                                                        List<Paybill> f3 = cdao.paybill(num1, month);
                                                        if (f3 != null) {
                                                            System.out.println(f3);
                                                            System.out.println("____________");
                                                            System.out.println("Proceed for payment?\nEnter yes or no");
                                                            String answer = sc.next().toLowerCase();
                                                            sc.nextLine();
                                                            if (answer.equals("yes")) {
                                                                String paymentstatus = "Payment Successful";
                                                                Payment p1 = new Payment();
                                                                p1.setPaymentStatus(paymentstatus);
                                                                p1.setMeter_no(num1);
                                                                b1.setMonth(month);
                                                                flag = cdao.payment(p1);
                                                                flag = cdao.deleteBill(b1.getMonth());
                                                                String status = "PAID";
                                                                Billdetails bd = new Billdetails();
                                                                bd.setStatus(status);
                                                                bd.setMeter_no(num1);
                                                                bd.setMonth(month);
                                                                flag = cdao.billdetails(bd);
                                                                if (flag) {
                                                                    System.out.println("your payment has been done successfully");
                                                                    LocalDate date = LocalDate.now();
                                                                    LocalTime time = LocalTime.now();
                                                                    System.out.println("payment done at: " + date + " " + time);
                                                                    System.out.println();
                                                                    System.out.println("Do you want to generate recipt??\nEnter yes or no");
                                                                    String option = sc.next().toLowerCase();
                                                                    sc.nextLine();
                                                                    if (option.equals("yes")) {
                                                                        System.out.println("************************************");
                                                                        System.out.println("     Electricity Bill payment Recipt                ");
                                                                        System.out.println("************************************");

                                                                        clist = adao.UpdateCustomerbyMeter_no(num1);
                                                                        n.setMeter_no(num1);
                                                                        if (clist == null || clist.isEmpty()) {
                                                                            System.out.println("Please add customer information");
                                                                        } else {
                                                                            NewCustomer cn = cdao.CustomerDetails(num1);
                                                                            if (cn != null) {
                                                                                System.out.println(cn);
                                                                            } else {
                                                                                System.err.println("Enter Meter Number Doesnot exist");
                                                                            }
                                                                            Tax t = cdao.Taxinfo(null);
                                                                            if (t != null) {
                                                                                System.out.println(t);
                                                                            } else {
                                                                                System.err.println("Enter Meter Number Doesnot exist");
                                                                            }
                                                                            Rbill r = cdao.bill(month);
                                                                            if (r != null) {
                                                                                System.out.println(r);
                                                                            } else {
                                                                                System.err.println("Enter Meter Number Doesnot exist");
                                                                            }
                                                                            Payment1 p = cdao.rpay(null);
                                                                            if (p != null) {
                                                                                System.out.println(p);
                                                                            } else {
                                                                                System.err.println("Enter Meter Number Doesnot exist");
                                                                            }
                                                                        }
                                                                    }
                                                                } else
                                                                    System.out.println("error while making payment");
                                                            } else if (answer.equals("no"))
                                                                System.out.println("thank you for being with us");
                                                            else
                                                                System.out.println( "please give answer in yes or no only!!");
                                                        } else {
                                                            System.err.println("meter number is not available");
                                                        }
                                                    }
                                                    break;

                                                case 6:
                                                    System.out.println("Thank you for being with us");
                                                    w = false;
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }
                                    }
                                }
                                break;

                            case 2:
                                System.out.println("enter exiting meter no:");
                                String meter_num = sc.next();
                                llist = cdao.GetCustomerbyMeter_no(meter_num);
                                l3.setMeter_no(meter_num);
                                if (llist == null || llist.isEmpty()) {
                                    System.out.println("Please add customer information");
                                } else {
                                    System.out.println("Enter Username:");
                                    String Username = sc.next();

                                    System.out.println("Enter Password:");
                                    String Password = sc.next();

                                    Signin e = new Signin(Username, Password, meter_num);
                                    boolean b = cdao.CustomerSignin(e);
                                    if (b) {
                                        System.out.println("Account Created Successfully");
                                    } else {
                                        System.out.println("Error");
                                    }
                                }
                                break;

                            case 3:
                                q = false;
                                break;
                        }
                    }
                    break;

                case 3:
                    o = false;
                    System.out.println("Thank you for being with us");
                    break;
            }
        }
        sc.close();
    }
}