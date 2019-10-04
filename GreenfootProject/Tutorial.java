import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Tutorial extends Levels
{
    public static int startHeight = 4; //tiles from bottom
    private String backgroundLink = "background.png"; //backgroud image
    
    //Automatic stuff
    private static int levelWidth; //tiles wide
    private static int levelHeight; //tiles high
    
    private String mapString = ""; //world layout string
    private int[] world; //world layout string

    private static int width; //level rendering tiles per row
    private static int height; //level rendering rows
    
    public static int wide = Options.screenWidth; // world width (viewport)
    public static int high = Options.screenHeight; // world height (viewport)
    Scroller scroller; // the object that performs the scrolling
    Actor scrollActor; // an actor to stay in view
    public Tutorial()
    {    
        super(wide, high, 1, false); 
        Globals.startingHeight = startHeight;
        //Reading the world file. because I like to overdo stuff
        File readFile = new File("levelLayouts/" + getClass().getName() + ".tmx"); //set what file to read
        Scanner dataReader = null; //scanner for the file
        
        try
        {
            dataReader = new Scanner(readFile); //try to read the file
        }
        catch(IOException e) //error report
        {
            System.out.println("File Read error" + e); //show error
            return;
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
        
        

        //World layout
        width = -1;
        height = 0;
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
            if (super.check(Globals.platforms, world[i] - 1)) {
                Platform nextBlock = new Platform(world[i] - 1);
                addObject(nextBlock,width*Options.widthSize + Options.widthSize/2,
                height*Options.heightSize);
            } else if (world[i] - 1 == 230 || world[i] - 1== 231) {
                Lava nextBlock = new Lava(world[i] - 1);
                addObject(nextBlock,width*Options.widthSize + Options.widthSize/2,
            height*Options.heightSize  + Options.heightSize/2);// + Options.heightSize/2);
            } else if (super.check(Globals.nonSolids, world[i] - 1)) {
                NonSolid nextBlock = new NonSolid(world[i] - 1);
                addObject(nextBlock,width*Options.widthSize + Options.widthSize/2,
            height*Options.heightSize + Options.heightSize/2);
            } else if (world[i] != 0) { //if the block isn't ground
                Solid nextBlock = new Solid(world[i] - 1);
                addObject(nextBlock,width*Options.widthSize + Options.widthSize/2,
            height*Options.heightSize + Options.heightSize/2);
            }
        }
        prepare();
        GreenfootImage bg = new GreenfootImage(backgroundLink); // creates an image to scroll (adjust as needed)
        int bgWide = Globals.worldWidth; // scrolling image width
        int bgHigh = Globals.worldHeight; // scrolling image height
        
        scroller = new Scroller(this, bg, bgWide, bgHigh); // creates the Scroller object
        scrollActor = new Player(); //Creates the object to focus on
        //Player player = new Player();
        addObject(scrollActor, 0, 0);
        //addObject(player, 300, 600);//starting location of the main character
        
        scroll(); //Update to where the player is
    } 
    private void prepare() {
    }
    public void act() //scroll the map every frame
    {
        scroll();
    }
    private void scroll()
    {
        /* roaming limits of actor (doesn't move camera till outside of this
         * all set to be 3/8th of the screen, so the 1/4th of the screen thats the middle is fine */
        int loX = wide/16*7; //Barrier left of center to move
        int hiX = wide-wide/16*7; //Barrier right of center to move
        int loY = high/8*2; //Barrier from the ceiling to move
        int hiY = high-high/8*3; //Barrier from the bottom to move
        // determine offsets and scroll
        int dsx = 0, dsy = 0;
        if (scrollActor.getX() < loX) dsx = scrollActor.getX()-loX;
        if (scrollActor.getX() > hiX) dsx = scrollActor.getX()-hiX;
        if (scrollActor.getY() < loY) dsy = scrollActor.getY()-loY;
        if (scrollActor.getY() > hiY) dsy = scrollActor.getY()-hiY;
        scroller.scroll(dsx, dsy); //do the scrolling
        Globals.currentX = scroller.getScrolledX(); //return how much the screen has scrolled for future usage
    }
}
