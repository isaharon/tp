package seedu.duke.common;

public enum Commands {

    HELP("help", "Lists out all commands available when a module isn't selected."),
    EXIT("exit", "Exits the program."),
    OPEN("open", "Opens the specified module."),
    ADD("add", "Adds a new module with specified name."),
    DELETE("delete", "Deletes the specified module."),
    MODULES("modules", "Lists all modules.");

    private final String word;
    private final String description;

    Commands(String type, String description) {
        this.word = type;
        this.description = description;
    }

    public String getWord() {
        return word;
    }

    public String getDescription() {
        return description;
    }
}
