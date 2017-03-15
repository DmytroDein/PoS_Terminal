package ua.training.lab.dmytro_dein.model;

/**
 * Created by Dmytro_Deinichenko on 3/14/2017.
 */
public interface Sale {
    void makePayment();

    void giveUsersBeverage();

    boolean isEnoughMoneyForOrderSell();

    int getBalance();

    boolean isOrderCanceled();

    void giveShortChange();

    void collectPayments(Beverages userChoose);
}
