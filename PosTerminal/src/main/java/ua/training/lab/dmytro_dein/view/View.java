package ua.training.lab.dmytro_dein.view;

public class View {

    public static final String MAIN_MENU = "\n============== PoS Terminal Main MENU ===============\n" +
            "Please choose your beverage:\n\n" +
            "1. Tea (25 coins)\n" +
            "2. Coffee (35 coins)\n" +
            "3. Juice (45 coins)\n" +
            "-----------------------------\n" +
            "0. Exit\n\n" +
            "Your choose: ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please!\n";
    public static final String BALANCE = "\nYour balance is: %d%n";
    public static final String COINS_MENU = "Please insert coins of par values '1', '5', '10', '25', '50'\n" +
            "Special value '0' for completing balance replenishment\n" +
            "Special value '999' for order cancellation\n" +
            "Inserting coin: ";
    public static final String WRONG_COIN = "Incorrect coin par value. Try again!\n";
    public static final String CANCEL_ORDER_AND_TAKE_BALANCE_REPLENISHMENT = "Order cancelled. Take your balance of: %d%n";
    public static final String TAKE_BEVERAGE = "Please take your beverage: %s%n";
    public static final String ACCUMULATED_BALANCE = "Accumulated balance is %d%n";
    public static final String NOT_ENOUGH_MONEY = "There is not enough money for selected position %s." +
            "\nPlease refill your balance or cancel the order.";

    public void printMessage(String message){
        System.out.print(message);
    }

    public void printMessageAndInt(String message, int value){
        System.out.format(message, value);
    }

    public void printMessageAndString(String message, String value) {
        System.out.format(message, value);
    }
}
