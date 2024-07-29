package Test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Impl.AddAdminDaoImpl;
import POJO.Admin;

public class AddAdminTest {
    public static void main(String[] args) {
        AddAdminDaoImpl aadao = new AddAdminDaoImpl();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("************************************");
            System.out.println("           Admin Menu              ");
            System.out.println("************************************");
            System.out.println("1.Add Admin:");
            System.out.println("2.Delete Admin:");
            System.out.println("3.Update Details of Admin:");
            System.out.println("4.Search Admin by EmailId:");
            System.out.println("5.Show List of Admin:");
            System.out.println("6.Return or Exit");
            System.out.println("Enter your Choice:");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Admin username:");
                    String Name = sc.next();

                    System.out.println("Enter Admin EmailId:");
                    String Mail = sc.next();

                    System.out.println("Enter Admin Password:");
                    String Password = sc.next();

                    Admin a1 = new Admin(Name, Mail, Password);
                    boolean b1 = aadao.AddAdmin(a1);
                    if (b1) {
                        System.out.println("Admin Details added Successfully");
                    } else {
                        System.err.println("Failed to add Admin Details");
                    }
                    break;
                case 2:
                    System.out.println("Enter Admin EmailId yu want to delete:");
                    String email = sc.nextLine();
                    boolean b = aadao.DeleteAdmin(email);
                    if (b) {
                        System.out.println("Deleted Successfully");
                    } else {
                        System.err.println("emailid doesnot exist");
                    }
                    break;
                case 3:
                    System.out.println("Enter existing email id:");
                    String Email = sc.next();

                    System.out.println("Enter Admin username:");
                    String aname = sc.next();

                    System.out.println("Enter Password:");
                    String password = sc.next();
                    Admin a = new Admin();
                    a.setAdminEmail(Email);
                    a.setAdminUsername(aname);
                    a.setAdminpassword(password);

                    boolean b2 = aadao.UpdateAdmin(a);
                    if (b2) {
                        System.out.println("Information updated successfully");
                    } else {
                        System.err.println("error");
                    }
                    break;
                case 4:
                    System.out.println("Enter existing email id:");
                    String aemail = sc.next();
                    Admin a2 = aadao.searchByEmailId(aemail);
                    if (a2 != null) {
                        System.out.println(a2);
                    } else {
                        System.err.println("Admin is not available");
                    }
                case 5:
                    List<Admin> l = aadao.getAllAdmin();
                    if (l != null) {
                        Iterator<Admin> it = l.iterator();
                        while (it.hasNext()) {
                            System.out.println(it.next());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Thank you");
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}