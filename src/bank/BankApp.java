package bank;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {

        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Banking Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Account Number: ");
                        int accNo = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Holder Name: ");
                        String name = sc.nextLine();
                        System.out.print("Initial Balance: ");
                        double bal = sc.nextDouble();
                        bank.createAccount(accNo, name, bal);
                        break;

                    case 2:
                        System.out.print("Account Number: ");
                        accNo = sc.nextInt();
                        System.out.print("Amount: ");
                        double dep = sc.nextDouble();
                        bank.getAccount(accNo).deposit(dep);
                        break;

                    case 3:
                        System.out.print("Account Number: ");
                        accNo = sc.nextInt();
                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();
                        bank.getAccount(accNo).withdraw(amt);
                        break;

                    case 4:
                        System.out.print("Account Number: ");
                        accNo = sc.nextInt();
                        bank.showBalance(accNo);
                        break;

                    case 5:
                        System.out.println("Thank you!");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }
}