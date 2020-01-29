package by.training.finance.view;

import by.training.finance.bean.ExpenseType;
import by.training.finance.bean.IncomeType;
import by.training.finance.controller.Controller;

public class Main {
    public static void main(String[] args) {
        String delimiter = " ";
        Controller controller = new Controller();

        System.out.println(controller.executeTask("get_transactions_history"));

//        String addExpenseResponse = controller.executeTask("add_expense" +
//                delimiter + 45.56 + delimiter + ExpenseType.ENTERTAINMENT + delimiter + "Cinema");
//
//        System.out.println(addExpenseResponse);
//
//        String addExpenseResponse1 = controller.executeTask("add_expense" +
//                delimiter + 666 + delimiter + ExpenseType.FOOD + delimiter + "eda");
//
//        System.out.println(addExpenseResponse1);

//        String editExpenseResponse = controller.executeTask("edit_expense" + delimiter + 1 +
//                delimiter + 50.0 + delimiter + ExpenseType.ENTERTAINMENT + delimiter + "Cinema");
//
//        System.out.println(editExpenseResponse);

//        String deleteExpenseResponse = controller.executeTask("delete_expense" + delimiter + 2);

//        System.out.println(deleteExpenseResponse);
//        String addIncomeResponse = controller.executeTask("add_income" +
//                delimiter + 45.56 + delimiter + IncomeType.SALARY + delimiter + "From May");
//
//        System.out.println(addIncomeResponse);

//        String editIncomeResponse = controller.executeTask("edit_income" + delimiter + 1 +
//                delimiter + 500 + delimiter + IncomeType.SALARY + delimiter + "May");
//
//        System.out.println(editIncomeResponse);

        String balanceResponse = controller.executeTask("get_current_balance");

        System.out.println(balanceResponse);

    }
}
