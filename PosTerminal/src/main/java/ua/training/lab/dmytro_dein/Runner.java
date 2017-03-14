package ua.training.lab.dmytro_dein;

import ua.training.lab.dmytro_dein.controller.impl.ConsoleInteractionHandler;
import ua.training.lab.dmytro_dein.controller.impl.Controller;
import ua.training.lab.dmytro_dein.controller.Controlling;
import ua.training.lab.dmytro_dein.controller.InteractionHandling;
import ua.training.lab.dmytro_dein.view.impl.ConsoleView;
import ua.training.lab.dmytro_dein.view.View;

public class Runner {
    public static void main(String[] args) {
        View view = new ConsoleView();
        InteractionHandling handler = new ConsoleInteractionHandler(view);
        Controlling controller = new Controller(view, handler);
        controller.processUser();
    }
}
