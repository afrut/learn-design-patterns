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
    // IMPROVED: Instead of handling types and parameters, this now takes a Transaction object
    public Transaction transact(Transaction transaction) {
        transaction.execute();
        return transaction;
    }
}