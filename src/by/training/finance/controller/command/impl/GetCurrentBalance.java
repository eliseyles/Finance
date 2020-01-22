package by.training.finance.controller.command.impl;

import by.training.finance.controller.command.Command;
import by.training.finance.controller.responcevalue.StringProperty;
import by.training.finance.service.exception.ServiceException;
import by.training.finance.service.factory.ServiceFactory;
import by.training.finance.service.impl.TransactionLogImpl;

import java.util.Arrays;

public class GetCurrentBalance implements Command {

    @Override
    public String execute(String request) {
        String response;
        String[] requestData = request.split(delimiter);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TransactionLogImpl transactionLog = serviceFactory.getTransactionLog();

        try {
            response = transactionLog.getCurrentBalance().toString();
        } catch (ServiceException e) {
            response = StringProperty.getStringValue("failedToGetCurrentBalance") + e.getMessage();
        }
        return response;
    }
}
