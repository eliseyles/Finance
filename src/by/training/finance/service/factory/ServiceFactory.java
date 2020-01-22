package by.training.finance.service.factory;

import by.training.finance.service.impl.TransactionLogImpl;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final TransactionLogImpl transactionLog = new TransactionLogImpl();

    private ServiceFactory() {

    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public TransactionLogImpl getTransactionLog() {
        return transactionLog;
    }
}

