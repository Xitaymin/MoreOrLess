package ua.training.controller;

import ua.training.model.Game;

public class DefaultController implements Controller{
    private UserInputReader reader;
    private UserInputValidator validator;
    private UserViewCreator viewCreator;
    private GameBuilder gameBuilder;
    private Game game;

    @Override
    public void initialGame() {
        Integer userInput;
        viewCreator.welcomeUser();
        viewCreator.offerUserSetMinLimit();
        userInput = reader.getUserIntValue();
        gameBuilder.setMinLimit(userInput);
        viewCreator.offerUserSetMaxLimit();
        userInput = reader.getUserIntValue();

        while (!validator.checkUserMaxLimit(gameBuilder,userInput)){
            viewCreator.showMaxLimitRestriction();
            userInput = reader.getUserIntValue();
        }

        gameBuilder.setMaxLimit(userInput);
        gameBuilder.setSecretNumber();
        game = gameBuilder.makeGame();
    }

    @Override
    public void playGame() {
        Integer userInput;
        viewCreator.inviteUserToGame();



        while(game.isContinue){
            makeStep();}
        }



    private void makeStep() {
        int userInput;
        userInput = reader.getUserIntValue();
        while (!validator.checkIfUserValueInRange(userInput,game));
        userInput = reader.getUserIntValue();
        viewCreator.showOutOfRangeWarning();

        game.compareUserValueWithSecretNumber();
    }

}
