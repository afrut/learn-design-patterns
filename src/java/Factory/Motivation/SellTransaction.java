package mp;
import java.math.BigDecimal;

// IMPROVEMENT: Common fields and methods for these transactions can be
// moved to the parent

public class SellTransaction extends Transaction {
    private BigDecimal amount;
    private Account account;
    private BigDecimal commission;
    public SellTransaction(BigDecimal amount, Account account, BigDecimal commission) {
        this.amount = amount;;
        this.account = account;
        this.commission = commission;
    }
    public void execute() {
        this.account.credit(amount.subtract(commission));
        System.out.println("Sell transaction executed.");
    }
}