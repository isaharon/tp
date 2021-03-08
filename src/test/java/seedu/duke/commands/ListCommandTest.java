package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.DukeException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ListModuleCommandTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void execute_noInput_expectListAllModulesAdded() throws DukeException {
        System.setOut(new PrintStream(outContent));

        ModuleList moduleList = new ModuleList();
        moduleList.addModule("CS2113T");
        moduleList.addModule("CS2105");
        moduleList.addModule("CS2106");

        Command command = new ListModuleCommand();
        command.execute(moduleList, new UI());

        String output = ListModuleCommand.MESSAGE_LIST + "\n";
        output += String.format(Messages.MESSAGE_LIST_ITEMS, "1","CS2113T") + "\n";
        output += String.format(Messages.MESSAGE_LIST_ITEMS, "2","CS2105") + "\n";
        output += String.format(Messages.MESSAGE_LIST_ITEMS, "3","CS2106");

        assertEquals(output + System.lineSeparator(), outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void isExit_noInput_expectFalse() {
        assertEquals(false, new ListModuleCommand().isExit());
    }
}