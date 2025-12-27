package Banking.System.Exercise;

import java.util.List;

public interface BankingService {
    void transfer(Account source , Account target , Double amount);
    void withdraw(Account account , Double amount);
    void deposit(Account account , Double amount);
    void showBalance(Account account);
    void createAccount(List<Account> accounts , Account account);
    void deleteAccount(List<Account> accounts , Account account);
    void viewAllAccount(List<Account> accounts);
    void updateAccount(List<Account> accounts , Account UpdaetAccount , String accountNum);
    Account searchAccount(List<Account> accounts , String accountNum);
    void displaySearchAccount(Account account);



}
