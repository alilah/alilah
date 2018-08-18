package com.revature.bean;

public class ProfileBean {

    private int profileid;
    private String fullName;
    private String email;
    private String address;
    private String billing; // credit card payment

    public ProfileBean() {
    }

    public ProfileBean(int pid, String name, String email,String address, String payment){
        this.profileid=pid;
        this.fullName=name;
        this.email=email;
        this.address=address;
        this.billing=payment;
    }


    public int getProfileid() {
        return profileid;
    }

    public void setProfileid(int profileid) {
        this.profileid = profileid;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBilling() {
        return billing;
    }

    public void setBilling(String billing) {
        this.billing = billing;
    }

    @Override
    public String toString() {
        return "Profile {" +
                "profileid=" + profileid +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", billing='" + billing + '\'' +
                '}';
    }
}
