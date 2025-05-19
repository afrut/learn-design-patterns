package mp;
import java.math.BigDecimal;

// IMPROVED: Common fields moved to a base class
public class WithdrawTransaction extends Transaction {
    public WithdrawTransaction(BigDecimal amount, Account account) {
        super(amount, account);
    }

    @Override
    public void execute() {
        this.account.debit(amount);
        System.out.println("Withdraw transaction executed.");
    }
}