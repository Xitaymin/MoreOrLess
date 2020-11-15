package ua.training;

public class Model {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 100;
    private int guessedNumber;

    public int getGuessedNumber() {
        return guessedNumber;
    }
    private int getRandomNumber() {
        return (int)(Math.random()*(MAX_RANGE - MIN_RANGE) + MIN_RANGE);
    }
}
