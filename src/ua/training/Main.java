package ua.training;

import ua.training.controller.Controller;
import ua.training.view.View;
import ua.training.model.Model;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model,view);

        controller.processUserInput();
    }
}
