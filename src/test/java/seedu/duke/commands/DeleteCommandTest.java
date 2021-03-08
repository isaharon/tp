package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DeleteCommandTest {

    @Test
    void execute_validModuleNumbersInput_expectSuccess() throws CommandException {
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

        Command command = new DeleteCommand();
        command.execute(modules, new UI());

        String output = DeleteCommand.MESSAGE_PROMPT1
                + String.format(Messages.MESSAGE_LIST_ITEMS, 1, "CS2113T") + "\n"
                + String.format(Messages.MESSAGE_LIST_ITEMS, 2, "CS2101") + "\n"
                + String.format(Messages.MESSAGE_LIST_ITEMS, 3, "CS2105") + "\n"
                + String.format(Messages.MESSAGE_LIST_ITEMS, 4, "CS2106") + "\n\n"
                + DeleteCommand.MESSAGE_PROMPT2 + System.lineSeparator();
        output += String.format(DeleteCommand.MESSAGE_SUCCESS, "CS2113T") + "\n"
                + String.format(DeleteCommand.MESSAGE_SUCCESS, "CS2105") + "\n";

        assertEquals(output + System.lineSeparator(), outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void isExit_emptyInput_expectFalse() {
        assertEquals(false, new DeleteCommand().isExit());
    }
}