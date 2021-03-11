package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.exception.UnknownCommandException;
import seedu.duke.exception.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.parser.Parser;
import seedu.duke.ui.UI;

import java.util.Scanner;

public class Duke {

    private static final UI ui = new UI();

    public static void main(String[] args) {

        //Start and load
        start();

        //Receive user input
        run();

    }

    private static void start() {
        //Print welcome
        ui.printWelcome();

        //Load module names
        ModuleList.loadModuleNames();
    }

    private static void run() {
        boolean isExit = false;
        Scanner scanner = new Scanner(System.in);

        Parser parser = new Parser();

        //Loop
        while (!isExit) {
            ui.printModuleIndicator();
            //Scan
            String input = scanner.nextLine();

            //Parse
            try {
                Command command = parser.parse(input);

                //Execute
                command.execute(ui);
                isExit = command.isExit();
            } catch (UnknownCommandException e) {
                //Invalid command
            } catch (CommandException e) {
                //Error running command
            }

        }
    }

}
