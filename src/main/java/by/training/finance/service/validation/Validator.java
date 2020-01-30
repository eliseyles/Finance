package by.training.finance.service.validation;

import by.training.finance.bean.Transaction;
import by.training.finance.exception.ServiceException;

import java.math.BigDecimal;
import java.util.Date;

public class Validator {

    private static final double EPS = 0.0001;

    public static void validateTransaction(Transaction transaction) throws ServiceException {
        checkNull(transaction);
        validateId(transaction.getId());
        validateAmount(transaction.getAmount());
        validateDate(transaction.getDate());
        validateTitle(transaction.getTitle());
        validateType(transaction.getType());
    }

    private static void checkNull(Transaction transaction) throws ServiceException {
        if (transaction == null) {
            throw new ServiceException("Transaction is null");
        }
    }

    private static void validateAmount(BigDecimal amount) throws ServiceException {
        if (amount.doubleValue() - 0 < EPS) {
            throw new ServiceException("Invalid transaction amount");
        }
    }

    private static void validateDate(Date date) throws ServiceException {
        if (date.after(new Date())) {
            throw new ServiceException("Invalid transaction date");
        }
    }

    private static void validateTitle(String title) throws ServiceException {
        if (title == null) {
            throw new ServiceException("Invalid transaction title");
        }
    }

    private static void validateType(Enum<?> type) throws ServiceException {
        if (type == null) {
            throw new ServiceException("Transaction type is null");
        }
    }

    public static void validateId(int id) throws ServiceException {
        if (id < 0) {
            throw new ServiceException("Transaction id is invalid");
        }
    }
}
