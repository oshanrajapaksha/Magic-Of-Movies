
package jv;


public class User {
    
    private String email;
    private String name;
    private String dob;
    private String address;
    private String password;
    private String profPic;
    private String role;
    private String adMsg;
    
    public User(){
    }
    public User(String email, String name, String dob, String address, String password, String profPic, String role, String adMsg){
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.password = password;
        this.profPic = profPic;
        this.role = role;
        this.adMsg = adMsg;
    }

    public String getAdMsg() {
        return adMsg;
    }

    public void setAdMsg(String adMsg) {
        this.adMsg = adMsg;
    }

    
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
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

    public String getDob() {
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
