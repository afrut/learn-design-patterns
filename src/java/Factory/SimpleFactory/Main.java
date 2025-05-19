import mp.Account;
import mp.Broker;
import mp.BuyTransaction;
import mp.DepositTransaction;
import mp.SellTransaction;
import mp.TransferTransaction;
import mp.WithdrawTransaction;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Account buyer1 = new Account(1, new BigDecimal(5000));
        Account buyer2 = new Account(1, new BigDecimal(3000));
        Account seller1 = new Account(2, new BigDecimal(2673.10));
        Broker b = new Broker(1);

        // IMPROVED: Instead of specifying a type and parameters, an explicit
        // type is now specified
        b.transact(new BuyTransaction(new BigDecimal(100), buyer1, new BigDecimal(10)));
        b.transact(new SellTransaction(new BigDecimal(100), seller1, new BigDecimal(20)));
        b.transact(new DepositTransaction(new BigDecimal(200), buyer2));
        b.transact(new WithdrawTransaction(new BigDecimal(30), buyer2));
        b.transact(new TransferTransaction(new BigDecimal(50), buyer2, buyer1));
    }
}