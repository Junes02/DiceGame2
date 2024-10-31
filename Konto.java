public class Konto {
    private int balance;

    public Konto(int startBalance) {
        this.balance = startBalance;
    }

    public boolean indsæt(int amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean hæv(int amount) {
        if (amount > 0 && balance - amount >= 0) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Balance: " + balance;
    }
}