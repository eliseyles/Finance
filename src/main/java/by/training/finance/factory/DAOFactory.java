package by.training.finance.factory;

import by.training.finance.dao.TransactionDAO;
import by.training.finance.dao.impl.FileTransactionDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final TransactionDAO fileTransactionImpl = new FileTransactionDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public TransactionDAO getTransactionDAO() {
        return fileTransactionImpl;
    }
}
