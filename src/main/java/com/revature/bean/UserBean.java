package com.revature.bean;


public class UserBean {//this is user a bean class

    private int userId;
    private String fullName;
    private String email;
    private String username;
    private String password;
    private String role;


    public UserBean(int userid, String fullname, String email, String username, String password, String role){

                 this.userId=userid;
                 this.fullName=fullname;
                 this.email=email;
                 this.username=username;
                 this.password=password;
                 this.role=role;

   }

    public UserBean() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User [" +
                "id=" + userId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ']';
    }
}
