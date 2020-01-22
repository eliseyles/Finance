package by.training.finance.bean;

import java.math.BigDecimal;
import java.util.Date;

public class IncomeTransaction extends Transaction {

    private static final ExpenseType DEFAULT_TYPE = ExpenseType.FOOD;

    public IncomeTransaction() {
        this.id = ++transactionCount;
        this.title = DEFAULT_TITLE;
        this.date = new Date();
        this.amount = DEFAULT_AMOUNT;
        this.type = DEFAULT_TYPE;
    }

    public IncomeTransaction(String title, BigDecimal amount, IncomeType type) {
        this.id = ++transactionCount;
        this.title = title;
        this.amount = amount;
        this.type = type;
        this.date = new Date();
    }

    public IncomeTransaction(String title, Date date,BigDecimal amount, IncomeType type) {
        this(title, amount, type);
        this.date = date;
    }

    public IncomeTransaction(int id, String title, Date date,BigDecimal amount, IncomeType type) {
        this.id = createGlobalId(id);
        this.title = title;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    @Override
    public String toString() {
        return "IncomeTransaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", type=" + type +
                '}';
    }
}
