import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Levels extends World
{
    protected static int levelWidth; //tiles wide
    protected static int levelHeight; //tiles high
    protected static String mapString; //world layout string
    protected static int[] world; //world layout string
    
    protected static int width; //level rendering tiles per row
    protected static int height; //level rendering rows
    
    protected static void getWorldMap (String level) {
        //reset the level layout to blank
        levelWidth = 0;
        levelHeight = 0;
        mapString = "";
        
        //read the level layout
        File readFile = new File("levelLayouts/" + level + ".tmx"); //set what file to read
        Scanner dataReader = null; //scanner for the file
        
        try
        {
            dataReader = new Scanner(readFile); //try to read the file
        }
        catch(IOException e) //error report
        {
            System.out.println("File Read error" + e); //show error
        }
        while(dataReader.hasNext()) //while there's a next line
        {
           String line = dataReader.next(); //line is next line
           if (line.contains("width=\"") && !line.contains("tile")) { //check for width
               line = line.replaceAll("[^\\d]",""); //replace all non numbers with nothing
               levelWidth = Integer.parseInt(line); //set levelWidth
           }
           if (line.contains("height=\"") && !line.contains("tile")) { //check for height
               line = line.replaceAll("[^\\d]",""); //replace all non numbers with nothing
               levelHeight = Integer.parseInt(line); //set levelHeight
           }
           if (line.contains(",")) { //check if line is part of the map
                mapString = mapString += line; //add new line to total map
           }
        }
        String[] integerStrings = mapString.split(","); //split values by ,
        world = new int[integerStrings.length]; //make an array with space for every slot 
        for (int i = 0; i < world.length; i++){ 
            world[i] = Integer.parseInt(integerStrings[i]); //turn array into int array
        }
        
        Globals.worldHeight = Options.heightSize * levelHeight; //set worldHeight in tiles
        Globals.worldWidth = Options.widthSize * levelWidth; //set worldWidth in tiles
        dataReader.close(); //remove the scanner. we don't need it anymore
    }
    protected void renderWorld() {
        //reset starting point for map creation
        width = -1;
        height = 0;
        System.out.println("\nLevelWidth: " + levelWidth + ", LevelHeight " + levelHeight + ",\nTotal needed entries " + (levelWidth * levelHeight) + ", Total gotten entries: " + world.length + "\n");
        for (int i = 0; i < world.length; i++) {
            width += 1;
            //after width reaches levelWidth it goes to 0 and adds 1 to height. goes to next line
            if (width >= levelWidth) {
                height += 1;
                width = 0;
            }
            if (height > levelHeight) {
                System.out.println("More rows than the level has rows to put stuff in");
                break;
            }
            /*Below is setting the objects into the world
             * 
             *Gonna only write this once because it's all the same thing
             *
             *if (super.check(Globals.nonSolids, world[i] - 1)) {}
             *checks with method of the super class (Levels)
             *if the ID of the block (world[i] - 1) is part of Globals.nonSolids array
             *This array can be found in the Globals Class. obviously. returns true or false
             *
             *
             *addObject(nextBlock,width * widthsize + 1/2 widthsize,height * heightsize + 1/2 heighsize);
             *adds new block at the next cords.
             *
             */
            if (check(Globals.platforms, world[i] - 1)) {
                Platform nextBlock = new Platform(world[i] - 1);
                addObject(nextBlock,width*Options.widthSize + Options.widthSize/2,
                height*Options.heightSize);
            } else if (check(Globals.nonSolids, world[i] - 1)) {
                NonSolid nextBlock = new NonSolid(world[i] - 1);
                addObject(nextBlock,width*Options.widthSize + Options.widthSize/2,
            height*Options.heightSize + Options.heightSize/2);
            } else if (world[i] != 0) { //if the block isn't ground
                Solid nextBlock = new Solid(world[i] - 1);
                addObject(nextBlock,width*Options.widthSize + Options.widthSize/2,
            height*Options.heightSize + Options.heightSize/2);
            }
        }
    }
    public static boolean check(Integer[] arr, int toCheckValue) {
        boolean test
                = Arrays.asList(arr)
                .contains(toCheckValue);
        return test;
    }
    public Levels() {
        super(Options.screenWidth, Options.screenHeight, 1, false);
    }
}
