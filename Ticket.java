
package jv;

public class Ticket {//mage
    private int id;
    private String seatNum;
    private String email;   
    private int movId;
    private String paymentStats;

    public int getId() {
        return id;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public String getEmail() {
        return email;
    }

    public int getMovId() {
        return movId;
    }

    public String getPaymentStats() {
        return paymentStats;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMovId(int movId) {
        this.movId = movId;
    }

    public void setPaymentStats(String paymentStats) {
        this.paymentStats = paymentStats;
    }
    
    
}
