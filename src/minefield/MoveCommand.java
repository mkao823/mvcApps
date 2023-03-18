package minefield;

import mvc.*;

public class MoveCommand extends Command {
    Heading heading;
    public MoveCommand(Model model) {
        super(model);
    }

    public void execute() {
        Minefield minefield = (Minefield)model;
        //minefield.change();
    }
}
