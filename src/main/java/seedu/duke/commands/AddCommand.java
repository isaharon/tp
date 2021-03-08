package seedu.duke.commands;

import seedu.duke.exceptions.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import static java.util.Objects.requireNonNull;

public class AddCommand extends Command {

    public static final String MESSAGE_SUCCESS = "Added %s to the module list.";
    public static final String MESSAGE_DUPLICATE = "Module code %s already exists in the module list";

    private final String moduleCode;

    public AddCommand(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    @Override
    public void execute(ModuleList modules, UI ui) throws CommandException {
        requireNonNull(modules);

        for (String moduleCode : modules.getModules()) {
            if (moduleCode.equals(this.moduleCode)) {
                throw new CommandException(String.format(MESSAGE_DUPLICATE, moduleCode));
            }
        }
        modules.addModule(moduleCode);
        System.out.println(String.format(MESSAGE_SUCCESS, moduleCode));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
