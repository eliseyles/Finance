package by.training.finance.controller.command.impl;

import by.training.finance.bean.IncomeTransaction;
import by.training.finance.bean.IncomeType;
import by.training.finance.controller.command.Command;
import by.training.finance.controller.responcevalue.StringProperty;
import by.training.finance.exception.ServiceException;
import by.training.finance.factory.ServiceFactory;
import by.training.finance.service.impl.TransactionJournalImpl;

import java.math.BigDecimal;

public class AddIncome implements Command {

    @Override
    public String execute(String request) {
        String response;
        String[] requestData = request.split(delimiter);

        IncomeTransaction incomeTransaction;
        if (requestData.length > 1) {
            BigDecimal amount = new BigDecimal(Double.parseDouble(requestData[0]));
            IncomeType type = IncomeType.valueOf(requestData[1].toUpperCase());
            String title;
            if (requestData.length < 2) {
                title = "";
            } else {
                title = requestData[2];
            }
            incomeTransaction = new IncomeTransaction(title, amount, type);
        } else {
            response = StringProperty.getStringValue("wrongRequestResponse");
            return response;
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TransactionJournalImpl transactionLog = serviceFactory.getTransactionLog();

        try {
            transactionLog.addTransaction(incomeTransaction);
            response = StringProperty.getStringValue("incomeAdded");
        } catch (ServiceException e) {
            response = StringProperty.getStringValue("failedToAddIncome") + e.getMessage();
        }
        return response;
    }
}

