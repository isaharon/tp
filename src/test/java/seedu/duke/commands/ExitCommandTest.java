package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ExitCommandTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void execute_noInput_expectBye() throws CommandException {
        System.setOut(new PrintStream(outContent));

        ModuleList moduleList = new ModuleList();
        moduleList.addModule("CS2105");
        moduleList.addModule("CS2106");

        Command command = new ExitCommand();
        command.execute(moduleList, new UI());

        String output = Messages.MESSAGE_EXIT;
        assertEquals(output + System.lineSeparator(), outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void isExit_emptyInput_expectReturnsTrue() {
        assertEquals(true, new ExitCommand().isExit());
    }
}