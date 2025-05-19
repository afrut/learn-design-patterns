package mp;

import java.util.Map;
import java.math.BigDecimal;

// IMPROVED: All creation logic is now in the factory
public class TransactionFactory {

    // IMPROVED: The monolithic create function is now split based on arguments
    // and type
    public static Transaction createTransaction(
        String type,
        BigDecimal amount,
        Account account,
        BigDecimal commission) {
        Transaction ret = null;
        if (type.equals("BUY")) {
            ret = new BuyTransaction(amount, account, commission);
        } else if (type.equals("SELL")) {
            ret = new SellTransaction(amount, account, commission);
        } else {
            System.out.println("Invalid transaction type for parameters: " + type);
        }
        return ret;
    }

    public static Transaction createTransaction(
        String type,
        BigDecimal amount,
        Account account) {
        Transaction ret = null;
        if (type.equals("DEPOSIT")) {
            ret = new DepositTransaction(amount, account);
        } else if (type.equals("WITHDRAW")) {
            ret = new WithdrawTransaction(amount, account);
        } else {
            System.out.println("Invalid transaction type for parameters: " + type);
        }
        return ret;
    }

    public static Transaction createTransaction(
        String type,
        BigDecimal amount,
        Account account,
        Account toAccount) {
        Transaction ret = null;
        if (type.equals("TRANSFER")) {
            ret = new TransferTransaction(amount, account, toAccount);
        } else {
            System.out.println("Invalid transaction type for parameters: " + type);
        }
        return ret;
    }

}