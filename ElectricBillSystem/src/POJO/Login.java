package POJO;

public class Login {
    private String Meter_no;
    private String Username;
    private String Customer;
    private String Password;

    public Login() {
        super();
    }

    public Login( String Username, String Password, String Meter_no) {
        this.Username = Username;
        this.Password = Password;
        this.Meter_no = Meter_no;
    }

    public Login(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getMeter_no() {
        return Meter_no;
    }

    public void setMeter_no(String Meter_no) {
        this.Meter_no = Meter_no;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String Customer) {
        this.Customer = Customer;
    }

    @Override
    public String toString() {
        return "Login [Meter_no=" + Meter_no + ", Username=" + Username + ", Customer=" + Customer + ", Password="
                + Password + "]";
    }

    

    

}
