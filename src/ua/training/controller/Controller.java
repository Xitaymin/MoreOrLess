package ua.training.controller;

import ua.training.model.Model;
import ua.training.view.View;

import java.util.Scanner;

public class Controller {
     Model model;
     View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

     public void processUserInput(){
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

     private void launchGame(Scanner scanner) {
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
    private boolean checkIfUserInputValid (int userInput) {
        return (userInput<model.getMaxLimit())&&(userInput>model.getMinLimit());
    }
    private int getUserIntInput(Scanner scanner) {
        int userInput;
        checkIfIntValue(scanner);
        userInput = scanner.nextInt();
        return userInput;
    }
    private void askUserToStartGuessNumber() {
        view.concatStrings(View.INVITING,View.LEFT_BRACKET,String.valueOf(model.getMinLimit()),View.COMMA,String.valueOf(model.getMaxLimit()),View.RIGHT_BRACKET);
    }

    private void askUserForCorrectMaxLimit() {
        view.concatStrings(View.MAX_LIMIT_WARNING,String.valueOf(model.getMinLimit()));
    }

    boolean checkMaxLimit (int userInput) {
        return userInput > model.getMinLimit();
    }
}
