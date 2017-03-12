package ua.training.lab.dmytro_dein.controller;

import ua.training.lab.dmytro_dein.model.Beverages;
import ua.training.lab.dmytro_dein.model.Sale;
import ua.training.lab.dmytro_dein.view.View;
import java.io.InputStream;
import java.util.Scanner;


public class Controller {

    //Constants
    private InputStream INPUT_STREAM = System.in;
    private Scanner INPUT_READER = new Scanner(INPUT_STREAM);

    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void processUser(){
        Beverages userChoose;
        Sale sale;

        while ((userChoose = readUserBeverageSelectionWithScanner(view.MAIN_MENU, view.WRONG_INPUT_INT_DATA))
                != Beverages.EXIT) {
            switch (userChoose) {
                case TEA:
                case COFFEE:
                case JUICE:
                    System.out.println("Selected item: " + userChoose);
                    sale = new Sale(userChoose, this, view);
                    while (!sale.isEnoughMoneyForOrderSell() || !sale.isOrderCanceled()) {
                        sale.makePayment();
                        if (!sale.isEnoughMoneyForOrderSell()) {
                            view.printMessageAndString(View.NOT_ENOUGH_MONEY, userChoose.toString());
                        }
                    }
                    sale.giveUsersBeverage();

                    /*sale.makePayment();
                    if(sale.isEnoughMoneyForOrderSell()){
                        sale.giveUsersBeverage();
                    } else {
                        view.printMessageAndString(View.NOT_ENOUGH_MONEY, userChoose.toString());
                        sale.makePayment();
                    }*/

                    break;
                default:
                    System.out.println("Selected item: " + userChoose);
            }
        }

    }

    public Beverages readUserBeverageSelectionWithScanner(String askMessage, String wrongMessage) {
        int enteredValue = getIntValueWithScanner(askMessage, wrongMessage);
        return Beverages.mapFromInt(enteredValue);
    }

    public int getUsersCoinsWithScanner(String askMessage, String wrongMessage) {
        return getIntValueWithScanner(askMessage, wrongMessage);
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
