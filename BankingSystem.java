public class BankingSystem {
    public static void main(String[] args) {
        BankingService account = new Account();
        Transaction transaction = new Transaction();

        // TC1: Deposit ₹1000
        account.deposit(1000);

        // TC2: Withdraw ₹500 from ₹1000
        account.withdraw(500);

        // TC3: Withdraw ₹1500 from ₹500
        account.withdraw(1500);

        // TC4: Deposit negative amount
        account.deposit(-200);

        // TC5: Log transaction
        transaction.log();
    }
}
