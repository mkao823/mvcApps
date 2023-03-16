package minefield;

import mvc.*;

public class MoveCommand extends Command {
    public MoveCommand(Model model) {
        super(model);
    }

    public void execute() {
        Stoplight light = (Stoplight)model;
        light.change();
    }
}
