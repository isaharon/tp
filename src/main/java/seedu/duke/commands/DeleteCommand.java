package seedu.duke.commands;

import seedu.duke.common.Messages;
import seedu.duke.exceptions.DukeException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static java.util.Objects.requireNonNull;

public class DeleteModuleCommand extends Command {

    public static final String MESSAGE_PROMPT1 = "Which modules would you like to delete?";
    public static final String MESSAGE_PROMPT2 = "Please enter the indices of the modules you would like to delete.\n"
            + "Separate indices with a blank space.";
    public static final String MESSAGE_SUCCESS = "Removed %s from the module list.";

    @Override
    public void execute(ModuleList modules, UI ui) throws DukeException {
        requireNonNull(modules);

        firstStage(modules, ui);
        secondStage(modules, ui);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    /**
     * Executes first stage of the DeleteModuleCommand and prints out list of modules to delete.
     * @param modules list of modules
     * @param ui Ui object for printing
     */
    private void firstStage(ModuleList modules, UI ui) {
        String listMessage = MESSAGE_PROMPT1;
        for (String moduleCode : modules.getModules()) {
            int moduleNumber = modules.getModules().indexOf(moduleCode) + 1;
            listMessage += "\n";
            listMessage += String.format(Messages.MESSAGE_LIST_ITEMS,
                    moduleNumber, moduleCode);
        }
        ui.printMessage(listMessage + "\n\n" + MESSAGE_PROMPT2);
    }

    private void secondStage(ModuleList modules, UI ui) {
        // TODO Parser to validate list of integers. Assume input is valid for now.
        ArrayList<Integer> integers = ui.readIntegers();
        ArrayList<String> deletedModules = modules.deleteModules(integers);

        for (String deletedModule : deletedModules) {
            ui.printMessage(String.format(MESSAGE_SUCCESS, deletedModule));
        }
    }
}
