package minefield;
import mvc.*;

import javax.swing.*;
import java.awt.*;

// my MineField contains an n x n array of patches
class Cell extends JLabel {
    Patch patch;

}

public class MinefieldView extends View {

    private Cell cells[][];
    public MinefieldView(Minefield m) {
        super(m);
        setBackground(Color.GRAY);
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
                cells[row][col] = new Cell();
                cells[row][col].patch = m.getPatches(row, col);
                if(cells[row][col].patch.occupied){
                    if(row == m.getLocationX() && col == m.getLocationY()){
                        gc.setColor(Color.BLUE);
                        gc.drawRect(dim * row + 4, dim * col + 5, dim - 3, dim - 3);
                    }
                    else {
                        gc.setColor(Color.WHITE);
                        gc.drawRect(dim * row + 4, dim * col + 5, dim - 3, dim - 3);
                    }
                    gc.setColor(Color.BLACK);
                    gc.drawString("" + cells[row][col].patch.surroundingMines,
                            (dim * row) + dim / 3,(dim * (col + 1)));
                }
                else {
                    gc.setColor(Color.black);
                    gc.drawString("?", (dim * row) + dim / 3,(dim * (col + 1)) );
                }

                if(cells[row][col].patch.goal){
                    gc.setColor(Color.GREEN);
                }
            }
        }
        gc.setColor(oldColor);
    }

    public void init(Minefield m) {
        int dim = m.getHeight();
        cells = new Cell[dim][dim];
        setLayout(new GridLayout(dim, dim));
        for(int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col] = new Cell();
                cells[row][col].patch = m.getPatches(row, col);
                cells[row][col].setBorder(BorderFactory.createLineBorder(Color.black));
                if(cells[row][col].patch.goal) {
                    cells[row][col].setBackground((Color.GREEN));
                    cells[row][col].setBorder(BorderFactory.createLineBorder(Color.GREEN));
                }
                add(cells[row][col]);
            }
        }
    }
}
