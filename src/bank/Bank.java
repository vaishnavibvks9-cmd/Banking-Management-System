package bank;

import java.util.HashMap;

public class Bank {
    private HashMap<Integer, Account> accounts = new HashMap<>();

    public void createAccount(int accNo, String name, double balance) {
        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists!");
            return;
        }
        Account acc = new SavingsAccount(accNo, name, balance);
        accounts.put(accNo, acc);
        System.out.println("Account created successfully.");
    }

    public Account getAccount(int accNo) {
        return accounts.get(accNo);
    }

    public void showBalance(int accNo) {
        Account acc = getAccount(accNo);
        if (acc != null) {
            System.out.println("Balance: " + acc.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }
}