package seedu.duke.commands;

import seedu.duke.exceptions.CommandException;
import seedu.duke.exceptions.DukeException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

public abstract class Command {

    public abstract void execute(ModuleList modules, UI ui) throws CommandException;
    public abstract boolean isExit();

}
