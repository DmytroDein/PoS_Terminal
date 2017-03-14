package ua.training.lab.dmytro_dein.controller;

/**
 * Created by Dmytro_Deinichenko on 3/14/2017.
 */
public interface InteractionHandling {
    void startInteraction();
    int getUsersCoinsWithScanner(String askMessage, String wrongMessage);
}
