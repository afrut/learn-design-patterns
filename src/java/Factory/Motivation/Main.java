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
        private Account account;
        private BigDecimal commission;
        private BuyTransaction(BigDecimal amount, Account account, BigDecimal commission) {
            this.amount = amount;;
            this.account = account;
            this.commission = commission;
        }
        private void execute() {
            this.account.debit(amount.add(commission));
            System.out.println("Buy transaction executed.");
        }
    }

    private class SellTransaction extends Transaction {
        private BigDecimal amount;
        private Account account;
        private BigDecimal commission;
        private SellTransaction(BigDecimal amount, Account account, BigDecimal commission) {
            this.amount = amount;;
            this.account = account;
            this.commission = commission;
        }
        private void execute() {
            this.account.credit(amount.subtract(commission));
            System.out.println("Sell transaction executed.");
        }
    }

    private class DepositTransaction extends Transaction {
        private BigDecimal amount;
        private Account account;
        private DepositTransaction(BigDecimal amount, Account account) {
            this.amount = amount;;
            this.account = account;
        }
        private void execute() {
            this.account.credit(amount);
            System.out.println("Deposit transaction executed.");
        }
    }

    private class WithdrawTransaction extends Transaction {
        private BigDecimal amount;
        private Account account;
        private WithdrawTransaction(BigDecimal amount, Account account) {
            this.amount = amount;;
            this.account = account;
        }
        private void execute() {
            this.account.debit(amount);
            System.out.println("Withdraw transaction executed.");
        }
    }

    private class TransferTransaction extends Transaction {
        private BigDecimal amount;
        private Account account;
        private Account toAccount;
        private TransferTransaction(BigDecimal amount, Account account, Account toAccount) {
            this.amount = amount;;
            this.account = account;
            this.toAccount = toAccount;
        }
        private void execute() {
            this.account.debit(amount);
            this.toAccount.credit(amount);
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
        // IMPROVEMENT: This method will have to take all the parameters to
        // instantiate any type of transaction
        private Transaction transact(String type, BigDecimal amount, Account account, BigDecimal commission, Account toAccount) {
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

    public static void main(String[] args) {
        Main m = new Main();
        Account buyer1 = m.new Account(1, new BigDecimal(5000));
        Account buyer2 = m.new Account(1, new BigDecimal(3000));
        Account seller1 = m.new Account(2, new BigDecimal(2673.10));
        Broker b = m.new Broker(1);
        b.transact("BUY", new BigDecimal(100), buyer1, new BigDecimal(10), null);
        b.transact("SELL", new BigDecimal(100), seller1, new BigDecimal(20), null);
        b.transact("DEPOSIT", new BigDecimal(200), buyer2, null, null);
        b.transact("WITHDRAW", new BigDecimal(30), buyer2, null, null);
        b.transact("TRANSFER", new BigDecimal(50), buyer2, null, buyer1);
    }
}