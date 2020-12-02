package ua.training.controller;

import ua.training.model.Game;

public interface UserInputValidator {
    boolean checkUserMaxLimit(GameBuilder gameBuilder, Integer userInput);
    boolean checkIfUserValueInRange(Integer userInput, Game game);
}
