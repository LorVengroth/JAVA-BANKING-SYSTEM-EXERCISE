package Banking.System.Exercise;

import java.util.List;

public interface BankingService {
    void transfer(Account source , Account target , Double amount);
    void withdraw(Account account , Double amount);
    void deposit(Account account , Double amount);
    Double showBalance(Account account);
    void createAccount(Account account);
    void deleteAccount(String accountNum);
    List<Account> viewAllAccount();
    void updateAccount( Account UpdaetAccount , String accountNum);
    Account searchAccount(List<Account> accounts , String accountNum);
    void displaySearchAccount(Account account);
    Account loginLogic(List<Account> accounts , String accountNumber , Integer pinCode );
    void adminService();
    void customerService( Account account);
    Account inputInformation();
    String inputAccountNumber();
    void displayAllAccount(List<Account> accounts);




}
