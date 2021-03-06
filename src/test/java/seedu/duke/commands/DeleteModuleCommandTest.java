package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.DukeException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.Ui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeleteModuleCommandTest {

    @Test
    void execute_validModuleNumbersInput_expectSuccess() throws DukeException {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ByteArrayInputStream inContent = new ByteArrayInputStream("1 3".getBytes());
        System.setIn(inContent);

        ModuleList modules = new ModuleList();
        modules.addModule("CS2113T");
        modules.addModule("CS2101");
        modules.addModule("CS2105");
        modules.addModule("CS2106");

        Command command = new DeleteModuleCommand();
        command.execute(modules, new Ui());

        String output = DeleteModuleCommand.MESSAGE_PROMPT1 + "\n"
                + String.format(Messages.MESSAGE_LIST_ITEMS, 1, "CS2113T") + "\n"
                + String.format(Messages.MESSAGE_LIST_ITEMS, 2, "CS2101") + "\n"
                + String.format(Messages.MESSAGE_LIST_ITEMS, 3, "CS2105") + "\n"
                + String.format(Messages.MESSAGE_LIST_ITEMS, 4, "CS2106") + "\n" + "\n"
                + DeleteModuleCommand.MESSAGE_PROMPT2 + System.lineSeparator();
        output += String.format(DeleteModuleCommand.MESSAGE_SUCCESS, "CS2113T") + System.lineSeparator()
                + String.format(DeleteModuleCommand.MESSAGE_SUCCESS, "CS2105");

        assertEquals(output + System.lineSeparator(), outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void isExit_emptyInput_expectFalse() {
        assertEquals(false, new DeleteModuleCommand().isExit());
    }
}