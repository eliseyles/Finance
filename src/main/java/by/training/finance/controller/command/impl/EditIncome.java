package by.training.finance.controller.command.impl;

import by.training.finance.bean.IncomeTransaction;
import by.training.finance.bean.IncomeType;
import by.training.finance.controller.command.Command;
import by.training.finance.controller.responcevalue.StringProperty;
import by.training.finance.exception.ServiceException;
import by.training.finance.factory.ServiceFactory;
import by.training.finance.service.impl.TransactionLogImpl;

import java.math.BigDecimal;

public class EditIncome implements Command {
    @Override
    public String execute(String request) {
        String response;
        String[] requestData = request.split(delimiter);

        IncomeTransaction incomeTransaction;
        int id;
        if (requestData.length > 1) {
            id = Integer.parseInt(requestData[0]);
            BigDecimal amount = new BigDecimal(Double.parseDouble(requestData[1]));
            IncomeType type = IncomeType.valueOf(requestData[2].toUpperCase());
            String title;
            if (requestData.length < 3) {
                title = "";
            } else {
                title = requestData[3];
            }
            incomeTransaction = new IncomeTransaction(title, amount, type);
        } else {
            response = StringProperty.getStringValue("wrongRequestResponse");
            return response;
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TransactionLogImpl transactionLog = serviceFactory.getTransactionLog();

        try {
            transactionLog.addTransaction(incomeTransaction);
            response = StringProperty.getStringValue("incomeEdited");
        } catch (ServiceException e) {
            response = StringProperty.getStringValue("failedToEditIncome") + e.getMessage();
        }
        return response;
    }
}
