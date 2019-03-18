package lk.royalBank.entity;


import javax.persistence.*;

@Entity
public class Deposit {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "G2")
    @TableGenerator(name = "G2",table = "AutoIncrement",allocationSize = 1,valueColumnName = "nextID")
    private int depositID;

    private String dateAndTime;

    private double amount;

    private String depositerName;

    private String depositType;

    public Deposit(String dateAndTime, double amount, String depositerName, String depositType) {
        this.dateAndTime = dateAndTime;
        this.amount = amount;
        this.depositerName = depositerName;
        this.depositType = depositType;
    }

    public String getDepositerName() {
        return depositerName;
    }

    public void setDepositerName(String depositerName) {
        this.depositerName = depositerName;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    @ManyToOne
    @JoinColumn(name = "accountNumber",referencedColumnName = "accountNumber")
    private
    BankAccount bankAccount;



    public Deposit() {
    }


    public int getDepositID() {
        return depositID;
    }

    public void setDepositID(int depositID) {
        this.depositID = depositID;
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

    @Override
    public String toString() {
        return "Deposit{" +
                "depositID=" + depositID +
                ", dateAndTime='" + dateAndTime + '\'' +
                ", amount=" + amount +
                ", depositerName='" + depositerName + '\'' +
                ", depositType='" + depositType + '\'' +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
