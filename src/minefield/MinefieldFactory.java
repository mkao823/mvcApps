package minefield;


import mvc.*;

public class MinefieldFactory implements AppFactory{
    public Model makeModel() {
        return new Minefield();
    }

    public View makeView(Model m) {
        return new MinefieldView((Minefield)m);
    }

    public String[] getEditCommands() {
        return new String[] {"N", "S","E", "W","NE", "SE","NW", "SW", }; }

    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "N")
            return new MoveCommand(model, Heading.NORTH);
        else if(type == "S")
            return new MoveCommand(model, Heading.SOUTH);
        else if(type == "E")
            return new MoveCommand(model, Heading.EAST);
        else if(type == "W")
            return new MoveCommand(model, Heading.WEST);
        else if(type == "NE")
            return new MoveCommand(model, Heading.NORTHEAST);
        else if(type == "SE")
            return new MoveCommand(model, Heading.SOUTHEAST);
        else if(type == "NW")
            return new MoveCommand(model, Heading.NORTHWEST);
        else if(type == "SW")
            return new MoveCommand(model, Heading.SOUTHWEST);
        else
            return null;
    }

    public String getTitle() { return "Minefield"; }

    public String[] getHelp() {
        return new String[] {"click Change to cycle through colors"};
    }

    public String about() {
        return "Minefield version 1.0. Copyright 2023 by Cyberdellic Designs";
    }
}
