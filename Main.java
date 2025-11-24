import java.util.Scanner;

// A simple class to store account details and do basic operations
class BankAccount {
    private String name;
    private double balance;

    // Constructor to create a new account
    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    // Add money to account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Money deposited: " + amount);
        } else {
            System.out.println("Please enter a positive amount.");
        }
    }

    // Withdraw money from account
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a positive amount.");
        } 
        else if (amount > balance) {
            System.out.println("Not enough balance!");
        } 
        else {
            balance -= amount;
            System.out.println("Money withdrawn: " + amount);
        }
    }

    // Check current account balance
    public double getBalance() {
        return balance;
    }

    // Display account information
    public void showInfo() {
        System.out.println("-------------------");
        System.out.println("Account Holder: " + name);
        System.out.println("Current Balance: " + balance);
        System.out.println("-------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create account
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double initial = sc.nextDouble();

        BankAccount account = new BankAccount(name, initial);

        int choice;
        
        // Simple menu to use bank account
        do {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Show Account Details");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depAmount = sc.nextDouble();
                    account.deposit(depAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wdAmount = sc.nextDouble();
                    account.withdraw(wdAmount);
                    break;

                case 3:
                    System.out.println("Your Balance: " + account.getBalance());
                    break;

                case 4:
                    account.showInfo();
                    break;

                case 0:
                    System.out.println("Thank you. Visit again!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
