package Banking.System.Exercise;

import java.util.List;
import java.util.Scanner;

public class BankingServiceImpl implements BankingService {
    Scanner scanner = new Scanner(System.in);

    private final Database database ;

    public BankingServiceImpl(){
        database = new Database();
    }

    @Override
    public void transfer(Account source, Account target, Double amount) {
        database.transfer(source , target , amount);
    }

    @Override
    public void withdraw(Account account, Double amount) {
        database.withdraw(account, amount );
    }

    @Override
    public void deposit(Account account, Double amount) {
        database.deposit(account , amount);
    }

    @Override
    public Double showBalance(Account account) {
        return database.checkBalance(account);
    }

    @Override
    public void createAccount(Account account) {
        database.createAccount( account);
    }

    @Override
    public void deleteAccount(String accountNum) {
       database.deleteAccount(accountNum);
    }

    @Override
    public List<Account> viewAllAccount() {

        return database.displayAllAccount();
    }

    @Override
    public void updateAccount(Account updateAccount , String accountNum ) {
      database.updateAccount(accountNum , updateAccount);
    }


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

    @Override
    public Account loginLogic(List<Account> accounts , String accountNumber , Integer pinCode) {
        return database.loginLogic(accounts , accountNumber , pinCode);
    }

    @Override
    public Account inputInformation() {

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your Account number: ");
        String accNum = scanner.nextLine();
        System.out.println("Enter your Pin code: ");
        int pin = scanner.nextInt();
        scanner.nextLine();

        return new Account(accNum, name, pin);
    }

    @Override
    public String inputAccountNumber() {
        System.out.print("Enter your account number : ");
        String accountNumber = scanner.nextLine();
        return accountNumber;
    }

    @Override
    public void adminService(int option) {
        switch (option){
            case 1 -> {
                Account newAccount = inputInformation();
                createAccount(newAccount);
                System.out.println("Account created successfully");
            }
            case 2 -> {

                System.out.println(viewAllAccount());
            }
            case 3 -> {
                System.out.print("Enter your account number : ");
                String accountNumber = scanner.nextLine();
                Account updateAccount = inputInformation();
                updateAccount(updateAccount , accountNumber);
            }
            case 4 -> {

                String accNum = inputAccountNumber() ;
                Account SearchAccount = searchAccount(viewAllAccount() , accNum);
                System.out.println(SearchAccount);

            }
            case 5 -> {
                String accNum = inputAccountNumber();
                deleteAccount(accNum);
            }

        }
    }

    @Override
    public void customerService(int option , Account account) {
        switch (option){
            case 1 -> {
//                System.out.println("Enter your account number : ");
//                String accountNum = inputAccountNumber();
                System.out.println("Enter amount to deposit : ");
                Double amount = scanner.nextDouble();
//                Account account = searchAccount(viewAllAccount() , accountNum);
                deposit(account , amount);
            }
            case 2 -> {
//                System.out.println("Enter your account number : ");
//                String accountNum = inputAccountNumber() ;
                System.out.println("Enter amount to withdraw");
                Double amount = scanner.nextDouble();
//                Account account = searchAccount(viewAllAccount() , accountNum);
                withdraw(account , amount);

            }
            case 3 -> {
//                System.out.println("Enter account number to transfer money : ");
//                String accNum1 = inputAccountNumber();
//                Account source = searchAccount(viewAllAccount() , accNum1);
                System.out.println("Enter account number to receive money : ");
                String accNum2 = inputAccountNumber();
                Account target = searchAccount(viewAllAccount() , accNum2);
                System.out.println("Enter amount to transfer : ");
                Double amount = scanner.nextDouble();

                transfer(account , target , amount);
            }
            case 4 -> {
//                System.out.println("Enter account number : ");
//                String accountNum = inputAccountNumber() ;
//                Account account = searchAccount(viewAllAccount() , accountNum);
                System.out.println(showBalance(account));

            }
    }
}}
