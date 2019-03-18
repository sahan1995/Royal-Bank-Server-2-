package lk.royalBank.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {

    @Id
    private
    String clientID;
    private String fname;
    private String mname;
    private String lname;
    private String gender;
    private String dob;
    private String nic;
    private String country;
    private String city;
    private String address;
    private String tel;
    private String email;
    private String occupation;
    private boolean isBlocked;

    @ManyToOne
    @JoinColumn(name = "branchID",referencedColumnName = "branchID")
    private
    Branch branch;

    @ManyToOne
    @JoinColumn(name = "empID",referencedColumnName = "empID")
    private
    Employee employee;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<BankAccount> bankAccounts;

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }


    public Client(String clientID, String fname, String mname, String lname, String gender, String dob, String nic, String country, String city, String address, String tel, String email, String occupation, boolean isBlocked) {
        this.setClientID(clientID);
        this.setFname(fname);
        this.setMname(mname);
        this.setLname(lname);
        this.setGender(gender);
        this.setDob(dob);
        this.setNic(nic);
        this.setCountry(country);
        this.setCity(city);
        this.setAddress(address);
        this.setTel(tel);
        this.setEmail(email);
        this.setOccupation(occupation);
        this.setBlocked(isBlocked);
    }

    public Client() {
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID='" + clientID + '\'' +
                ", fname='" + fname + '\'' +
                ", mname='" + mname + '\'' +
                ", lname='" + lname + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", nic='" + nic + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", occupation='" + occupation + '\'' +
                ", isBlocked=" + isBlocked +
                ", branch=" + branch +
                ", employee=" + employee +
                ", bankAccounts=" + bankAccounts +
                '}';
    }
}
