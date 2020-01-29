package by.training.finance.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public abstract class Transaction implements Serializable {
    protected int id;
    protected BigDecimal amount;
    protected Date date;
    protected String title;
    protected Enum<?> type;

    protected static int transactionCount;

    protected static final BigDecimal DEFAULT_AMOUNT = new BigDecimal(0);
    protected static final String DEFAULT_TITLE = "";

    public Transaction() {
    }

    protected int createGlobalId(int id) {
        if (id > transactionCount) {
            transactionCount = id;
            return id;
        }
        return id;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Enum<?> getType() {
        return type;
    }

    public void setType(Enum<?> type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", type=" + type +
                '}';
    }


}
