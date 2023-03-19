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
        if(!minefield.getActive()) {
            Utilities.inform("The Game is Over");
            return;
        }
        //move throws exception, we need to handle exception when we call it
        try{
            minefield.move(heading);
        } catch (Exception e){
            Utilities.inform(e.getMessage());
            minefield.setActive(false);
        }
    }
}
