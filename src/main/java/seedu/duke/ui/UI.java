package seedu.duke.ui;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private final Scanner scanner = new Scanner(System.in);

    public String readUserInput() {
        String userInput = scanner.nextLine();
        return userInput;
    }

    public ArrayList<Integer> readIntegers() {
        ArrayList<Integer> listOfIntegers = new ArrayList<>();
        while (scanner.hasNextInt()) {
            listOfIntegers.add(scanner.nextInt());
        }
        return listOfIntegers;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
