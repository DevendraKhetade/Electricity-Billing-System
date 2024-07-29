package POJO;

public class Billdetails {
    private String Meter_no;
    private String month;
    private String unit;
    private String totalbill;
    private String status;


    public Billdetails() {
        super();
    }

    public Billdetails(String Meter_no, String month, String unit, String totalbill, String status) {
        this.Meter_no = Meter_no;
        this.month = month;
        this.unit = unit;
        this.totalbill = totalbill;
        this.status = status;
    }


    public String getMeter_no() {
        return Meter_no;
    }


    public void setMeter_no(String Meter_no) {
        this.Meter_no = Meter_no;
    }


    public String getMonth() {
        return month;
    }


    public void setMonth(String month) {
        this.month = month;
    }


    public String getUnit() {
        return unit;
    }


    public void setUnit(String unit) {
        this.unit = unit;
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
        return "Billdetails--> \nMeter_no=" + Meter_no + ", month=" + month + ", unit=" + unit + ", totalbill=" + totalbill
                + ", status=" + status + "";
    }

    
    
}
