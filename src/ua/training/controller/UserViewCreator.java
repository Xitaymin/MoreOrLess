package ua.training.controller;

public interface UserViewCreator {
    void welcomeUser();
    void inviteUserToGame();
    void offerUserSetMinLimit();
    void offerUserSetMaxLimit();
    void showMaxLimitRestriction();

}
