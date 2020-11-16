package ua.training;

public class Model {
    public static final int LESS = -1;
    public static final int MORE = 1;
    public static final int EQUAL = 0;
    private int minLimit = 1;
    private int maxLimit = 100;
    private int guessedNumber;

    public Model() {
        this.guessedNumber = setRandomNumber();
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

    private int setRandomNumber() {
        return  (int)(Math.random()*(maxLimit - minLimit) + minLimit);
    }

    int compareUserInputWithGuessedNumber(int userInput) {
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

    void changeRange(int newMinLimit, int newMaxLimit) {
        setMinLimit(newMinLimit);
        setMaxLimit(newMaxLimit);
    }
}
