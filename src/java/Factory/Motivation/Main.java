// All classes as inner classes. Demonstration only
import java.math.BigDecimal;

// This file demonstrates financial transactions using a broker
public class Main {

    // Represent financial accounts
    private class Account {
        private int id;
        private BigDecimal balance;
        private Account(int acc) {
            this.id = acc;
            this.balance = BigDecimal.ZERO;
        }

        private Account(int acc, BigDecimal balance) {
            this.id = acc;
            this.balance = balance;
        }

        private void debit(BigDecimal amount) {
            if (this.balance.compareTo(amount) >= 0) {
                this.balance = this.balance.subtract(amount);
            } else {
                System.out.println("Insufficient funds");
            }
        }

        private void credit(BigDecimal amount) {
            this.balance = this.balance.add(amount);
        }
    }

    // The different types of transactions

    // This common base class is needed to allow the Broker to handle all transactions
    private class Transaction {
    }

    // IMPROVEMENT: Common fields and methods for these transactions can be
    // moved to the parent
    private class BuyTransaction extends Transaction {
        private BigDecimal amount;
        private BigDecimal commission;
        private Account account;
        private BuyTransaction() {
        }
        private void execute() {
            System.out.println("Buy transaction executed.");
        }
    }

    private class SellTransaction extends Transaction {
        private BigDecimal amount;
        private BigDecimal commission;
        private Account account;
        private SellTransaction() {
        }
        private void execute() {
            System.out.println("Sell transaction executed.");
        }
    }

    private class DepositTransaction extends Transaction {
        private BigDecimal amount;
        private Account account;
        private DepositTransaction() {
        }
        private void execute() {
            System.out.println("Deposit transaction executed.");
        }
    }

    private class WithdrawTransaction extends Transaction {
        private BigDecimal amount;
        private Account account;
        private WithdrawTransaction() {
        }
        private void execute() {
            System.out.println("Withdraw transaction executed.");
        }
    }

    private class TransferTransaction extends Transaction {
        private BigDecimal amount;
        private Account account;
        private Account toAccount;
        private TransferTransaction() {
        }
        private void execute() {
            System.out.println("Transfer transaction executed.");
        }
    }

    // The broker that handles transactions
    private class Broker {
        private int branch_id;

        private Broker(int branch_id) {
            this.branch_id = branch_id;
        }

        private int getBranchId() { return this.branch_id; }
        private void setBranchId(int branch_id) { this.branch_id = branch_id; }

        // A method to execute a transaction
        private Transaction transact(String type) {
            Transaction t = null;
            // IMPROVEMENT: If a new transaction type is added, this will have
            // to be modified. This if statement of types could potentitally be
            // dispersed throughout the codebase. This violates the open-closed
            // principle.
            if (type.equals("BUY")) {
                BuyTransaction transaction = new BuyTransaction();
                transaction.execute();
                t = transaction;
            } else if (type.equals("SELL")) {
                SellTransaction transaction = new SellTransaction();
                transaction.execute();
                t = transaction;
            } else if (type.equals("DEPOSIT")) {
                DepositTransaction transaction = new DepositTransaction();
                transaction.execute();
                t = transaction;
            } else if (type.equals("WITHDRAW")) {
                WithdrawTransaction transaction = new WithdrawTransaction();
                transaction.execute();
                t = transaction;
            } else if (type.equals("TRANSFER")) {
                TransferTransaction transaction = new TransferTransaction();
                transaction.execute();
                t = transaction;
            } else {
                Transaction transaction = null;
                throw new IllegalArgumentException("Invalid transaction type");
            }
            return t;
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        Account buyer1 = m.new Account(1, new BigDecimal(5000));
        Account seller1 = m.new Account(2, new BigDecimal(2673.10));
        Broker b = m.new Broker(1);
        b.transact("BUY");
        b.transact("SELL");
        b.transact("DEPOSIT");
        b.transact("WITHDRAW");
        b.transact("TRANSFER");
    }
}