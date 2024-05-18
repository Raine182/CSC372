package account;
public class BankAccount {
    // Fields
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    // Constructor
    public BankAccount(String firstName, String lastName, int accountID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.balance = 0.0; // Initialize balance to zero
    }

    // Deposit method
    public void deposit(double amount) {
        this.balance += amount; // Add the amount to the existing balance
    }

    // Withdraw method (assuming this is what you meant instead of subtracting in deposit)
    public void withdraw(double amount) {
        this.balance -= amount; // Subtract the amount from the existing balance
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public double getBalance() {
        return balance;
    }

    // Account summary
    public void accountSummary() {
        System.out.println("Account Summary:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: $" + balance);
    }
}