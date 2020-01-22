package by.training.finance.controller;

import by.training.finance.controller.command.Command;

public class Controller {
    private final CommandProvider provider = new CommandProvider();

    private final char delimiter = ' ';

    public String executeTask(String request) {
        String commandName;
        Command executionCommand;

        if (request.indexOf(delimiter) == -1) {
            commandName = request;
        } else {
            commandName = request.substring(0, request.indexOf(delimiter));
        }

        executionCommand = provider.getCommand(commandName);

        String response;
        response = executionCommand.execute(request.substring(request.indexOf(delimiter) + 1));
        return response;
    }
}
