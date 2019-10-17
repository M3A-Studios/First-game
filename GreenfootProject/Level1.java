import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level1 extends Levels
{
    public static int startHeight = 4; //tiles from bottom for animation of player entering the level
    private String backgroundImage = "background.png"; //backgroud image
    
    public Level1() //constructor. basically makes the level when level gets loaded
    {    
        super(); //make the world (screen)
        Globals.backgroundImage = backgroundImage;
        Globals.startingHeight = startHeight; //set the start height to this level's startheight
        
        getWorldMap(getClass().getName()); //Reading the world file to render later. because I like to overdo stuff
        renderWorld(); //renders the actual world objects like blocks and enemiess
        initiateScroll(Globals.backgroundImage, -40, Globals.worldHeight - (Globals.startingHeight * Options.blockSize - Options.blockSize / 4)); //make the camera and update it to x, y
        
    } 
    public void act() //scroll the map every frame
    {
        scroll();
    }
}
