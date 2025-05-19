package mp;
import java.math.BigDecimal;

// IMPROVEMENT: Common fields and methods for these transactions can be
// moved to the parent

public class DepositTransaction extends Transaction {
    private BigDecimal amount;
    private Account account;
    public DepositTransaction(BigDecimal amount, Account account) {
        this.amount = amount;;
        this.account = account;
    }
    public void execute() {
        this.account.credit(amount);
        System.out.println("Deposit transaction executed.");
    }
}