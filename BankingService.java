interface BankingService {
    void deposit(double amount);
    void withdraw(double amount);
    void showBalance();
}


class Account implements BankingService {
    private double balance;

    public Account() {
        this.balance = 0.0;
    }

    private String formatAmount(double amount) {
        if (amount == (int) amount) {
            return String.valueOf((int) amount);
        } else {
            return String.valueOf(amount);
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit ₹" + formatAmount(amount) + " → Balance = ₹" + formatAmount(balance));
        } else {
            System.out.println("Deposit ₹" + formatAmount(amount) + " → Output: Invalid");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            System.out.println("Withdraw ₹" + formatAmount(amount) + " from ₹" 
                               + formatAmount(balance) + " → Balance = ₹" + formatAmount(balance - amount));
            balance -= amount;
        } else if (amount > balance) {
            System.out.println("Withdraw ₹" + formatAmount(amount) + " from ₹" 
                               + formatAmount(balance) + " → Output: Insufficient funds");
        } else {
            System.out.println("Withdraw ₹" + formatAmount(amount) + " → Output: Invalid");
        }
    }

    @Override
    public void showBalance() {
        System.out.println("Current Balance = ₹" + formatAmount(balance));
    }
}


class Transaction {
    public void log() {
        System.out.println("Transaction recorded");
    }
}
