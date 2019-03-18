package lk.royalBank.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "G1")
    @TableGenerator(name = "G1",table = "AutoIncrement",allocationSize = 1,valueColumnName = "nextID")
    private
    int branchID;
    private String branchName;
    private String country;
    private String city;
    private String address;
    private String tel;

    @OneToMany(mappedBy = "branch",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Employee> employees;

    @OneToMany(mappedBy = "branch",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
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

    public Branch(String branchName, String country, String city, String address, String tel) {
        this.branchName = branchName;
        this.country = country;
        this.city = city;
        this.address = address;
        this.tel = tel;
    }

    public Branch() {
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchID=" + branchID +
                ", branchName='" + branchName + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", employees=" + employees +
                ", clients=" + clients +
                '}';
    }
}
