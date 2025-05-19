package mp;
import java.math.BigDecimal;

 // The broker that handles transactions
public class Broker {
    private int branch_id;

    public Broker(int branch_id) {
        this.branch_id = branch_id;
    }

    private int getBranchId() { return this.branch_id; }
    private void setBranchId(int branch_id) { this.branch_id = branch_id; }

    // A method to execute a transaction
    // IMPROVEMENT: This method will have to take all the parameters to
    // instantiate any type of transaction
    public Transaction transact(String type, BigDecimal amount, Account account, BigDecimal commission, Account toAccount) {
        Transaction t = null;
        // IMPROVEMENT: If a new transaction type is added, this will have
        // to be modified. This if statement of types could potentitally be
        // dispersed throughout the codebase. This violates the open-closed
        // principle.
        if (type.equals("BUY")) {
            BuyTransaction transaction = new BuyTransaction(amount, account, commission);
            transaction.execute();
            t = transaction;
        } else if (type.equals("SELL")) {
            SellTransaction transaction = new SellTransaction(amount, account, commission);
            transaction.execute();
            t = transaction;
        } else if (type.equals("DEPOSIT")) {
            DepositTransaction transaction = new DepositTransaction(amount, account);
            transaction.execute();
            t = transaction;
        } else if (type.equals("WITHDRAW")) {
            WithdrawTransaction transaction = new WithdrawTransaction(amount, account);
            transaction.execute();
            t = transaction;
        } else if (type.equals("TRANSFER")) {
            TransferTransaction transaction = new TransferTransaction(amount, account, toAccount);
            transaction.execute();
            t = transaction;
        } else {
            Transaction transaction = null;
            throw new IllegalArgumentException("Invalid transaction type");
        }
        return t;
    }
}