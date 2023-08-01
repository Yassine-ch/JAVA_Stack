public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int totalAccounts;
    private static double totalAmount;
    private long accountNumber;

    public BankAccount() {
        this.accountNumber = createAccountNumber();
        totalAccounts++;
    }

    private long createAccountNumber() {
        long accountNumber = (long) Math.floor((Math.random()* 9000000000L) + 1000000000L);
        return accountNumber;
    }

    public void deposit(String account, double amount) {
        if (account.equals("checking")) {
            this.checkingBalance += amount;
            totalAmount += amount;
        } else if (account.equals("savings")) {
            this.savingsBalance += amount;
            totalAmount += amount;
        }
    }
    


    public void withdraw(String account, double amount) {

        if (account.equals("checking") && this.checkingBalance >= amount) {
            this.checkingBalance -= amount;
            totalAmount -= amount;
        } else if (account.equals("savings") && this.savingsBalance >= amount) {
            this.savingsBalance -= amount;
            totalAmount -= amount;
        }
        
    }

    // getters

    public double getTotalBalances() {
        return this.checkingBalance + this.savingsBalance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }
    public double getSavingsBalance() {
        return savingsBalance;
    }
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    public static double getTotalAmount() {
        return totalAmount;
    }
}