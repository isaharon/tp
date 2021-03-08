package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EnterCommandTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void execute_validModuleCodeInput_expectSuccess() throws CommandException {
        System.setOut(new PrintStream(outContent));

        ModuleList modules = new ModuleList();
        modules.setModules(new ArrayList<>(Arrays.asList("CS2113T", "CS2102", "CS2105", "CS2106")));

        Command command = new EnterCommand("CS2105");
        command.execute(modules, new UI());

        String output = "Opening CS2105." + System.lineSeparator() + "<Placeholder for overview>";
        assertEquals(output + System.lineSeparator(), outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void execute_invalidModuleCodeInput_expectException() throws CommandException {
        System.setOut(new PrintStream(outContent));

        ModuleList modules = new ModuleList();
        modules.setModules(new ArrayList<>(Arrays.asList("CS2113T", "CS2102", "CS2105", "CS2106")));

        Command command = new EnterCommand("CS3235");

        assertThrows(CommandException.class, () -> command.execute(modules, new UI()));

        System.setOut(originalOut);
    }

    @Test
    void isExit_singleInput_expectFalse() {
        assertEquals(false, new EnterCommand("CS2102").isExit());
    }
}