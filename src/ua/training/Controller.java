package ua.training;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    

    public Controller(Model model, View view) {
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
                model.compareUserInputWithGuessedNumber(userInput);
            }

        }
    }

    boolean checkIfUserInputValid (int userInput) {
        return (userInput>=Model.MIN_RANGE)&&(userInput<=Model.MAX_RANGE);
    }


}
