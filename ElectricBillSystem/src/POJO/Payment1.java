package POJO;
import java.time.LocalDateTime;
public class Payment1 {
    
    private LocalDateTime PaymentDate;
    private String paymentStatus;

    public Payment1() {
        super();
    }

    public Payment1(LocalDateTime PaymentDate, String paymentStatus) {
        this.PaymentDate = PaymentDate;
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(LocalDateTime PaymentDate) {
        this.PaymentDate = PaymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Payment--> \nPaymentDate=" + PaymentDate + "\nPaymentStatus=" + paymentStatus + "\n-------------------";
    }

    

    
}
