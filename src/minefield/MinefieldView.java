package minefield;
import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

// my MineField contains an n x n array of patches
class Cell extends JLabel {
    Patch patch;

    public void setPatch(Patch patches) {
        this.patch = patches;
    }
}

public class MinefieldView extends View {

    private Cell cells[][];
    public MinefieldView(Minefield m) {
        super(m);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Minefield m = (Minefield) model;
        Color oldColor = gc.getColor();
        int dim = m.getHeight();
        cells = new Cell[dim][dim];
        setLayout(new GridLayout(dim, dim));
        for(int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                // create and initialize cells here, use
                cells[row][col] = new Cell();
                cells[row][col].setBorder(BorderFactory.createLineBorder(Color.black));
            }
        }
        gc.setColor(oldColor);
    }
}
