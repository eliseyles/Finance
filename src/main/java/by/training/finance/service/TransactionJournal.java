package by.training.finance.service;

import by.training.finance.bean.Transaction;
import by.training.finance.exception.ServiceException;

import java.math.BigDecimal;

public interface TransactionJournal {

    boolean addTransaction(Transaction transaction) throws ServiceException;

    void updateTransactionById(int id, Transaction transaction) throws ServiceException;

    Transaction getById(int id) throws ServiceException;

    Transaction[] getAllTransactions() throws ServiceException;

    BigDecimal getCurrentBalance() throws ServiceException;

    void deleteById(int id) throws ServiceException;

}
