public class Account {

    private double balance;

    public Account() {
        balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("new balance=" + balance + "$");
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new NotEnoughMoneyException(amount, balance);
        }

        balance -= amount;
        System.out.println("new balance=" + balance + "$");
    }

    public double getBalance() {
        return balance;
    }
}
