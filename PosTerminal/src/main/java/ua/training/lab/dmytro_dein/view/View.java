package ua.training.lab.dmytro_dein.view;


public interface View {
    String MAIN_MENU = "\n============== PoS Terminal Main MENU ===============\n" +
            "Please choose your beverage:\n\n" +
            "1. Tea (25 coins)\n" +
            "2. Coffee (35 coins)\n" +
            "3. Juice (45 coins)\n" +
            "-----------------------------\n" +
            "0. Exit\n\n" +
            "Your choose: ";
    String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please!\n";
    String BALANCE = "Your balance is: %d%n";
    String COINS_MENU = "Please insert coins of par values '1', '5', '10', '25', '50'\n" +
                    "Special value '0' for completing balance replenishment\n" +
                    "Special value '999' for order cancellation\n" +
                    "Inserting coin: ";
    String WRONG_COIN = "Incorrect coin par value. Try again!\n";
    String CANCEL_ORDER_AND_TAKE_BALANCE_REPLENISHMENT = "Order cancelled. Take your balance of: %d%n";
    String TAKE_BEVERAGE = "Please take your beverage: %s%n";
    String ACCUMULATED_BALANCE = "--\nAccumulated balance is %d coin(s).%n";
    String NOT_ENOUGH_MONEY = "There is not enough money for selected position %s." +
                            "\nPlease refill your balance or cancel the order.\n";
    String TAKE_SHORT_CHANGE = "Please take short change: %d coin(s)%n";
    String SELECTED_ITEM = "\nSelected item: %s coin(s).%n";

    void printMessage(String message);

    void printMessageAndInt(String message, int value);

    void printMessageAndString(String message, String value);
}
