import mp.Account;
import mp.Broker;
import mp.TransactionFactory;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Account buyer1 = new Account(1, new BigDecimal(5000));
        Account buyer2 = new Account(1, new BigDecimal(3000));
        Account seller1 = new Account(2, new BigDecimal(2673.10));
        Broker b = new Broker(1);

        // IMPROVED: Function signature is improved and factory is used
        b.transact(TransactionFactory.createTransaction("BUY", new BigDecimal(100), buyer1, new BigDecimal(10)));
        b.transact(TransactionFactory.createTransaction("SELL", new BigDecimal(100), seller1, new BigDecimal(20)));
        b.transact(TransactionFactory.createTransaction("DEPOSIT", new BigDecimal(200), buyer2));
        b.transact(TransactionFactory.createTransaction("WITHDRAW", new BigDecimal(30), buyer2));
        b.transact(TransactionFactory.createTransaction("TRANSFER", new BigDecimal(50), buyer2, buyer1));
    }
}