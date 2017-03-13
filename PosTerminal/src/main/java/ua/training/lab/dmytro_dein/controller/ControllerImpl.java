package ua.training.lab.dmytro_dein.controller;

import ua.training.lab.dmytro_dein.view.View;


public class ControllerImpl implements Controller {

    private final UserInteractionHandler userInteractionHandler;

    public ControllerImpl(View view) {
        userInteractionHandler = new UserInteractionHandler(view);
        //this.userInteractionHandler.view = view;
    }

    @Override
    public void processUser(){
        userInteractionHandler.processUser();
    }



}
