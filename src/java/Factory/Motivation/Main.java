import mp.Account;
import mp.Broker;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Account buyer1 = new Account(1, new BigDecimal(5000));
        Account buyer2 = new Account(1, new BigDecimal(3000));
        Account seller1 = new Account(2, new BigDecimal(2673.10));
        Broker b = new Broker(1);
        b.transact("BUY", new BigDecimal(100), buyer1, new BigDecimal(10), null);
        b.transact("SELL", new BigDecimal(100), seller1, new BigDecimal(20), null);
        b.transact("DEPOSIT", new BigDecimal(200), buyer2, null, null);
        b.transact("WITHDRAW", new BigDecimal(30), buyer2, null, null);
        b.transact("TRANSFER", new BigDecimal(50), buyer2, null, buyer1);
    }
}