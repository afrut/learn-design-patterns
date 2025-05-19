package mp;

// Represent financial accounts
import java.math.BigDecimal;

public class Account {
    private int id;
    private BigDecimal balance;
    public Account(int acc) {
        this.id = acc;
        this.balance = BigDecimal.ZERO;
    }

    public Account(int acc, BigDecimal balance) {
        this.id = acc;
        this.balance = balance;
    }

    public void debit(BigDecimal amount) {
        if (this.balance.compareTo(amount) >= 0) {
            this.balance = this.balance.subtract(amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void credit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }
}