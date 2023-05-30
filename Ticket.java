
package jv;

public class Ticket {//mage
    private int id;
    private int mid;
    private String date;
    private int noTicket;
    private String email;
    private double total;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    

    public int getNoTicket() {
        return noTicket;
    }

    public void setNoTicket(int noTicket) {
        this.noTicket = noTicket;
    }
    

    public int getMid() {
        return mid;
    }

    public String getEmail() {
        return email;
    }

   
   

    public void setMid(int id) {
        this.mid = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    

    public void setEmail(String email) {
        this.email = email;
    }


   
    
    
}
