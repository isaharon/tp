package seedu.duke.commands;

import seedu.duke.common.Messages;
import seedu.duke.exceptions.CommandException;
import seedu.duke.exceptions.DukeException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import static java.util.Objects.requireNonNull;

public class ListCommand extends Command {

    public static final String MESSAGE_LIST = "Modules in your list:";

    @Override
    public void execute(ModuleList modules, UI ui) throws CommandException {
        requireNonNull(modules);
        String listMessage = MESSAGE_LIST;
        for (String module : modules.getModules()) {
            int moduleNumber = modules.getModules().indexOf(module) + 1;
            listMessage += "\n";
            listMessage += String.format(Messages.MESSAGE_LIST_ITEMS, moduleNumber, module);
        }
        ui.printMessage(listMessage);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
