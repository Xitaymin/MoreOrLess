package ua.training.controller;

import ua.training.model.Game;

public interface GameBuilder {
    Game makeGame();
    void setMinLimit(Integer minLimit);
    void setMaxLimit(Integer maxLimit);
    void setSecretNumber();
}
