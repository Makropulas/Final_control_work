package Data;

import java.util.ArrayList;

public class Commands {
    private ArrayList<String> commands;

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }
}
