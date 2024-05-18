package account;
public class CheckingAccount extends BankAccount {
    // New field for interest rate
    private double interestRate;

    // Constructor
    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID); // Call to superclass constructor
        this.interestRate = interestRate;
    }

    // Method to process withdrawal with overdraft
    public void processWithdrawal(double amount) {
        if (getBalance() < amount) {
            System.out.println("Overdraft! A $30 fee has been accessed.");
            super.withdraw(amount + 30); // Withdraw the amount plus the overdraft fee
        } else {
            super.withdraw(amount);
        }
    }

    // Display account information including interest rate
    public void displayAccount() {
        super.accountSummary(); // Display superclass attributes
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    // Setters and getters for interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
    
    public class Main {
        public static void main(String[] args) {
            // Create an instance of BankAccount
            BankAccount bankAccount = new BankAccount("Tinker", "Bell", 789012);

            // Create an instance of CheckingAccount
            CheckingAccount checkingAccount = new CheckingAccount("Peter", "Pan", 123456, 0.75);

            // Display initial account information
            System.out.println("Bank Account Information:");
            bankAccount.accountSummary();
            System.out.println("\nChecking Account Information:");
            checkingAccount.displayAccount();

            // Deposit money into the BankAccount
            bankAccount.deposit(1000.0);
            System.out.println("\nAfter depositing $1000 into the Bank Account:");
            bankAccount.accountSummary();

            // Deposit money into the CheckingAccount
            checkingAccount.deposit(1500.0);
            System.out.println("\nAfter depositing $1500 into the Checking Account:");
            checkingAccount.displayAccount();

            // Withdraw money from the CheckingAccount without overdraft
            checkingAccount.processWithdrawal(500.0);
            System.out.println("\nAfter withdrawing $500 from the Checking Account (without overdraft):");
            checkingAccount.displayAccount();

            // Withdraw money from the CheckingAccount with overdraft
            checkingAccount.processWithdrawal(1200.0);
            System.out.println("\nAfter withdrawing $1200 from the Checking Account (with overdraft):");
            checkingAccount.displayAccount();
        }
    }
}