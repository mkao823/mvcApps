package minefield;

import mvc.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Minefield extends Model {
    //Patches are mined randomly. I use a static variable to determine the percentage of mined patches:
    public static int percentMined = 5;
    private Patch[][] patches; //2d array of patches
    private int length = 20;
    private int height = 20;
    private Point location;
    private List<Point> path;
    public Minefield(){
        //Assign mines to 5% of patches
        //Create 2d array of patches width height of 20
        patches = new Patch[length][height];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            for(int j = 0; j < height; j++) {
                patches[i][j] = new Patch();//creating patch at each location 0-19
                if(random.nextInt(100) < percentMined){//random number between 0-99, if < 5, set as a mine
                    patches[i][j].mine = true;
                }
            }
        }
        //designate player location
        /*
        need to be able to show how many mines are around a player location
        need to make sure this is updated when we move
        add path to store previous locations Linkedlist
        set a goal on bottom right corner, make sure there is no mine on the goal
        mines are determined prior to this assignment so we can ensure the goal is not a mine
         */
        location = new Point(0, 0);
        path = new LinkedList<Point>();
        path.add(location);
        patches[length - 1][height - 1].goal = true;
        patches[length - 1][height - 1].mine = false;

    }
    public void move(Heading heading) throws Exception{
        //we are bit using canvas but our actual location in 2darray, so don't need to change y direction (up->down)
        int xValue = getLocationX();
        int yValue = getLocationY();
        if(heading == Heading.NORTH)
            yValue++;
        else if(heading == Heading.SOUTH)
            yValue--;
        else if(heading == Heading.EAST)
            xValue++;
        else if(heading == Heading.WEST)
            xValue--;
        else if(heading == Heading.NORTHEAST){
            xValue++;
            yValue++;}
        else if(heading == Heading.NORTHWEST){
            xValue-- ;
            yValue++;}
        else if(heading == Heading.SOUTHEAST){
            xValue++;
            yValue--;}
        else if(heading == Heading.SOUTHWEST){
            xValue--;
            yValue--;}
        //throw exceptions for boundary
        if (xValue < 0 || yValue < 0 || xValue >= length || yValue >= height){
            throw new Exception("You have reached the boundary");
        }
        if (patches[xValue][yValue].mine){
            throw new Exception("You have hit a mine!");
        }
        if (patches[xValue][yValue].goal){
            throw new Exception("You win!");
        }
        //after checking for exceptions, store changes
        //change original value of occupied patch to false, set location to new xValue,yValue
        //set occupied of new location to true
        patches[getLocationX()][getLocationY()].occupied = false;
        location = new Point(xValue, yValue);
        path.add(location);
        patches[xValue][yValue].occupied = true;

    }
    public Patch getPatches(int x, int y) {
        return patches[x][y];
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getLocationX() {
        return location.getX();
    }

    public int getLocationY(){
        return location.getY();
    }

    public List<Point> getPath() {
        return path;
    }
}
