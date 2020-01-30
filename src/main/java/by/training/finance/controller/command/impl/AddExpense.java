package by.training.finance.controller.command.impl;

import by.training.finance.bean.ExpenseTransaction;
import by.training.finance.bean.ExpenseType;
import by.training.finance.controller.command.Command;
import by.training.finance.controller.responcevalue.StringProperty;
import by.training.finance.exception.ServiceException;
import by.training.finance.factory.ServiceFactory;
import by.training.finance.service.impl.TransactionLogImpl;

import java.math.BigDecimal;

public class AddExpense implements Command {

    @Override
    public String execute(String request) {
        String response;
        String[] requestData = request.split(delimiter);

        ExpenseTransaction expenseTransaction;
        if (requestData.length > 1) {
            BigDecimal amount = new BigDecimal(Double.parseDouble(requestData[0]));
            ExpenseType type = ExpenseType.valueOf(requestData[1].toUpperCase());
            String title;
            if (requestData.length < 2) {
                title = "";
            } else {
                title = requestData[2];
            }
            expenseTransaction = new ExpenseTransaction(title, amount, type);
        } else {
            response = StringProperty.getStringValue("wrongRequestResponse");
            return response;
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TransactionLogImpl transactionLog = serviceFactory.getTransactionLog();

        try {
            transactionLog.addTransaction(expenseTransaction);
            response = StringProperty.getStringValue("expenseAdded");
        } catch (ServiceException e) {
            response = StringProperty.getStringValue("failedToAddExpense") + e.getMessage();
        }
        return response;
    }
}
