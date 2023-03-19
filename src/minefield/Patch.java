package minefield;

public class Patch {
    public boolean mine = false;//initial patch is not a mine, will be set randomly in Minefield class
    public boolean goal = false; //initial value of goal is false, should only have 1 goal in the 2d array
    public int surroundingMines = 0; //number of mines around this patch
    public boolean occupied = false; //set to true when player moves to the patch(Minefield.move(Heading))
    
    public void increamentSurMines() {
        surroundingMines++;
    }
}
