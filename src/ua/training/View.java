package ua.training;

public class View {
    public static final String GREETING = "Try to guess a number from 1 to 99 inclusively. Print your number.";
    public static final String INVALID_INPUT = "Your number is not in range. Print your number in range:";
    public static final String CONGRATULATION = "You win, the guessed number is ";
    public static final String LESS_NUMBER = "Your number is less than guessed number. Guessed number is in range:";
    public static final String GREATER_NUMBER = "Your number is greater than guessed number. Guessed number is in range:";

     void showMessage(String message) {
        System.out.println(message);
    }

    void showMessageWithRange(String message, int minLimit, int maxLimit) {
        System.out.println(message + " (" + minLimit + ", " + maxLimit + ")");
    }
}
