package minefield;

import mvc.*;

public class MoveCommand extends Command {
    Heading heading;
    public MoveCommand(Model model, Heading heading) {
        super(model);
        this.heading = heading;
    }

    public void execute() {
        Minefield minefield = (Minefield)model;
        //move throws exception, we need to handle exception when we call it
        try{
            minefield.move(heading);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        //minefield.change();
    }
}
