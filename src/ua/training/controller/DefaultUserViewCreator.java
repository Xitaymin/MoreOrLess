package ua.training.controller;

import ua.training.view.View;

public class DefaultUserViewCreator implements UserViewCreator{
    private View view;

    @Override
    public void inviteUserToGame() {
        view.showMessage(View.INVITING);
    }
}
