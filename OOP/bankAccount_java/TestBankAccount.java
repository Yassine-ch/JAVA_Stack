public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount();


        // test deposit
        account1.deposit("checking", 500);
        account1.deposit("savings", 200);
        account1.deposit("dog", 200);

        // test getters
        System.out.println("account 1 checking: $" + account1.getCheckingBalance());
        System.out.println("account 1 savings: $" + account1.getSavingsBalance());
        System.out.println("account 1 total balance: $" + account1.getTotalBalances());
        System.out.println("total money from bank: $" + BankAccount.getTotalAmount());
        System.out.println("total accounts from bank: " + BankAccount.getTotalAccounts());

        account2.deposit("checking", 500);
        account3.deposit("savings", 600);

        // test withdraw method
        account1.withdraw("savings", 150);
        System.out.println("account 1 savings: $" + account1.getSavingsBalance());
        account1.withdraw("savings", 150);
        System.out.println("account 1 savings: $" + account1.getSavingsBalance());

        System.out.println("total money from bank: $" + BankAccount.getTotalAmount());

        // test account number implementation
        System.out.println("account 1 account number: " + account1.getAccountNumber());
    }
}