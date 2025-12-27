package Banking.System.Exercise;

import java.util.List;

public class BankingServiceImpl implements BankingService {
    @Override
    public void transfer(Account source, Account target, Double amount) {
        source.setBalance( source.getBalance() - amount);
        target.setBalance(target.getBalance() + amount);
    }

    @Override
    public void withdraw(Account account, Double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    @Override
    public void deposit(Account account, Double amount) {
        account.setBalance(account.getBalance() - amount);
    }

    @Override
    public void showBalance(Account account) {
        System.out.println(account.getBalance());
    }

    @Override
    public void createAccount(List<Account> accounts , Account account) {
        accounts.add(account);
    }

    @Override
    public void deleteAccount(List<Account> accounts, Account account) {
        accounts.remove(account);
    }

    @Override
    public void viewAllAccount(List<Account> accounts) {
        System.out.println(accounts);
    }

    @Override
    public void updateAccount(List<Account> accounts, Account UpdaetAccount , String accountNum ) {
        accounts.replaceAll(acc -> acc.getAccountNumber().equals(accountNum) ? UpdaetAccount : acc);
    }

    /*
    acc -> ...: This tells Java: "Take every individual Account (let's call it acc) inside the accounts list one by one."

    The Condition (?): It checks: "Does this specific account's number match the one I'm looking for?"

    The Result if True: If the numbers match, it replaces that account with your updatedAccount.

    The Result if False (: acc): If they don't match, it tells Java: "Just keep the original account (acc) exactly where it is."
     */

    @Override
    public Account searchAccount(List<Account> accounts, String accountNum) {
         return accounts.stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNum))
                .findFirst()
                .orElse(null);

    }

    @Override
    public void displaySearchAccount(Account account) {
        System.out.println(account.getBalance());
        System.out.println(account.getAccountNumber());
        System.out.println(account.getName());
    }
}
