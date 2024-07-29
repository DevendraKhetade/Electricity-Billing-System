package POJO;

public class Bill {
    private String name;
    private String Meter_no;
    private String unit;
    private String month;
    private String totalbill;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bill() {
        super();
    }

    public Bill(String Meter_no, String unit, String month) {
        this.Meter_no = Meter_no;
        this.unit = unit;
        this.month = month;
    }
    

    public Bill(String name, String Meter_no, String unit, String month, String totalbill, String status) {
        this.name = name;
        this.Meter_no = Meter_no;
        this.unit = unit;
        this.month = month;
        this.totalbill = totalbill;
        this.status = status;
    }

    public Bill(String name, String Meter_no, String unit, String month, String totalbill) {
        this.name = name;
        this.Meter_no = Meter_no;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bill Details--->\nMeter_no=" + Meter_no + "\nUnit=" + unit + "\nMonth=" + month + "\nTotalbill="
                + totalbill + "\nStatus=" + status + "\n--------------------------\n";
    }

    
    
}
