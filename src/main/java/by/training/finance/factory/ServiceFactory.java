package by.training.finance.factory;

import by.training.finance.service.impl.TransactionJournalImpl;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final TransactionJournalImpl transactionLog = new TransactionJournalImpl();

    private ServiceFactory() {

    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public TransactionJournalImpl getTransactionLog() {
        return transactionLog;
    }
}

