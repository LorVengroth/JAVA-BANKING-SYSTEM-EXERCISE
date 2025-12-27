package Banking.System.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    BankingService bankingService = new BankingServiceImpl();

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
                System.out.println("Enter your Pin code : ");
                int pinCode = scanner.nextInt();
                scanner.nextLine();

                Account LoginAccount = bankingService.loginLogic(accountList , accountNum , pinCode);

                if (LoginAccount == null) {

                    System.out.println("Invalid credentials!");

                } else if (LoginAccount.getName().equalsIgnoreCase("Admin")) {

                    do {
                        System.out.println(PrintUtil.MENUforADMIN);
                        System.out.print("Enter your option : ");
                        int optionForAdmin = scanner.nextInt();
                        bankingService.adminService(optionForAdmin);
                    }while (true);


                } else {

                    do {
                        System.out.println(PrintUtil.MENUforCUSTOMER);
                        System.out.print("Enter your option : ");
                        int optionForCustomer = scanner.nextInt();
                        bankingService.customerService(optionForCustomer , LoginAccount);
                    }while(true);

                }
            }
            case 2 -> {

                System.out.println("Exit");

            }
            default -> System.out.println("thanks for your using");
        }




    }
}
