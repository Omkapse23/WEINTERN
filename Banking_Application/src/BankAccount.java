
public class BankAccount {

    private double balance;

    public BankAccount() {
        balance = 0.0;
    }

    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance = balance + amount;
        return true;
    }

    public int withdraw(double amount) {

        if (amount <= 0) {
            return 1;
        }

        if (amount > balance) {
            return 2;
        }

        balance = balance - amount;
        return 0;
    }

    public double getBalance() {
        return balance;
    }
}