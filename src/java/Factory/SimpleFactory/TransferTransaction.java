package mp;
import java.math.BigDecimal;

// IMPROVED: Common fields moved to a base class
public class TransferTransaction extends Transaction {
    private Account toAccount;
    public TransferTransaction(BigDecimal amount, Account account, Account toAccount) {
        super(amount, account);
        this.toAccount = toAccount;
    }

    @Override
    public void execute() {
        this.account.debit(amount);
        this.toAccount.credit(amount);
        System.out.println("Transfer transaction executed.");
    }
}