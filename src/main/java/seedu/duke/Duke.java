package seedu.duke;

import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class Duke {

    private static final Ui ui = new Ui();
    private static final Storage storage = new Storage();
    private static final Parser parser = new Parser();

    public static void main(String[] args) {
        //start and load
        start();

        //receive user input
        run();

        //exit
        exit();
    }

    private static void start() {
        //print welcome
        //ui.printWelcome();

        //load data from file
        //storage.loadData();
    }

    private static void run() {
        //Boolean isExit = false;

        //loop
        //while (!isExit) {
            //scan

            //parse
            //Command command = parser.parse(input);

            //execute
            //isExit = command.execute();
        //}
    }

    private static void exit() {
        //print exit message
        //ui.printBye();
    }
}
