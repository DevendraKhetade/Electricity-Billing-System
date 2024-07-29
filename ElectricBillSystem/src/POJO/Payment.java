package POJO;

import java.time.LocalDateTime;

public class Payment {
    private LocalDateTime PaymentDate;
    private String Meter_no; 
    private double totalBill;
    private String paymentStatus;

    public Payment() {
        super();
    }

    public Payment(LocalDateTime PaymentDate, String Meter_no, double totalBill, String paymentStatus) {
        this.PaymentDate = PaymentDate;
        this.Meter_no = Meter_no;
        this.totalBill = totalBill;
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(LocalDateTime PaymentDate) {
        this.PaymentDate = PaymentDate;
    }

    public String getMeter_no() {
        return Meter_no;
    }

    public void setMeter_no(String Meter_no) {
        this.Meter_no = Meter_no;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Payment--> \nPaymentDate=" + PaymentDate + "\nMeter_no=" + Meter_no + "\ntotalBill=" + totalBill
                + "\npaymentStatus=" + paymentStatus + "\n-------------------";
    }

    
    
    }
