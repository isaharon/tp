package seedu.duke.commands;

import seedu.duke.common.Commands;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

public class HelpCommand extends Command {

    public static final String HELP_MESSAGE = getHelpMessage();

    @Override
    public void execute(ModuleList modules, UI ui) {
        System.out.println(getHelpMessage());
    }

    @Override
    public boolean isExit() {
        return false;
    }

    private static String getHelpMessage() {
        String commandAndDescription = "%-8s - %s";
        String helpMessage = "";
        for (Commands commands : Commands.values()) {
            helpMessage += String.format(commandAndDescription, commands.getWord(), commands.getDescription());
            helpMessage += "\n";
        }
        return helpMessage;
    }
}
