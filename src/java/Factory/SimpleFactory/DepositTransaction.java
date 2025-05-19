package mp;
import java.math.BigDecimal;

// IMPROVED: Common fields moved to a base class
public class DepositTransaction extends Transaction {
    public DepositTransaction(BigDecimal amount, Account account) {
        super(amount, account);
    }

    @Override
    public void execute() {
        this.account.credit(amount);
        System.out.println("Deposit transaction executed.");
    }
}