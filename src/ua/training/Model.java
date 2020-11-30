package ua.training;

public class Model {
    public static final int LESS = -1;
    public static final int MORE = 1;
    public static final int EQUAL = 0;
    private int minLimit = 1;
    private int maxLimit = 100;
    private int guessedNumber;

    public Model() {
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
        guessedNumber = (int)(Math.random()*(maxLimit - minLimit) + minLimit);
    }

    public int getGuessedNumber() {
        return guessedNumber;
    }

    protected int compareUserInputWithGuessedNumber(int userInput) {
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

    protected void changeRange(int newMinLimit, int newMaxLimit) {
        setMinLimit(newMinLimit);
        setMaxLimit(newMaxLimit);
    }
}
