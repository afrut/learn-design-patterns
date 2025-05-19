package mp;
import java.math.BigDecimal;

// IMPROVEMENT: Common fields and methods for these transactions can be
// moved to the parent

public class WithdrawTransaction extends Transaction {
    private BigDecimal amount;
    private Account account;
    public WithdrawTransaction(BigDecimal amount, Account account) {
        this.amount = amount;;
        this.account = account;
    }
    public void execute() {
        this.account.debit(amount);
        System.out.println("Withdraw transaction executed.");
    }
}