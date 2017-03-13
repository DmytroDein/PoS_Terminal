package ua.training.lab.dmytro_dein;


import ua.training.lab.dmytro_dein.controller.ControllerImpl;
import ua.training.lab.dmytro_dein.controller.Controller;
import ua.training.lab.dmytro_dein.view.View;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Starting PoS Terminal...\n");

        View view = new View();
        Controller controller = new ControllerImpl(view);
        controller.processUser();
    }
}
