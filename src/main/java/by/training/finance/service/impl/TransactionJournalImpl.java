package by.training.finance.service.impl;

import by.training.finance.bean.IncomeType;
import by.training.finance.bean.Transaction;
import by.training.finance.dao.TransactionDAO;
import by.training.finance.exception.DAOException;
import by.training.finance.factory.DAOFactory;
import by.training.finance.service.TransactionJournal;
import by.training.finance.exception.ServiceException;
import by.training.finance.validation.TransactionValidator;

import java.math.BigDecimal;

public class TransactionJournalImpl implements TransactionJournal {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private TransactionDAO transactionDAO = daoFactory.getTransactionDAO();

    @Override
    public boolean addTransaction(Transaction transaction) throws ServiceException {
        TransactionValidator.validateTransaction(transaction);

        try {
            transactionDAO.add(transaction);
        } catch (DAOException ex) {
            throw new ServiceException("Addition has been interrupted", ex);
        }
        return true;
        //todo
    }

    @Override
    public void updateTransactionById(int id, Transaction transaction) throws ServiceException {
        TransactionValidator.validateTransaction(transaction);
        try {
            transactionDAO.update(id, transaction);
        } catch (DAOException ex) {
            throw new ServiceException("Updating has been interrupted", ex);
        }
    }

    @Override
    public Transaction getById(int id) throws ServiceException {
        TransactionValidator.validateId(id);
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
            TransactionValidator.validateTransaction(transactions[i]);
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
        TransactionValidator.validateId(id);
        try {
            transactionDAO.delete(id);
        } catch (DAOException ex) {
            throw new ServiceException("Deletion has been interrupted", ex);
        }
    }
}
