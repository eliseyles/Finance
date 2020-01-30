package by.training.finance.controller.command.impl;

import by.training.finance.bean.ExpenseTransaction;
import by.training.finance.bean.ExpenseType;
import by.training.finance.controller.command.Command;
import by.training.finance.controller.responcevalue.StringProperty;
import by.training.finance.exception.ServiceException;
import by.training.finance.factory.ServiceFactory;
import by.training.finance.service.impl.TransactionJournalImpl;

import java.math.BigDecimal;

public class EditExpense implements Command {

    @Override
    public String execute(String request) {
        String response;
        String[] requestData = request.split(delimiter);

        ExpenseTransaction expenseTransaction;
        int id;
        if (requestData.length > 1) {
            id = Integer.parseInt(requestData[0]);
            BigDecimal amount = new BigDecimal(Double.parseDouble(requestData[1]));
            ExpenseType type = ExpenseType.valueOf(requestData[2].toUpperCase());
            String title;
            if (requestData.length < 3) {
                title = "";
            } else {
                title = requestData[3];
            }
            expenseTransaction = new ExpenseTransaction(title, amount, type);
        } else {
            response = StringProperty.getStringValue("wrongRequestResponse");
            return response;
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TransactionJournalImpl transactionLog = serviceFactory.getTransactionLog();

        try {
            transactionLog.updateTransactionById(id, expenseTransaction);
            response = StringProperty.getStringValue("expenseEdited");
        } catch (ServiceException e) {
            response = StringProperty.getStringValue("failedToEditExpense") + e.getMessage();
        }
        return response;
    }
}
