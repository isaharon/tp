package seedu.duke.commands;

import seedu.duke.exceptions.DukeException;
import seedu.duke.exceptions.InvalidModuleCodeException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.Ui;

import static java.util.Objects.requireNonNull;

public class EnterModuleCommand extends Command {

    public static final String MESSAGE_INFO = "Opening %s.";
    public static final String MESSAGE_OVERVIEW = "<Placeholder for overview>";
    public static final String MESSAGE_ERROR = "%s is an invalid module code.";

    private final String moduleCode;

    public EnterModuleCommand(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    @Override
    public void execute(ModuleList modules, Ui ui) throws DukeException {
        requireNonNull(modules);
        if (!modules.getModules().contains(moduleCode)) {
            throw new InvalidModuleCodeException(String.format(MESSAGE_ERROR, moduleCode));
        }
        ui.printMessage(String.format(MESSAGE_INFO, moduleCode));
        ModuleList.setSelectedModule(moduleCode);
        ui.printMessage(MESSAGE_OVERVIEW);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
