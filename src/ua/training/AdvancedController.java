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
        userInput = getUserIntInput(scanner);
        while (!checkMaxLimit(userInput)){
            askUserForCorrectMaxLimit();
            view.showMessage(View.INPUT_HIGH_LIMIT);
            userInput = getUserIntInput(scanner);
        }
        model.setMaxLimit(userInput);
        model.setGuessedNumber();
        askUserToStartGuessNumber();
        launchGame(scanner);
    }

    private int getUserIntInput(Scanner scanner) {
        int userInput;
        checkIfIntValue(scanner);
        userInput = scanner.nextInt();
        return userInput;
    }

    void askUserToStartGuessNumber() {
        view.concatStrings(View.INVITING,View.LEFT_BRACKET,String.valueOf(model.getMinLimit()),View.COMMA,String.valueOf(model.getMaxLimit()),View.RIGHT_BRACKET);
    }

    void askUserForCorrectMaxLimit() {
        view.concatStrings(View.MAX_LIMIT_WARNING,String.valueOf(model.getMinLimit()));
    }

    boolean checkMaxLimit (int userInput) {
        return userInput > model.getMinLimit();
    }


}
