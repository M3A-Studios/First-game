import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tutorial extends Levels
{
    public static int startHeight = 4; //tiles from bottom for animation of player entering the level
    private String backgroundImage = "background.png"; //backgroud image
    
    Scroller scroller; // the object that performs the scrolling
    Actor scrollActor; // an actor to stay in view
    
    public Tutorial() //constructor. basically makes the level when level gets loaded
    {    
        super(); //make the world (screen)
        
        getWorldMap(getClass().getName()); //Reading the world file to render later. because I like to overdo stuff
        renderWorld(); //renders the actual world objects like blocks and enemies
        Globals.startingHeight = startHeight; //set the start height to this level's startheight
        
        GreenfootImage bg = new GreenfootImage(backgroundImage); // creates an image to scroll (adjust as needed)
        
        scroller = new Scroller(this, bg, Globals.worldWidth, Globals.worldHeight); // creates the Scroller object for this world, with background bg of image width and height in Globals.
        scrollActor = new Player(); //Creates the object to focus on
        addObject(scrollActor, 0, 0);
        
        //Player player = new Player();
        //addObject(player, 0, 0);//starting location of the main character
        
        scroll(scrollActor, scroller); //Update to where the scrollactor is
        scrollActor.setLocation(-40, Globals.worldHeight - (Globals.startingHeight * Options.heightSize - Options.heightSize / 4)); //move scrollactor to the right spot
        //player.setLocation(-40, Globals.worldHeight - (Globals.startingHeight * Options.heightSize - Options.heightSize / 4));
        scroll(scrollActor, scroller); //update again to be in the proper place
    } 
    public void act() //scroll the map every frame
    {
        scroll(scrollActor, scroller);
    }
}
