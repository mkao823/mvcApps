package minefield;

import mvc.*;

import java.awt.*;

public class MinefieldView extends View {

    public MinefieldView(Model mine) {
        super(mine);
    }

    /*public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        Model mod = (Minefield)model;
        Minefield shape = new Minefield(mod);
        shape.draw((Graphics2D) gc);
        gc.setColor(oldColor);
    }*/
}
