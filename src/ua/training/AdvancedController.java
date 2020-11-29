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
        view.showMessage(View.INPUT_LOW_LIMIT);
        checkIfIntValue(scanner);
        model.setMinLimit(scanner.nextInt());
        view.showMessage(View.INPUT_HIGH_LIMIT);
        checkIfIntValue(scanner);
        userInput = scanner.nextInt();
        if(checkMaxLimit(userInput)){
            model.setMaxLimit(userInput);
        }
        askUserToStartGuessNumber();
        launchGame(scanner);
    }

    void askUserToStartGuessNumber() {
        view.concatStrings(View.INVITING,View.LEFT_BRACKET,String.valueOf(model.getMinLimit()),View.COMMA,String.valueOf(model.getMaxLimit()),View.RIGHT_BRACKET);
    }

    boolean checkMaxLimit (int userInput) {
        return userInput > model.getMinLimit();
    }


}
