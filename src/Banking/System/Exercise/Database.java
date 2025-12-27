package Banking.System.Exercise;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Account> accountList ;
    public Database(){
        accountList = new ArrayList<>();

        Account acc1 = new Account("123456" , "Lor Vengroth" , 8560);
        Account acc2 = new Account("234567" , "Luo yonglun" , 2445);
        Account adminAcc = new Account("168168" , "Admin" , 1681);

        accountList.add(acc1);
        accountList.add(acc2);
        accountList.add(adminAcc);
    }



    public void createAccount(Account account){
        accountList.add(account);
    }

    public Account findAccount(String accountNum){
       return accountList.stream()
               .filter(acc -> acc.getAccountNumber().equals(accountNum))
               .findFirst()
               .orElse(null);
     }

   public void deleteAccount(String accountNum){
        Account delAcc = findAccount(accountNum);
        accountList.remove(delAcc);
   }

   public List<Account> displayAllAccount(){
        return accountList ;
   }

   public void updateAccount(String accountNum , Account updAccount){

       accountList.replaceAll(acc ->
               acc.getAccountNumber().equals(accountNum) ? updAccount : acc
       );
       System.out.println("Success");

   }


   public void deposit(Account account , Double amount){
        account.setBalance(account.getBalance() + amount);
   }

   public void withdraw(Account account , Double amount){
        account.setBalance(account.getBalance() - amount);
   }

   public void transfer(Account source , Account target , Double amount){
        source.setBalance(source.getBalance() - amount);
        target.setBalance(target.getBalance() + amount);
   }

   public Double checkBalance(Account account){
        return account.getBalance() ;
   }

   public Account loginLogic(List<Account> accounts , String accountNumber , Integer pinCode){
       return accounts.stream()
               .filter(acc -> acc.getAccountNumber().equals(accountNumber) && acc.getPin().equals(pinCode))
               .findFirst()
               .orElse(null); // Returns null if login fails
   }


   public boolean validatePinCode(Account account , Integer pinCode){
       if(!account.getPin().equals(pinCode));
       return false ;
   }
}
