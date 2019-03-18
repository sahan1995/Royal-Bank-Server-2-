package lk.royalBank.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    private
    String empID;
    private String fname;
    private String mname;
    private String lname;
    private String dob;
    private String nic;
    private String country;
    private String city;
    private String address;
    private Double salary;
    private String gender;
    private String tel;
    private String role;
    private boolean isBlocked;

    @ManyToOne
    @JoinColumn(name = "brachID",referencedColumnName = "branchID")
    private
    Branch branch;


    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<BankAccount> bankAccounts;


    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Client> clients;


    public Employee() {
    }

    public Employee(String empID, String fname, String mname, String lname, String dob, String nic, String country, String city, String address, Double salary, String gender, String tel, String role, boolean isBlocked) {
        this.setEmpID(empID);
        this.setFname(fname);
        this.setMname(mname);
        this.setLname(lname);
        this.setDob(dob);
        this.setNic(nic);
        this.setCountry(country);
        this.setCity(city);
        this.setAddress(address);
        this.setSalary(salary);
        this.setGender(gender);
        this.setTel(tel);
        this.setRole(role);
        this.setBlocked(isBlocked);
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    @Override
    public String toString() {
        return "Employee{" +
                "empID='" + empID + '\'' +
                ", fname='" + fname + '\'' +
                ", mname='" + mname + '\'' +
                ", lname='" + lname + '\'' +
                ", dob='" + dob + '\'' +
                ", nic='" + nic + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", tel='" + tel + '\'' +
                ", role='" + role + '\'' +
                ", isBlocked=" + isBlocked +
                ", branch=" + branch +
                ", bankAccounts=" + bankAccounts +
                ", clients=" + clients +
                '}';
    }
}
