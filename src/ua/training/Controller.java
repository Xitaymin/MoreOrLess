package ua.training;

import java.util.Scanner;

public class Controller {
    private ModelWithStatistic model;
    private View view;

    public Controller(ModelWithStatistic model, View view) {
        this.model = model;
        this.view = view;
    }

     void processUserInput(){
        Scanner scanner = new Scanner(System.in);
        boolean shouldInputContinue = true;
        int userInput;
        view.showMessage(View.GREETING);
        while (shouldInputContinue) {
            userInput = scanner.nextInt();
            if(checkIfUserInputValid(userInput)){
                int compairingResult = model.compareUserInputWithGuessedNumber(userInput);
                if(compairingResult == Model.EQUAL) {
                    view.showMessage(View.CONGRATULATION + userInput);
                    view.showStepCounter(model.getStepCounter());
                    shouldInputContinue = false;
                }
                else if(compairingResult == Model.LESS) {
                    view.showMessageWithRange(View.LESS_NUMBER,model.getMinLimit(),model.getMaxLimit());
                    view.showHistoryOfAttempts(model.getHistory());
                }
                else {
                    view.showMessageWithRange(View.GREATER_NUMBER,model.getMinLimit(),model.getMaxLimit());
                    view.showHistoryOfAttempts(model.getHistory());
                }
            }
            else {view.showMessageWithRange(View.INVALID_INPUT, model.getMinLimit(), model.getMaxLimit());
                  view.showHistoryOfAttempts(model.getHistory());}
        }
    }

    boolean checkIfUserInputValid (int userInput) {
        return (userInput<model.getMaxLimit())&&(userInput>model.getMinLimit());
    }


}
