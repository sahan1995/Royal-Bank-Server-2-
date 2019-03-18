package lk.royalBank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private
    String userName;

    private String password;

    private String role;

    private String ID;

    public User(String userName, String password, String role, String ID) {
        this.setUserName(userName);
        this.setPassword(password);
        this.setRole(role);
        this.setID(ID);
    }

    public User() {
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}
