import java.util.*;

public class BankingApp {

    private BankAccount account;
    private Scanner scanner;

    public BankingApp() {
        account = new BankAccount();
        scanner = new Scanner(System.in);
    }

    public void start() {

        int choice;

        do {

            displayMenu();

            choice = readMenuChoice();

            switch (choice) {

                case 1:
                    depositMoney();
                    break;

                case 2:
                    withdrawMoney();
                    break;

                case 3:
                    showBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using Banking Application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }

    public void displayMenu() {

        System.out.println("\n===== Banking Application =====");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Balance Inquiry");
        System.out.println("4. Exit");
    }

    public int readMenuChoice() {

        while (true) {

            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            try {

                int choice = Integer.parseInt(input);

                return choice;

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public void depositMoney() {

        double amount = readAmount("Enter deposit amount: ");

        if (amount <= 0) {

            System.out.println("Amount must be greater than zero.");
            return;
        }

        boolean success = account.deposit(amount);

        if (success) {

            System.out.printf("Deposit successful.%n");
            System.out.printf("Updated Balance: %.2f%n",
                    account.getBalance());
        }
    }

    public void withdrawMoney() {

        double amount = readAmount("Enter withdrawal amount: ");

        int result = account.withdraw(amount);

        if (result == 0) {

            System.out.println("Withdrawal successful.");
            System.out.printf("Updated Balance: %.2f%n",
                    account.getBalance());

        } else if (result == 1) {

            System.out.println("Amount must be greater than zero.");

        } else if (result == 2) {

            System.out.println("Insufficient balance.");
        }
    }

    public void showBalance() {

        System.out.printf("Current Balance: %.2f%n",
                account.getBalance());
    }

    public double readAmount(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                double amount = Double.parseDouble(input);

                if (Double.isNaN(amount) ||
                        Double.isInfinite(amount)) {

                    System.out.println("Please enter a valid amount.");
                    continue;
                }

                return amount;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a numeric value.");
            }
        }
    }
}