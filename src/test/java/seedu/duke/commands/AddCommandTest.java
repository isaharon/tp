package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.DukeException;
import seedu.duke.exceptions.DuplicateModuleCodeException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AddModuleCommandTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void execute_uniqueModuleCode_expectPrintSuccess() throws DukeException {
        System.setOut(new PrintStream(outContent));

        ModuleList moduleList = new ModuleList();
        moduleList.addModule("CS2105");
        moduleList.addModule("CS2106");

        String moduleCode = "CS2113T";
        Command command = new AddModuleCommand(moduleCode);
        command.execute(moduleList, new UI());

        String output = String.format(AddModuleCommand.MESSAGE_SUCCESS, moduleCode);
        assertEquals(output + System.lineSeparator(), outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void execute_duplicateModuleCode_expectDuplicateModuleException() {
        ModuleList moduleList = new ModuleList();
        moduleList.addModule("CS2113T");

        String moduleCode = "CS2113T";
        AddModuleCommand command = new AddModuleCommand(moduleCode);
        assertThrows(DuplicateModuleCodeException.class, () -> command.execute(moduleList, new UI()));

    }

    @Test
    void isExit_singleInput_expectReturnFalse() {
        assertEquals(false, new AddModuleCommand("CS2113T").isExit());
    }
}