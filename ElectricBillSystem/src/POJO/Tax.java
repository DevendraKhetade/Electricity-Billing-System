package POJO;

public class Tax {
    private String cost_per_unit;
    private String meter_rent ;
    private String service_charge ;
    private String service_tax ;
    private String GST ;
    private String fixed_tax ;
    
    public Tax() {
        super();
    }

    public Tax(String cost_per_unit, String meter_rent, String service_charge, String service_tax, String GST,
            String fixed_tax) {
        this.cost_per_unit = cost_per_unit;
        this.meter_rent = meter_rent;
        this.service_charge = service_charge;
        this.service_tax = service_tax;
        this.GST = GST;
        this.fixed_tax = fixed_tax;
    }

    public String getCost_per_unit() {
        return cost_per_unit;
    }

    public void setCost_per_unit(String cost_per_unit) {
        this.cost_per_unit = cost_per_unit;
    }

    public String getMeter_rent() {
        return meter_rent;
    }

    public void setMeter_rent(String meter_rent) {
        this.meter_rent = meter_rent;
    }

    public String getService_charge() {
        return service_charge;
    }

    public void setService_charge(String service_charge) {
        this.service_charge = service_charge;
    }

    public String getService_tax() {
        return service_tax;
    }

    public void setService_tax(String service_tax) {
        this.service_tax = service_tax;
    }

    public String getGST() {
        return GST;
    }

    public void setGST(String GST) {
        this.GST = GST;
    }

    public String getFixed_tax() {
        return fixed_tax;
    }

    public void setFixed_tax(String fixed_tax) {
        this.fixed_tax = fixed_tax;
    }

    @Override
    public String toString() {
        return "Tax Information --> \nCost_per_unit=" + cost_per_unit + "\nMeter_rent=" + meter_rent + "\nService_charge="
                + service_charge + "\nService_tax=" + service_tax + "\nGST=" + GST + "\nFixed_tax=" + fixed_tax + "\n-------------------";
    }

    

    

    

    
    
}
