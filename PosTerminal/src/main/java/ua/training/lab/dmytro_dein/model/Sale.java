package ua.training.lab.dmytro_dein.model;


import ua.training.lab.dmytro_dein.controller.Controller;
import ua.training.lab.dmytro_dein.view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sale {
    private static final int END_BALANCE_RECHARGE = 0;
    private static final int CANCEL_ORDER = 999;

    private static final Map<Beverages, Integer> BEVERAGES_PRICES = new HashMap() {{
        put(Beverages.TEA, 25);
        put(Beverages.COFFEE, 35);
        put(Beverages.JUICE, 45);
    }};

    private static final Set<Integer> ACCEPTING_COINS = Stream.of(1, 5, 10, 25, 50).collect(Collectors.toSet());

    private final Controller controller;
    private final View view;
    private Beverages choosenBeverage;
    private int cost;
    private int balance = 0;
    private int shortChange = 0;


    public Sale(Beverages choosenBeverage, Controller controller, View view) {
        this.choosenBeverage = choosenBeverage;
        this.cost = BEVERAGES_PRICES.get(choosenBeverage);
        this.controller = controller;
        this.view = view;
    }

    public void makePayment() {
        int enteredCoinParValue;
        //view.printMessageAndInt(View.BALANCE, balance);
        //view.printMessage(View.COINS_MENU);
        do {
            view.printMessageAndInt(View.BALANCE, balance);
            enteredCoinParValue = controller.getUsersCoinsWithScanner(View.COINS_MENU, View.WRONG_COIN);
            if (enteredCoinParValue == CANCEL_ORDER) {
                view.printMessageAndInt(View.CANCEL_ORDER_AND_TAKE_BALANCE_REPLENISHMENT, balance);
                choosenBeverage = Beverages.UNDEFINED;
                cost = 0;
                break;
            } else if (ACCEPTING_COINS.contains(enteredCoinParValue)) {
                balance += enteredCoinParValue;
            } else if (enteredCoinParValue == END_BALANCE_RECHARGE){
                view.printMessageAndInt(View.ACCUMULATED_BALANCE, balance);
            } else {
                view.printMessage(View.WRONG_COIN);
            }
        } while (enteredCoinParValue != END_BALANCE_RECHARGE);
    }

    public void giveUsersBeverage() {
        if (!choosenBeverage.equals(Beverages.UNDEFINED)) {
            view.printMessageAndString(View.TAKE_BEVERAGE, choosenBeverage.toString());
        }
    }

    public boolean isEnoughMoneyForOrderSell() {
        return balance >= cost;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isOrderCanceled() {
        return choosenBeverage.equals(Beverages.UNDEFINED);
    }
}
