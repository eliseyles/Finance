package by.training.finance.controller;

public interface Command {

    String delimiter = " ";
    public String execute(String request);
}
