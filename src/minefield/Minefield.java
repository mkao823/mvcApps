package minefield;

import mvc.*;

import java.util.Random;


public class Minefield extends Model {
    //Patches are mined randomly. I use a static variable to determine the percentage of mined patches:
    public static int percentMined = 5;
    private Patch[][] patches; //2d array of patches
    private int length = 20;
    private int height = 20;
    public Minefield(){
        patches = new Patch[length][height];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            for(int j = 0; j < height; j++) {
                patches[i][j] = new Patch();//creating patch at each location 0-19

            }
        }
    }
    public void move(Heading heading){

    }
}
