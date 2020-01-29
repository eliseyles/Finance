package by.training.finance.bean;

import java.math.BigDecimal;
import java.util.Date;

public class ExpenseTransaction extends Transaction {

    private static final ExpenseType DEFAULT_TYPE = ExpenseType.FOOD;

    public ExpenseTransaction() {
        this.id = ++transactionCount;
        this.title = DEFAULT_TITLE;
        this.date = new Date();
        this.amount = DEFAULT_AMOUNT;
        this.type = DEFAULT_TYPE;
    }

    public ExpenseTransaction(String title, BigDecimal amount, ExpenseType type) {
        this.id = ++transactionCount;
        this.title = title;
        this.amount = amount;
        this.type = type;
        this.date = new Date();
    }

    public ExpenseTransaction(String title, Date date, BigDecimal amount, ExpenseType type) {
        this(title, amount, type);
        this.date = date;
    }

    public ExpenseTransaction(int id, String title, Date date, BigDecimal amount, ExpenseType type) {
        this.id = createGlobalId(id);
        this.title = title;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id &&
                this.amount.equals(that.amount) &&
                this.date.equals(that.date) &&
                this.title.equals(that.title) &&
                this.type.equals(that.type);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = 1;
        hash = prime * hash + id;
        hash = prime * hash + amount.hashCode();
        hash = prime * hash + date.hashCode();
        hash = prime * hash + title.hashCode();
        hash = prime * hash + type.hashCode();

        return hash;
    }

    @Override
    public String toString() {
        return "ExpenseTransaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", type=" + type +
                '}';
    }
}
