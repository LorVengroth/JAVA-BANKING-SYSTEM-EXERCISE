package Banking.System.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    BankingService bankingService = new BankingServiceImpl();

    do {
        System.out.println(PrintUtil.MENU);
        System.out.print("Please Enter your option : ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option){
            case 1 -> {
                List<Account> accountList = bankingService.viewAllAccount();
                System.out.println(PrintUtil.LOGIN);
                System.out.print("Enter your account number : ");
                String accountNum = scanner.nextLine();
                System.out.print("Enter your Pin code : ");
                int pinCode = scanner.nextInt();
                scanner.nextLine();
                Account LoginAccount = bankingService.loginLogic(accountList , accountNum , pinCode);
                if (LoginAccount == null) {
                    System.out.println("Invalid credentials!");
                } else if (LoginAccount.getName().equalsIgnoreCase("Admin")) {


                        bankingService.adminService();

                } else {


                        bankingService.customerService( LoginAccount);

                }
            }
            case 2 -> {
                System.exit(0);
            }
            default -> System.out.println("thanks for your using");
        }
    }while(true);

    }
}
