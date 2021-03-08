package seedu.duke.commands;

import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

public class ExitProgramCommand extends Command {
    public static final String MESSAGE_BYE = "Bye.";

    @Override
    public void execute(ModuleList modules, UI ui) {
        ui.printMessage(MESSAGE_BYE);
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
