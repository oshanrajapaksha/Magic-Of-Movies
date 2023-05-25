package jv;
import java.sql.Date;

public class Movies {
    private int m_id;
    private String name;
    private double ticket_price;
    private Date expire_time;
    private Date time_inserted;

    //getters
    public int getM_id(){
        return m_id;
    }

    public String getName() {
        return name;
    }

    public double getTicket_price() {
        return ticket_price;
    }

    public Date getExpire_time() {
        return expire_time;
    }

    public Date getTime_inserted() {
        return time_inserted;
    }
    
    //setters
    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTicket_price(double ticket_price) {
        this.ticket_price = ticket_price;
    }

    public void setExpire_time(Date expire_time) {
        this.expire_time = expire_time;
    }

    public void setTime_inserted(Date time_inserted) {
        this.time_inserted = time_inserted;
    }
    
    

    
    
    
}
