package ua.training.lab.dmytro_dein.controller;

import ua.training.lab.dmytro_dein.model.Beverages;
import ua.training.lab.dmytro_dein.model.Sale;
import ua.training.lab.dmytro_dein.view.View;

import java.io.InputStream;
import java.util.Scanner;

public class UserInteractionHandler {
    //Constants
    private static final InputStream INPUT_STREAM = System.in;
    private static final Scanner INPUT_READER = new Scanner(INPUT_STREAM);
    private final View view;

    public UserInteractionHandler(View view) {
        this.view = view;
    }

    public void processUser() {
        Beverages userChoose;
        Sale sale;

        while ((userChoose = readUserBeverageSelectionWithScanner(view.MAIN_MENU, view.WRONG_INPUT_INT_DATA))
                != Beverages.EXIT) {
            switch (userChoose) {
                case TEA:
                case COFFEE:
                case JUICE:
                    sale = new Sale(userChoose, this, view);
                    collectPayments(userChoose, sale);
                    sale.giveUsersBeverage();
                    sale.giveShortChange();
                    break;
                default:
                    System.out.println("Selected item: " + userChoose);
            }
        }

    }

    void collectPayments(Beverages userChoose, Sale sale) {
        do {
            sale.makePayment();
            if (!sale.isEnoughMoneyForOrderSell()) {
                view.printMessageAndString(View.NOT_ENOUGH_MONEY, userChoose.toString());
            }
        } while (!sale.isEnoughMoneyForOrderSell());
    }

    public Beverages readUserBeverageSelectionWithScanner(String askMessage, String wrongMessage) {
        int enteredValue = getIntValueWithScanner(askMessage, wrongMessage);
        return Beverages.mapFromInt(enteredValue);
    }

    public int getUsersCoinsWithScanner(String askMessage, String wrongMessage) {
        return getIntValueWithScanner(askMessage, wrongMessage);
    }

    int getIntValueWithScanner(String askMessage, String wrongMessage) {
        int enteredValue;
        do {
            view.printMessage(askMessage);
            while (!INPUT_READER.hasNextInt()) {
                view.printMessage(wrongMessage);
                view.printMessage(askMessage);
                INPUT_READER.next();
            }
        } while ((enteredValue = INPUT_READER.nextInt()) < 0);
        return enteredValue;
    }
}