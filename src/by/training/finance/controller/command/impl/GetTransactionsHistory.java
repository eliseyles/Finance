package by.training.finance.controller.command.impl;

import by.training.finance.bean.ExpenseTransaction;
import by.training.finance.bean.ExpenseType;
import by.training.finance.controller.command.Command;
import by.training.finance.controller.responcevalue.StringProperty;
import by.training.finance.service.exception.ServiceException;
import by.training.finance.service.factory.ServiceFactory;
import by.training.finance.service.impl.TransactionLogImpl;

import java.math.BigDecimal;
import java.util.Arrays;

public class GetTransactionsHistory implements Command {
    @Override
    public String execute(String request) {
        String response;
        String[] requestData = request.split(delimiter);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TransactionLogImpl transactionLog = serviceFactory.getTransactionLog();

        try {
            response = Arrays.toString(transactionLog.getAllTransactions());
        } catch (ServiceException e) {
            response = StringProperty.getStringValue("failedToAddExpense") + e.getMessage();
        }
        return response;
    }
}
