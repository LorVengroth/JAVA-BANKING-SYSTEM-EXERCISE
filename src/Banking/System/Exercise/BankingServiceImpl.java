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
    public void displayAllAccount(List<Account> accounts) {
        for (Account account : accounts){
            System.out.println("Account Number : " + account.getAccountNumber());
            System.out.println( "Account Name : " +  account.getName());
            System.out.println("Account Balance : " + account.getBalance());
            System.out.println("Account Pin Code : " + account.getPin());
            System.out.println("--------------------");
        }
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
        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.println( "Account Name : " +  account.getName());
        System.out.println("Account Balance : " + account.getBalance());
        System.out.println("Account Pin Code : " + account.getPin());
        System.out.println("--------------------");
    }

    @Override
    public Account loginLogic(List<Account> accounts , String accountNumber , Integer pinCode) {
        return database.loginLogic(accounts , accountNumber , pinCode);
    }

    @Override
    public Account inputInformation() {

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your Account number: ");
        String accNum = scanner.nextLine();
        System.out.print("Enter your Pin code: ");
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
    public void adminService() {
        while(true){
            System.out.println(PrintUtil.MENUforADMIN);
            System.out.print("Enter your option : ");
            int optionForAdmin = scanner.nextInt();
            switch (optionForAdmin){
                case 1 -> {
                    Account newAccount = inputInformation();
                    createAccount(newAccount);
                    System.out.println("Account created successfully");
                }
                case 2 -> {

                    displayAllAccount(viewAllAccount());

                }
                case 3 -> {
                    System.out.print("Enter your account number : ");
                    String accountNumber = scanner.nextLine();
                    Account updateAccount = inputInformation();
                    updateAccount(updateAccount , accountNumber);
                }
                case 4 -> {
                    scanner.nextLine();
                    String accNum = inputAccountNumber() ;
                    Account SearchAccount = searchAccount(viewAllAccount() , accNum);
                    displaySearchAccount(SearchAccount);

                }
                case 5 -> {
                    String accNum = inputAccountNumber();
                    deleteAccount(accNum);
                }
                case 6 -> {
                    return ;
                }


            }



        }
    }

    @Override
    public void customerService( Account account) {
        while(true){
            System.out.println(PrintUtil.MENUforCUSTOMER);
            System.out.print("Enter your option : ");
            int optionForCustomer = scanner.nextInt();
            switch (optionForCustomer){
                case 1 -> {
//                System.out.println("Enter your account number : ");
//                String accountNum = inputAccountNumber();
                    System.out.print("Enter amount to deposit : ");
                    Double amount = scanner.nextDouble();
//                Account account = searchAccount(viewAllAccount() , accountNum);
                    deposit(account , amount);
                }
                case 2 -> {
//                System.out.println("Enter your account number : ");
//                String accountNum = inputAccountNumber() ;
                    System.out.print("Enter amount to withdraw");
                    Double amount = scanner.nextDouble();
//                Account account = searchAccount(viewAllAccount() , accountNum);
                    withdraw(account , amount);

                }
                case 3 -> {
//

                scanner.nextLine();
                    System.out.print("Enter account number to receive money : ");
                    String accNum2 = scanner.nextLine();
                    Account target = searchAccount(viewAllAccount() , accNum2);
                    System.out.print("Enter amount to transfer : ");
                    Double amount = scanner.nextDouble();
                    scanner.nextLine();
                    displaySearchAccount(target);
                    transfer(account , target , amount);
                }
                case 4 -> {
                    System.out.println(showBalance(account));

                }
                case 5 -> { return; }
            }
        }

}}
