package ua.training.controller;

public class DefaultUserInputValidator implements UserInputValidator{
    boolean checkIfUserInputInRange (Integer userInput, Integer minLimit, Integer maxLimit) {
        return (userInput<maxLimit)&&(userInput>minLimit);
    }
}
