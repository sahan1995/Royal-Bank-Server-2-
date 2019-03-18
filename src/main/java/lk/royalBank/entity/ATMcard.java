package lk.royalBank.entity;

import javax.persistence.*;

@Entity
public class ATMcard {

    @Id
    private
    String code;
    @Column(unique = true)
    private
    String pin;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountNumber",referencedColumnName = "accountNumber")
    private
    BankAccount bankAccount;

    public ATMcard(String code, String pin) {
        this.setCode(code);
        this.setPin(pin);
    }

    public ATMcard() {
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "ATMcard{" +
                "code='" + code + '\'' +
                ", pin='" + pin + '\'' +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
