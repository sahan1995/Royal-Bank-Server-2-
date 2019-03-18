package lk.royalBank.entity;

import javax.persistence.*;

@Entity
public class Withdraw {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "G2")
    @TableGenerator(name = "G2",table = "AutoIncrement",allocationSize = 1,valueColumnName = "nextID")
    private
    int widthdrawID;

    private String dateAndTime;

    private double amount;

    private String widthdrawType;

    private String widthdrawerName;



    @ManyToOne
    @JoinColumn(name = "accountNumber",referencedColumnName = "accountNumber")
    private
    BankAccount bankAccount;

    public Withdraw(String dateAndTime, double amount, String widthdrawType, String widthdrawerName) {
        this.dateAndTime = dateAndTime;
        this.amount = amount;
        this.widthdrawType = widthdrawType;
        this.widthdrawerName = widthdrawerName;
    }

    public Withdraw() {
    }


    public int getWidthdrawID() {
        return widthdrawID;
    }

    public void setWidthdrawID(int widthdrawID) {
        this.widthdrawID = widthdrawID;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getWidthdrawType() {
        return widthdrawType;
    }

    public void setWidthdrawType(String widthdrawType) {
        this.widthdrawType = widthdrawType;
    }

    public String getWidthdrawerName() {
        return widthdrawerName;
    }

    public void setWidthdrawerName(String widthdrawerName) {
        this.widthdrawerName = widthdrawerName;
    }

    @Override
    public String toString() {
        return "Withdraw{" +
                "widthdrawID=" + widthdrawID +
                ", dateAndTime='" + dateAndTime + '\'' +
                ", amount=" + amount +
                ", widthdrawType='" + widthdrawType + '\'' +
                ", widthdrawerName='" + widthdrawerName + '\'' +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
