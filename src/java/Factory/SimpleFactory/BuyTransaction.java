package mp;
import java.math.BigDecimal;

// IMPROVED: Common fields moved to a base class
public class BuyTransaction extends Transaction {
    private BigDecimal commission;
    public BuyTransaction(BigDecimal amount, Account account, BigDecimal commission) {
        super(amount, account);
        this.commission = commission;
    }

    @Override
    public void execute() {
        this.account.debit(amount.add(commission));
        System.out.println("Buy transaction executed.");
    }
}