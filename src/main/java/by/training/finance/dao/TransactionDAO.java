package by.training.finance.dao;


import by.training.finance.bean.Transaction;
import by.training.finance.exception.DAOException;

public interface TransactionDAO {

    void add(Transaction transaction) throws DAOException;

    void update(long id, Transaction transaction) throws DAOException;

    Transaction get(long id) throws DAOException;

    Transaction[] getAll() throws DAOException;

    void delete(int id) throws DAOException;

}
