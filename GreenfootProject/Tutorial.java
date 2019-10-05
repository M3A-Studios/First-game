import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Tutorial extends Levels
{
    public static int startHeight = 4; //tiles from bottom for animation of player entering the level
    private String backgroundImage = "background.png"; //backgroud image
    
    Scroller scroller; // the object that performs the scrolling
    Actor scrollActor; // an actor to stay in view
    
    public Tutorial() //constructor. basically makes the level when level gets loaded
    {    
        super(); //make the world (screen)
        prepare(); //method greenfoot forces us to have but doesn't do anything.
        
        //Reading the world file to render later. because I like to overdo stuff
        super.getWorldMap(getClass().getName());
        //renders the actual world objects like blocks and enemies
        this.renderWorld();
        //set the start height to this level's startheight
        Globals.startingHeight = startHeight;
        
        GreenfootImage bg = new GreenfootImage(backgroundImage); // creates an image to scroll (adjust as needed)
        
        scroller = new Scroller(this, bg, Globals.worldWidth, Globals.worldHeight); // creates the Scroller object for this world, with background bg of image width and height in Globals.
        scrollActor = new Player(); //Creates the object to focus on
        //Player player = new Player();
        addObject(scrollActor, 0, 0);
        //addObject(player, 300, 600);//starting location of the main character
        
        scroll(); //Update to where the player is
        scrollActor.setLocation(-40, Globals.worldHeight - (Globals.startingHeight * Options.heightSize - Options.heightSize / 4));
        scroll();
    } 
    public void act() //scroll the map every frame
    {
        scroll();
    }
    private void scroll()
    {
        /* roaming limits of actor (doesn't move camera till outside of this)
         * all set to be 3/8th of the screen, so the 1/4th of the screen thats the middle is fine */
        int loX = Options.screenWidth/16*7; //Barrier left of center to move
        int hiX = Options.screenWidth-(Options.screenWidth/16*7); //Barrier right of center to move
        int loY = Options.screenHeight/8*2; //Barrier from the ceiling to move
        int hiY = Options.screenHeight-(Options.screenHeight/8*3); //Barrier from the bottom to move
        // determine offsets and scroll
        int dsx = 0, dsy = 0;
        if (scrollActor.getX() < loX) dsx = scrollActor.getX()-loX;
        if (scrollActor.getX() > hiX) dsx = scrollActor.getX()-hiX;
        if (scrollActor.getY() < loY) dsy = scrollActor.getY()-loY;
        if (scrollActor.getY() > hiY) dsy = scrollActor.getY()-hiY;
        scroller.scroll(dsx, dsy); //do the scrolling
        Globals.currentX = scroller.getScrolledX(); //return how much the screen has scrolled for future usage
    }
    private void prepare() {} //forced to have this by greenworld. but we don't use it
}
