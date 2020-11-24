package ua.training;

import java.util.Scanner;

public class AdvancedController extends Controller {
    public AdvancedController(ModelWithStatistic model, View view) {
        super(model, view);
    }

    @Override
    void processUserInput() {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        while (!scanner.hasNextInt()) {
        }
//todo process situation when user entered not number
    }
}
