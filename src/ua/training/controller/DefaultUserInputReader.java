package ua.training.controller;

import ua.training.view.View;

import java.util.Scanner;

public class DefaultUserInputReader implements UserInputReader{
    View view = new View();

    private Integer getUserNumber() {
        Scanner scanner = new Scanner(System.in);
        checkIfIntValue(scanner);
        return scanner.nextInt();
    }

    private void checkIfIntValue(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            view.showMessage(View.WRONG_INPUT_TYPE);
            scanner.next();
        }
    }

}
