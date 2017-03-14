package ua.training.lab.dmytro_dein.controller.impl;

import ua.training.lab.dmytro_dein.controller.Controlling;
import ua.training.lab.dmytro_dein.controller.InteractionHandling;
import ua.training.lab.dmytro_dein.view.View;


public class Controller implements Controlling {

    private final InteractionHandling handler;
    private final View view;

    public Controller(View view, InteractionHandling handler) {
        this.view = view;
        this.handler = handler;
        view.printMessage("Starting PoS Terminal...\n");
    }

    @Override
    public void processUser(){
        handler.startInteraction();
    }
}
