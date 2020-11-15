package ua.training;

public class Model {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 100;
    public static final int LESS = -1;
    public static final int MORE = 1;
    public static final int EQUAL = 0;


    private int guessedNumber;

    public Model() {
        this.guessedNumber = setRandomNumber();
    }

    private int setRandomNumber() {
        return  (int)(Math.random()*(MAX_RANGE - MIN_RANGE) + MIN_RANGE);
    }

    int compareUserInputWithGuessedNumber(int userInput) {
        if(userInput<guessedNumber){
            return Model.LESS;
        }
        else if(userInput>guessedNumber){
            return Model.MORE;
        }
        else { return Model.EQUAL;}
    }
}
