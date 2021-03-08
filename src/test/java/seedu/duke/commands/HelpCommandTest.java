package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.CommandException;
import seedu.duke.exceptions.DukeException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HelpCommandTest {

    @Test
    void execute_noInput_expectAllCommandsWithDescription() throws CommandException {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ModuleList moduleList = new ModuleList();
        moduleList.addModule("CS2105");
        moduleList.addModule("CS2106");

        // execute command
        Command command = new HelpCommand();
        command.execute(moduleList, new UI());

        String output = HelpCommand.HELP_MESSAGE;
        assertEquals(output + System.lineSeparator(), outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void isExit_noInput_expectFalse() {
        assertEquals(false, new HelpCommand().isExit());
    }
}