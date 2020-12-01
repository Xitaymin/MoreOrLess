package ua.training.controller;

import ua.training.model.Model;
import ua.training.model.ModelWithStatistic;
import ua.training.view.View;

import java.util.Scanner;

public class OldController {
     ModelWithStatistic model;
     View view;

    public OldController(ModelWithStatistic model, View view) {
        this.model = model;
        this.view = view;
    }

     public void processUserInput(){
        Scanner scanner = new Scanner(System.in);
        boolean shouldInputContinue = true;
        int userInput;
        model.setGuessedNumber();
        view.showMessage(View.GREETING);
        launchGame(scanner);
     }

     protected void launchGame(Scanner scanner) {
        int userInput;
        boolean shouldInputContinue = true;
        while (shouldInputContinue) {
            checkIfIntValue(scanner);
            userInput = scanner.nextInt();
            shouldInputContinue = processUserIntValue(scanner, shouldInputContinue, userInput);
        }
    }

    protected void checkIfIntValue(Scanner scanner) {
        while (!scanner.hasNextInt()){
            view.showMessage(View.WRONG_INPUT_TYPE);
            scanner.next();
        }
    }

    private boolean processUserIntValue(Scanner scanner, boolean shouldInputContinue, int userInput) {
        if (checkIfUserInputValid(userInput)) {
            int compairingResult = model.compareUserInputWithGuessedNumber(userInput);
            if (compairingResult == Model.EQUAL) {
                endGame(scanner, userInput);
                shouldInputContinue = false;
            } else if (compairingResult == Model.LESS) {
                askUserToContinue(View.LESS_NUMBER);
            } else {
                askUserToContinue(View.GREATER_NUMBER);
            }
        } else {
            askUserToContinue(View.INVALID_INPUT);
        }
        return shouldInputContinue;
    }

    private void endGame(Scanner scanner, int userInput) {
        view.showMessage(View.CONGRATULATION + userInput);
        view.showStepCounter(model.getStepCounter());
        scanner.close();
    }

    private void askUserToContinue(String compairingResult) {
        view.showMessageWithRange(compairingResult, model.getMinLimit(), model.getMaxLimit());
        view.showHistoryOfAttempts(model.getHistory());
    }
    //todo replace inheritance on interface implementation
    boolean checkIfUserInputValid (int userInput) {
        return (userInput<model.getMaxLimit())&&(userInput>model.getMinLimit());
    }
}
