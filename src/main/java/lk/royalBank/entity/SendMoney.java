package lk.royalBank.entity;

import javax.persistence.*;

@Entity
public class SendMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "G2")
    @TableGenerator(name = "G2",table = "AutoIncrement",allocationSize = 1,valueColumnName = "nextID")
    private
    int sendMoneyID;

    private String dateAndTime;

    private double amount;

    private String depositAccount;

    @ManyToOne
    @JoinColumn(name = "accountNumber",referencedColumnName = "accountNumber")
    private
    BankAccount bankAccount;

    public SendMoney(String dateAndTime, double amount, String depositAccount) {
        this.setDateAndTime(dateAndTime);
        this.setAmount(amount);
        this.setDepositAccount(depositAccount);
    }


    public SendMoney(String dateAndTime, double amount, String depositAccount, BankAccount bankAccount) {
        this.dateAndTime = dateAndTime;
        this.amount = amount;
        this.depositAccount = depositAccount;
        this.bankAccount = bankAccount;
    }

    public SendMoney() {
    }


    public int getSendMoneyID() {
        return sendMoneyID;
    }

    public void setSendMoneyID(int sendMoneyID) {
        this.sendMoneyID = sendMoneyID;
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

    public String getDepositAccount() {
        return depositAccount;
    }

    public void setDepositAccount(String depositAccount) {
        this.depositAccount = depositAccount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "SendMoney{" +
                "sendMoneyID=" + sendMoneyID +
                ", dateAndTime='" + dateAndTime + '\'' +
                ", amount=" + amount +
                ", depositAccount='" + depositAccount + '\'' +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
