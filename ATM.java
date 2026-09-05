import java.util.Scanner;

// Bank Account Class
class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double checkBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {

        if (amount <= 0) {
            return false;
        }

        if (amount > balance) {
            return false;
        }

        balance = balance - amount;
        return true;
    }

    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance = balance + amount;
        return true;
    }
}

// ATM Class
public class ATM {

    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    public void withdraw(double amount) {

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
            System.out.println("Amount withdrawn: ₹" + amount);
            System.out.println("Remaining balance: ₹"
                    + account.checkBalance());
        } else {
            System.out.println("Withdrawal failed.");
            System.out.println("Please check the amount or your balance.");
        }
    }

    public void deposit(double amount) {

        if (account.deposit(amount)) {
            System.out.println("Deposit successful.");
            System.out.println("Amount deposited: ₹" + amount);
            System.out.println("Current balance: ₹"
                    + account.checkBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹"
                + account.checkBalance());
    }

    public void start() {

        int choice;

        System.out.println("================================");
        System.out.println("          ATM INTERFACE");
        System.out.println("================================");

        do {

            System.out.println("\n1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount(10000);

        ATM atm = new ATM(account);

        atm.start();
    }
}
