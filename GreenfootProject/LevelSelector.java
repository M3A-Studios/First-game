import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelSelector extends World
{
    int dsx = 0;
    int dsy = 0;
    protected static int levelWidth; //tiles wide
    protected static int levelHeight; //tiles high
    Scroller scroller; // the object that performs the scrolling
    Actor scrollActor; // an actor to stay in view*
    public static int level;
    private String background;

    LevelSelector() {
        this(0);
    }
    LevelSelector(int lvl)
    {    
        super(Options.screenWidth, Options.screenHeight, 1); 
        
        background = "test.png";
        
        level = lvl;
        LevelNode levelNode = new LevelNode("Tutorial", 0);
        addObject(levelNode,920,550);
        LevelNode levelNode2 = new LevelNode("Lava", 1);
        addObject(levelNode2,955,227);
        LevelNode levelNode3 = new LevelNode("Lava", 2);
        addObject(levelNode3,865,0);
        
        initiateScroll(background, 0, 0);

    }
    public void initiateScroll(String backgroundImage, int x, int y) {
        GreenfootImage bg = new GreenfootImage(backgroundImage);
        bg.scale(2 * Options.screenWidth, 5 * Options.screenHeight);

        scroller = new Scroller(this, bg, 2 * Options.screenWidth, 5 * Options.screenHeight);
        scrollActor = new SelectorCharacter("green");

        scroller.scroll(getMapX(level), getMapY(level));

        addObject(scrollActor, getMapX(level) % Options.screenWidth, getMapY(level) % Options.screenHeight);
        System.out.println(getMapX(level) + ", " + getMapY(level));
    } 
    public static int getMapX(int level) {
        if (level == 0) return scaledWidth (2100.0);
        else if (level == 1) return scaledWidth(2200.0);
        else if (level == 2) return scaledWidth(2300.0);
        else if (level == 3) return scaledWidth(2400.0);
        else return Options.screenWidth/2;
    } 
    public static int getMapY(int level) {
        if (level == 0) return scaledHeight(3540.0);
        else if (level == 1) return scaledHeight(3540.0); 
        else if (level == 2) return scaledHeight(3540.0); 
        else if (level == 3) return scaledHeight(3540.0); 
        else return Options.screenHeight/2;
    } 
    public static int scaledWidth(double toScale) {
        return (int) ((toScale / 1920) * Options.screenWidth);
    }
    public static int scaledHeight(double toScale) {
        return (int) ((toScale / 1080) * Options.screenHeight);
    }
    public void scroll() {
        scroller.scroll(dsx, dsy);
    }  
}
