package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.DukeException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.Ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ExitProgramCommandTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void execute_noInput_expectBye() throws DukeException {
        System.setOut(new PrintStream(outContent));

        ModuleList moduleList = new ModuleList();
        moduleList.addModule("CS2105");
        moduleList.addModule("CS2106");

        Command command = new ExitProgramCommand();
        command.execute(moduleList, new Ui());

        String output = ExitProgramCommand.MESSAGE_BYE;
        assertEquals(output + System.lineSeparator(), outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void isExit_emptyInput_expectReturnsTrue() {
        assertEquals(true, new ExitProgramCommand().isExit());
    }
}