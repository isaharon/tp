package seedu.duke.commands;

import seedu.duke.common.Messages;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

public class ExitCommand extends Command {

    @Override
    public void execute(ModuleList modules, UI ui) {
        ui.printMessage(Messages.MESSAGE_EXIT);
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
