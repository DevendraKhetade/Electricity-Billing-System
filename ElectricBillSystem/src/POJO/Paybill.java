package POJO;

public class Paybill {
    private String Meter_no;
    private String month;
    private String totalbill;

    public Paybill() {
        super();
    }
   

    public Paybill(String Meter_no, String month, String totalbill) {
        this.Meter_no = Meter_no;
        this.month = month;
        this.totalbill = totalbill;
    }
   

    public String getMeter_no() {
        return Meter_no;
    }

    public void setMeter_no(String meter_no) {
        Meter_no = meter_no;
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
        return "Paybill--->\nMeter_no=" + Meter_no + "\nMonth=" + month
        + "\nTotalbill=" + totalbill + "\n-------------------";
    }
    
    
    
}
