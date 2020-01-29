package by.training.finance.controller.command;

public enum CommandName {

    ADD_EXPENSE, EDIT_EXPENSE, DELETE_EXPENSE,
    ADD_INCOME, EDIT_INCOME, DELETE_INCOME,

    GET_TRANSACTIONS_HISTORY, GET_CURRENT_BALANCE,

    GET_TRANSACTION_BY_ID, WRONG_REQUEST
}