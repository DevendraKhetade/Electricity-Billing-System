package POJO;

public class Signin {
    private String Username;
    private String Customer_name;
    private String Password;
    private String Meter_no;

    public Signin() {
        super();
    }

    public Signin(String Username, String Password,String Meter_no) {
        this.Username = Username;
        this.Password = Password;
        this.Meter_no = Meter_no;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getCustomer_name() {
        return Customer_name;
    }

    public void setCustomer_name(String Customer_name) {
        this.Customer_name = Customer_name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getMeter_no(){
        return Meter_no;
    }

    public void setMeter_no(String Meter_no){
        this.Meter_no= Meter_no;
    }
    
}

