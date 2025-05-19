package mp;
import java.math.BigDecimal;

// IMPROVEMENT: Common fields and methods for these transactions can be
// moved to the parent

public class TransferTransaction extends Transaction {
    private BigDecimal amount;
    private Account account;
    private Account toAccount;
    public TransferTransaction(BigDecimal amount, Account account, Account toAccount) {
        this.amount = amount;;
        this.account = account;
        this.toAccount = toAccount;
    }
    public void execute() {
        this.account.debit(amount);
        this.toAccount.credit(amount);
        System.out.println("Transfer transaction executed.");
    }
}