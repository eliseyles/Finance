package by.training.finance.controller.command.impl;

import by.training.finance.controller.command.Command;
import by.training.finance.controller.responcevalue.StringProperty;
import by.training.finance.exception.ServiceException;
import by.training.finance.service.factory.ServiceFactory;
import by.training.finance.service.impl.TransactionLogImpl;

public class DeleteIncome implements Command {

    @Override
    public String execute(String request) {
        String response;
        String[] requestData = request.split(delimiter);

        int id;
        if (requestData.length > 0) {
            id = Integer.parseInt(requestData[0]);
        } else {
            response = StringProperty.getStringValue("wrongRequestResponse");
            return response;
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TransactionLogImpl transactionLog = serviceFactory.getTransactionLog();

        try {
            transactionLog.deleteById(id);
            response = StringProperty.getStringValue("incomeDeleted");
        } catch (ServiceException e) {
            response = StringProperty.getStringValue("failedToDeleteIncome") + e.getMessage();
        }
        return response;
    }
}
