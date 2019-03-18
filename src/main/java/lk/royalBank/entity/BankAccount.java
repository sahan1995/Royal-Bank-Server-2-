package lk.royalBank.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class BankAccount {
    @Id
    private
    String accountNumber;
    private double amount;
    private String createdAt;
    private String accountType;

    @ManyToOne
    @JoinColumn(name = "clientID", referencedColumnName = "clientID")
    private
    Client client;

    @ManyToOne
    @JoinColumn(name = "empID", referencedColumnName = "empID")
    private
    Employee employee;

    public ATMcard getAtmCard() {
        return atmCard;
    }

    public void setAtmCard(ATMcard atmCard) {
        this.atmCard = atmCard;
    }

    @OneToOne(mappedBy = "bankAccount", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private ATMcard atmCard;

    @OneToMany(mappedBy = "bankAccount",fetch = FetchType.LAZY)
    private List<Deposit> deposits;
    @OneToMany(mappedBy = "bankAccount",fetch = FetchType.LAZY)
    private List<Withdraw> withdraws;
    @OneToMany(mappedBy = "bankAccount",fetch = FetchType.LAZY)
    private List<SendMoney> sendMonies;



    public BankAccount(String accountNumber, double amount, String createdAt, String accountType) {
        this.setAccountNumber(accountNumber);
        this.setAmount(amount);
        this.setCreatedAt(createdAt);
        this.setAccountType(accountType);
    }

    public BankAccount() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }

    public List<Withdraw> getWithdraws() {
        return withdraws;
    }

    public void setWithdraws(List<Withdraw> withdraws) {
        this.withdraws = withdraws;
    }

    public List<SendMoney> getSendMonies() {
        return sendMonies;
    }

    public void setSendMonies(List<SendMoney> sendMonies) {
        this.sendMonies = sendMonies;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", amount=" + amount +
                ", createdAt='" + createdAt + '\'' +
                ", accountType='" + accountType + '\'' +
                ", client=" + client +
                ", employee=" + employee +
                ", atmCard=" + atmCard +
                ", deposits=" + deposits +
                ", withdraws=" + withdraws +
                ", sendMonies=" + sendMonies +
                '}';
    }
}
