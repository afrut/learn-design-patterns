package mp;
import java.math.BigDecimal;

public abstract class Transaction {
    // IMPROVED: Move common fields and methods to a base class
    protected BigDecimal amount;
    protected Account account;

    public Transaction(BigDecimal amount, Account account) {
        this.amount = amount;
        this.account = account;
    }

    // IMPROVED: Specified an abstract method so that subclasses must implement it
    public abstract void execute();
}