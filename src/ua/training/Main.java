package ua.training;

import ua.training.controller.AdvancedController;
import ua.training.controller.Controller;
import ua.training.model.ModelWithStatistic;
import ua.training.view.View;

public class Main {

    public static void main(String[] args) {
        ModelWithStatistic model = new ModelWithStatistic();
        View view = new View();
        Controller controller = new AdvancedController(model,view);

        controller.processUserInput();
    }
}
