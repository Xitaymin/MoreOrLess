package ua.training;

public class Main {

    public static void main(String[] args) {
        ModelWithStatistic model = new ModelWithStatistic();
        View view = new View();
        Controller controller = new AdvancedController(model,view);

        controller.processUserInput();
    }
}
