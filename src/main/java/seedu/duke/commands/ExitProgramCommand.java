package seedu.duke.commands;

import seedu.duke.module.ModuleList;
import seedu.duke.ui.Ui;

public class ExitProgramCommand extends Command {
    public static final String MESSAGE_BYE = "Bye.";

    @Override
    public void execute(ModuleList modules, Ui ui) {
        ui.printMessage(MESSAGE_BYE);
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
