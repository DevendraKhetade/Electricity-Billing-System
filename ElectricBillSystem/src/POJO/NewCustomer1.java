package POJO;

public class NewCustomer1 {
    private String Customer_name;
    private String Meter_no;
    private String Customer_address;
    private String City;
    private String State;
    private String Cust_phone;
    private String Meter_location;
    private String Meter_type;
    private String Phase_type;
    private String Bill_type;

    public NewCustomer1() {
        super();
    }

    public NewCustomer1(String Customer_name, String Meter_no, String Customer_address, String City, String State,
            String Cust_phone) {
        this.Customer_name = Customer_name;
        this.Meter_no = Meter_no;
        this.Customer_address = Customer_address;
        this.City = City;
        this.State = State;
        this.Cust_phone = Cust_phone;
    }

    public NewCustomer1(String Customer_name, String Meter_no, String Customer_address, String City, String State,
            String Cust_phone, String Meter_location, String Meter_type, String Phase_type, String Bill_type) {
        this.Customer_name = Customer_name;
        this.Meter_no = Meter_no;
        this.Customer_address = Customer_address;
        this.City = City;
        this.State = State;
        this.Cust_phone = Cust_phone;
        this.Meter_location = Meter_location;
        this.Meter_type = Meter_type;
        this.Phase_type = Phase_type;
        this.Bill_type = Bill_type;
    }
    
    public String getCustomer_name() {
        return Customer_name;
    }

    public void setCustomer_name(String Customer_name) {
        this.Customer_name = Customer_name;
    }

    public String getMeter_no() {
        return Meter_no;
    }

    public void setMeter_no(String m_no) {
        this.Meter_no = m_no;
    }

    public String getCustomer_address() {
        return Customer_address;
    }

    public void setCustomer_address(String Customer_address) {
        this.Customer_address = Customer_address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getCust_phone() {
        return Cust_phone;
    }

    public void setCust_phone(String Cust_phone) {
        this.Cust_phone = Cust_phone;
    }

    public String getMeter_location() {
        return Meter_location;
    }

    public void setMeter_location(String Meter_location) {
        this.Meter_location = Meter_location;
    }

    public String getMeter_type() {
        return Meter_type;
    }

    public void setMeter_type(String Meter_type) {
        this.Meter_type = Meter_type;
    }

    public String getPhase_type() {
        return Phase_type;
    }

    public void setPhase_type(String Phase_type) {
        this.Phase_type = Phase_type;
    }

    public String getBill_type() {
        return Bill_type;
    }

    public void setBill_type(String Bill_type) {
        this.Bill_type = Bill_type;
    }
    

    @Override
    public String toString() {
        return "Customer Details---> \nCustomer_name=" + Customer_name + "\nMeter_no=" + Meter_no + "\nCustomer_address="
                + Customer_address + "\nCity=" + City + "\nState=" + State + "\nCust_phone=" + Cust_phone
                + "\nMeter_location=" + Meter_location + "\nMeter_type=" + Meter_type + "\nPhase_type=" + Phase_type
                + "\nBill_type=" + Bill_type + "\n-------------------";
    }
}
