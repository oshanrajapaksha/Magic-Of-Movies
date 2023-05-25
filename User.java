
package jv;

import java.sql.Date;


public class User {
    
    private String email;
    private String name;
    private Date dob;
    private String address;
    private String password;
    private String profPic;
    private String role;
    
    public User(){
    }
    public User(String email, String name, Date dob, String address, String password, String profPic){
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.password = password;
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfPic(String profPic) {
        this.profPic = profPic;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getProfPic() {
        return profPic;
    }

    public String getRole() {
        return role;
    }
    
    
}
