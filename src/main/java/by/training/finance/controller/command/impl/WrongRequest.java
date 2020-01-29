package by.training.finance.controller.command.impl;

import by.training.finance.controller.command.Command;
import by.training.finance.controller.responcevalue.StringProperty;

public class WrongRequest implements Command {
    @Override
    public String execute(String request) {
        return StringProperty.getStringValue("wrongRequestResponse");
    }
}
