package ua.training;

import java.util.List;

public class View {
    public static final String GREETING = "Try to guess a number from 1 to 99 inclusively. Print your number.";
    public static final String INVALID_INPUT = "Your number is not in range. Print your number in range:";
    public static final String CONGRATULATION = "You win, the guessed number is ";
    public static final String LESS_NUMBER = "Your number is less than guessed number. Guessed number is in range:";
    public static final String GREATER_NUMBER = "Your number is greater than guessed number. Guessed number is in range:";
    public static final String WRONG_INPUT_TYPE = "You printed another symbol. Please, enter a number.";
     void showMessage(String message) {
        System.out.println(message);
    }

    void showMessageWithRange(String message, int minLimit, int maxLimit) {
        System.out.println(message + " (" + minLimit + ", " + maxLimit + ")");
    }

    void showHistoryOfAttempts(List<Integer> steps) {
         StringBuilder sb = new StringBuilder();
        System.out.print("Before you entered: ");
        for (Integer step:steps) {
            sb.append(step);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    void showStepCounter(int counter){
        System.out.println("You made " + counter + " attempts.");
    }
}
