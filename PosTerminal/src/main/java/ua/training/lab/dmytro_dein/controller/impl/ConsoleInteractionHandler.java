package ua.training.lab.dmytro_dein.controller.impl;

import ua.training.lab.dmytro_dein.controller.InteractionHandling;
import ua.training.lab.dmytro_dein.model.Beverages;
import ua.training.lab.dmytro_dein.model.Sale;
import ua.training.lab.dmytro_dein.model.impl.SaleImpl;
import ua.training.lab.dmytro_dein.view.View;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleInteractionHandler implements InteractionHandling {
    //Constants
    private static final InputStream INPUT_STREAM = System.in;
    private static final Scanner INPUT_READER = new Scanner(INPUT_STREAM);
    private final View view;

    public ConsoleInteractionHandler(View view) {
        this.view = view;
    }

    @Override
    public void startInteraction() {
        Beverages userChoose;
        Sale sale;

        while ((userChoose = readUserBeverageSelectionWithScanner(view.MAIN_MENU, view.WRONG_INPUT_INT_DATA))
                != Beverages.EXIT) {
            switch (userChoose) {
                case TEA:
                case COFFEE:
                case JUICE:
                    sale = new SaleImpl(userChoose, this, view);
                    sale.collectPayments(userChoose);
                    sale.giveUsersBeverage();
                    sale.giveShortChange();
                    break;
                default:
                    System.out.println("Selected item: " + userChoose);
            }
        }
    }

    public int getUsersCoinsWithScanner(String askMessage, String wrongMessage) {
        return getIntValueWithScanner(askMessage, wrongMessage);
    }

    private Beverages readUserBeverageSelectionWithScanner(String askMessage, String wrongMessage) {
        int enteredValue = getIntValueWithScanner(askMessage, wrongMessage);
        return Beverages.mapFromInt(enteredValue);
    }

    private int getIntValueWithScanner(String askMessage, String wrongMessage) {
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