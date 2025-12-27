package Banking.System.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankingService bankingService = new BankingServiceImpl();
        List<Account> accounts = new ArrayList<>();
        Account acc1 = new Account("12345" , "Lor Vengroth");
        accounts.add(acc1);
        Account acc2 = new Account("123456" , "Luo Yonglun");
        accounts.add(acc2);
        Account acc3 = new Account("123" , "Luo Yongling");
        accounts.add(acc3);
        acc1.setBalance(100.0);
        acc2.setBalance(200.0);
        bankingService.transfer(acc1 , acc2 , 50.0);
        System.out.println(accounts);
//        String accNum = scanner.nextLine();
//        String name = scanner.nextLine();
//        Account newAcc = new Account(accNum , name);
////        bankingService.createAccount(accounts , newAcc);
////        System.out.println(accounts);
//        bankingService.updateAccount(accounts , newAcc , accNum );
//        System.out.println(accounts);
        System.out.println("===========================================");
        Account searchAcc = bankingService.searchAccount(accounts , "12345");
        bankingService.displaySearchAccount(searchAcc);



    }
}
