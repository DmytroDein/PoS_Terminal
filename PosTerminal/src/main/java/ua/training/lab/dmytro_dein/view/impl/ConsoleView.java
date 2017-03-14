package ua.training.lab.dmytro_dein.view.impl;

import ua.training.lab.dmytro_dein.view.View;

public class ConsoleView implements View {

    @Override
    public void printMessage(String message){
        System.out.print(message);
    }

    @Override
    public void printMessageAndInt(String message, int value){
        System.out.format(message, value);
    }

    @Override
    public void printMessageAndString(String message, String value) {
        System.out.format(message, value);
    }
}
