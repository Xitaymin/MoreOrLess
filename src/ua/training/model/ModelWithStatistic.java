package ua.training.model;

import java.util.ArrayList;
import java.util.List;

public class ModelWithStatistic extends Model {
    private int stepCounter = 0;
    private List<Integer> history = new ArrayList<>();

    public int getStepCounter() {
        return stepCounter;
    }

    public List<Integer> getHistory() {
        return history;
    }

    @Override
    public int compareUserInputWithGuessedNumber(int userInput) {
        stepCounter++;
        history.add(userInput);
        return super.compareUserInputWithGuessedNumber(userInput);
    }
}
