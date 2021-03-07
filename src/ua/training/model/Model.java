package ua.training.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public static final int LESS = -1;
    public static final int MORE = 1;
    public static final int EQUAL = 0;
    private int minLimit = 1;
    private int maxLimit = 100;
    private int guessedNumber;
    private int stepCounter = 0;
    private List<Integer> history = new ArrayList<>();

    public Model() {
    }

    public int getStepCounter() {
        return stepCounter;
    }

    public List<Integer> getHistory() {
        return history;
    }

    public int getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(int minLimit) {
        this.minLimit = minLimit;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    public void setGuessedNumber() {
        guessedNumber = minLimit + (int)(Math.random()*(maxLimit - minLimit));
    }

    public int getGuessedNumber() {
        return guessedNumber;
    }

    public int compareUserInputWithGuessedNumber(int userInput) {

        stepCounter++;
        history.add(userInput);
        if(userInput<guessedNumber){
            changeRange(userInput, maxLimit);
            return Model.LESS;
        }
        else if(userInput>guessedNumber){
            changeRange(minLimit,userInput);
            return Model.MORE;
        }
        else { return Model.EQUAL;}
    }

    public void changeRange(int newMinLimit, int newMaxLimit) {
        setMinLimit(newMinLimit);
        setMaxLimit(newMaxLimit);
    }
}
