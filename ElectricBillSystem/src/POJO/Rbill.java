package POJO;

public class Rbill {
    private String month;
    private String unit;
    private String totalbill;
    private String status;


    public Rbill() {
        super();
    }

    public Rbill( String month, String unit, String totalbill, String status) {
        this.month = month;
        this.unit = unit;
        this.totalbill = totalbill;
        this.status = status;
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
        return "Bill--> \nMonth=" + month + "\nUnit=" + unit + "\nTotalbill=" + totalbill + "\nStatus=" + status + "\n-------------------";
    }

    
    
}
