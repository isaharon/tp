package seedu.duke.commands;

import seedu.duke.common.Messages;
import seedu.duke.exceptions.DukeException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.Ui;

import static java.util.Objects.requireNonNull;

public class ListModuleCommand extends Command {
    public static final String MESSAGE_LIST = "Modules in your list:";

    @Override
    public void execute(ModuleList modules, Ui ui) throws DukeException {
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
