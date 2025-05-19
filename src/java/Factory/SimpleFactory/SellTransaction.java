package mp;
import java.math.BigDecimal;

// IMPROVED: Common fields moved to a base class
public class SellTransaction extends Transaction {
    private BigDecimal commission;
    public SellTransaction(BigDecimal amount, Account account, BigDecimal commission) {
        super(amount, account);
        this.commission = commission;
    }

    @Override
    public void execute() {
        this.account.credit(amount.subtract(commission));
        System.out.println("Sell transaction executed.");
    }
}