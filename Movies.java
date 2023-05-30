package jv;
import DatAcc.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Movies {
    private int m_id;
    private String name;
    private double ticket_price;
    private String expire_time;
    private String time_inserted;
    private String watch_hrs;
    private String director;
    private String category;
    private String imbd_rate;
    private String rott_rate;
    private String thumb;
    private String mov_desc;

    public String getMov_desc() {
        return mov_desc;
    }

    public void setMov_desc(String mov_desc) {
        this.mov_desc = mov_desc;
    }
    
    public void setWatch_hrs(String watch_hrs) {
        this.watch_hrs = watch_hrs;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImbd_rate(String imbd_rate) {
        this.imbd_rate = imbd_rate;
    }

    public void setRott_rate(String rott_rate) {
        this.rott_rate = rott_rate;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getWatch_hrs() {
        return watch_hrs;
    }

    public String getDirector() {
        return director;
    }

    public String getCategory() {
        return category;
    }

    public String getImbd_rate() {
        return imbd_rate;
    }

    public String getRott_rate() {
        return rott_rate;
    }

    public String getThumb() {
        return thumb;
    }
  
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

    public String getExpire_time() {
        return expire_time;
    }

    public String getTime_inserted() {
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

    public void setExpire_time(String expire_time) {
        this.expire_time = expire_time;
    }

    public void setTime_inserted(String time_inserted) {
        this.time_inserted = time_inserted;
    }

}
