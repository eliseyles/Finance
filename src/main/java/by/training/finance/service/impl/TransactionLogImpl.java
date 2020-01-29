package by.training.finance.service.impl;

import by.training.finance.bean.IncomeType;
import by.training.finance.bean.Transaction;
import by.training.finance.dao.TransactionDAO;
import by.training.finance.dao.exception.DAOException;
import by.training.finance.dao.factory.DAOFactory;
import by.training.finance.service.TransactionLog;
import by.training.finance.service.exception.ServiceException;
import by.training.finance.service.validation.Validator;

import java.math.BigDecimal;

public class TransactionLogImpl implements TransactionLog {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private TransactionDAO transactionDAO = daoFactory.getTransactionDAO();

    @Override
    public boolean addTransaction(Transaction transaction) throws ServiceException {
        Validator.validateTransaction(transaction);

        try {
            transactionDAO.add(transaction);
        } catch (DAOException ex) {
            throw new ServiceException("Addition has been interrupted", ex);
        }
        return true;
    }

    @Override
    public void updateTransaction(int id, Transaction transaction) throws ServiceException {
        Validator.validateTransaction(transaction);
        try {
            transactionDAO.update(id, transaction);
        } catch (DAOException ex) {
            throw new ServiceException("Updating has been interrupted", ex);
        }
    }

    @Override
    public Transaction getById(int id) throws ServiceException {
        Validator.validateId(id);
        try {
            return transactionDAO.get(id);
        } catch (DAOException ex) {
            throw new ServiceException("Getting has been interrupted", ex);
        }
    }

    @Override
    public Transaction[] getAllTransactions() throws ServiceException {
        try {
            return transactionDAO.getAll();
        } catch (DAOException ex) {
            throw new ServiceException("Getting has been interrupted", ex);
        }
    }

    @Override
    public BigDecimal getCurrentBalance() throws ServiceException {
        Transaction[] transactions;
        try {
            transactions = transactionDAO.getAll();
        } catch (DAOException ex) {
            throw new ServiceException("Getting balance has been interrupted", ex);
        }
        BigDecimal balance = new BigDecimal(0);
        for (int i = 0; i < transactions.length; i++) {
            Validator.validateTransaction(transactions[i]);
            if (transactions[i].getType().getClass() == IncomeType.class) {
                balance = balance.add(transactions[i].getAmount());
            } else {
                balance = balance.add(transactions[i].getAmount().negate());
            }
        }
        return balance;
    }

    @Override
    public void deleteById(int id) throws ServiceException {
        Validator.validateId(id);
        try {
            transactionDAO.delete(id);
        } catch (DAOException ex) {
            throw new ServiceException("Deletion has been interrupted", ex);
        }
    }
}
