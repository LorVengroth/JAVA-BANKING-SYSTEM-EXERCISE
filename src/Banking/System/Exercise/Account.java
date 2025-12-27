package Banking.System.Exercise;

import java.math.BigDecimal;

public class Account {
    private final String accountNumber ;
    private Double balance = 0.0 ;
    private String name ;

    public Account(String accountNumber , String name) {
        this.accountNumber = accountNumber;
        this.name = name ;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }
}
