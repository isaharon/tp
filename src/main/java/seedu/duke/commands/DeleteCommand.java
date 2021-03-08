package seedu.duke.commands;

import seedu.duke.common.Messages;
import seedu.duke.exceptions.CommandException;
import seedu.duke.exceptions.DukeException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static java.util.Objects.requireNonNull;

public class DeleteCommand extends Command {

    public static final String MESSAGE_PROMPT1 = "Which modules would you like to delete?\n";
    public static final String MESSAGE_PROMPT2 = "Please enter the indices of the modules you would like to delete.\n"
            + "Separate indices with a blank space.";
    public static final String MESSAGE_SUCCESS = "Removed %s from the module list.";

    @Override
    public void execute(ModuleList modules, UI ui) throws CommandException {
        requireNonNull(modules);

        String firstStageMessage = firstStage(modules);
        ui.printMessage(firstStageMessage);

        // TODO Parser to validate list of integers. Assume input is valid for now.
        ArrayList<Integer> integers = ui.readIntegers();
        ArrayList<String> deletedModules = modules.deleteModules(integers);
        String secondStageMessage = secondStage(deletedModules);
        ui.printMessage(secondStageMessage);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    /*
     * Executes first stage of the DeleteCommand and prints out list of modules to delete.
     */
    private String firstStage(ModuleList modules) {
        String listMessage = MESSAGE_PROMPT1;
        for (String moduleCode : modules.getModules()) {
            int moduleNumber = modules.getModules().indexOf(moduleCode) + 1;
            listMessage += String.format(Messages.MESSAGE_LIST_ITEMS,
                    moduleNumber, moduleCode);
            listMessage += "\n";
        }
        listMessage += "\n" + MESSAGE_PROMPT2;
        return listMessage;
    }

    /*
     * Formats list of delete modules into a string.
     */
    private String secondStage(ArrayList<String> deletedModules) {
        String deletedMessage = "";
        for (String deletedModule : deletedModules) {
            deletedMessage += String.format(MESSAGE_SUCCESS, deletedModule);
            deletedMessage += "\n";
        }
        return deletedMessage;
    }
}
