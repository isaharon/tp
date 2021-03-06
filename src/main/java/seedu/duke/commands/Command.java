package seedu.duke.commands;

import seedu.duke.exceptions.DukeException;
import seedu.duke.exceptions.DuplicateModuleCodeException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.Ui;

public abstract class Command {

    public abstract void execute(ModuleList modules, Ui ui) throws DukeException;
    public abstract boolean isExit();

}
