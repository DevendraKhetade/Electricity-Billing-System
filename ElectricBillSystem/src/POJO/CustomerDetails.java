package POJO;

public class CustomerDetails {
    private String Meter_no;
    private String Customer_name;
    private String Customer_address;
    private String City;
    private String State;
    private String Cust_phone;
    private String Meter_location;
    private String Meter_type;
    private String Phase_type;
    private String Bill_type;
    private String unit;
    private String month;
    private String totalbill;

    public CustomerDetails() {
        super();
    }

    public CustomerDetails(String Meter_no, String Customer_name, String Customer_address, String City, String State,
            String Cust_phone, String Meter_location, String Meter_type, String Phase_type, String Bill_type,
            String unit, String month, String totalbill) {
        this.Meter_no = Meter_no;
        this.Customer_name = Customer_name;
        this.Customer_address = Customer_address;
        this.City = City;
        this.State = State;
        this.Cust_phone = Cust_phone;
        this.Meter_location = Meter_location;
        this.Meter_location = Meter_location;
        this.Meter_location = Meter_location;
        this.Meter_type = Meter_type;
        this.Phase_type = Phase_type;
        this.Bill_type = Bill_type;
        this.unit = unit;
        this.month = month;
        this.totalbill = totalbill;
    }

    public String getMeter_no() {
        return Meter_no;
    }

    public void setMeter_no(String meter_no) {
        Meter_no = meter_no;
    }

    public String getCustomer_name() {
        return Customer_name;
    }

    public void setCustomer_name(String customer_name) {
        Customer_name = customer_name;
    }

    public String getCustomer_address() {
        return Customer_address;
    }

    public void setCustomer_address(String customer_address) {
        Customer_address = customer_address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCust_phone() {
        return Cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        Cust_phone = cust_phone;
    }

    public String getMeter_location() {
        return Meter_location;
    }

    public void setMeter_location(String meter_location) {
        Meter_location = meter_location;
    }

    public String getMeter_type() {
        return Meter_type;
    }

    public void setMeter_type(String meter_type) {
        Meter_type = meter_type;
    }

    public String getPhase_type() {
        return Phase_type;
    }

    public void setPhase_type(String phase_type) {
        Phase_type = phase_type;
    }

    public String getBill_type() {
        return Bill_type;
    }

    public void setBill_type(String bill_type) {
        Bill_type = bill_type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTotalbill() {
        return totalbill;
    }

    public void setTotalbill(String totalbill) {
        this.totalbill = totalbill;
    }
   

    @Override
    public String toString() {
        return "CustomerDetails are-->\nMeter_no=" + Meter_no + ", Customer_name=" + Customer_name
                + ", Customer_address="
                + Customer_address + ", City=" + City + ", State=" + State + ", Cust_phone=" + Cust_phone
                + "\nMeter_location=" + Meter_location + ", Meter_type=" + Meter_type + ", Phase_type=" + Phase_type
                + ", Bill_type=" + Bill_type + "\nunit=" + unit + ", month=" + month + ", totalbill=" + totalbill
                + "";
    }

}
