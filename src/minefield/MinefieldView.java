package minefield;
import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

// my MineField contains an n x n array of patches


public class MinefieldView extends View {

    private Cell cells[][];
    public MinefieldView(Minefield m) {
        super(m);
        init(m);
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
                cells[row][col].patch = m.getPatches(row, col);
                cells[row][col].setBorder(BorderFactory.createLineBorder(Color.black));
                //gc.drawRect(20 * row, 20 * col, 20, 20);
                if(cells[row][col].patch.occupied){
                    cells[row][col].setBackground(Color.blue);
                    cells[row][col].setBorder(BorderFactory.createLineBorder(Color.blue));
                }
                if(cells[row][col].patch.goal){
                    cells[row][col].setBackground(Color.green);
                    cells[row][col].setBorder(BorderFactory.createLineBorder(Color.green));
                }
            }
        }
        gc.setColor(oldColor);
    }
    public void init(Minefield m){
        int dim = m.getHeight();
        cells = new Cell[dim][dim];
        setLayout(new GridLayout(dim, dim));
        for(int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                // create and initialize cells here, use
                cells[row][col] = new Cell();
                cells[row][col].patch = m.getPatches(row, col);
                cells[row][col].setBorder(BorderFactory.createLineBorder(Color.black));
                if(cells[row][col].patch.occupied){
                    cells[row][col].setBackground(Color.blue);
                    cells[row][col].setBorder(BorderFactory.createLineBorder(Color.blue));
                }
                if(cells[row][col].patch.goal){
                    cells[row][col].setBackground(Color.green);
                    cells[row][col].setBorder(BorderFactory.createLineBorder(Color.green));
                }
                if(cells[row][col].patch.mine){
                    cells[row][col].setBackground(Color.red);
                    cells[row][col].setBorder(BorderFactory.createLineBorder(Color.red));
                }
                add(cells[row][col]);
            }
        }
    }
    class Cell extends JLabel {
        Patch patch;

        public void setPatch(Patch patches) {
            this.patch = patches;
        }
    }
}