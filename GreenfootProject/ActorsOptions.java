 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ActorsOptions extends Actor
{
    public static boolean optionsOpen = false;
    public void act() 
    {
        if (!optionsOpen) { 
            setLocation(Options.screenWidth * 2, Options.screenHeight * 2);//just setting it far out of frame
            getWorld().showText("", Options.screenWidth / 10 * 5,Options.screenHeight / 10 * 1);
            getWorld().showText("", Options.screenWidth / 10 * 2,Options.screenHeight / 20 * 3);
            getWorld().showText("", Options.screenWidth / 10 * 2,Options.screenHeight / 10 * 2);
            getWorld().showText("", Options.screenWidth / 10 * 4,Options.screenHeight / 10 * 2);
            getWorld().showText("", Options.screenWidth / 10 * 6,Options.screenHeight / 10 * 2);
            getWorld().showText("", Options.screenWidth / 10 * 8,Options.screenHeight / 10 * 2);
            getWorld().showText("", Options.screenWidth / 10 * 6,Options.screenHeight / 10 * 3);
            getWorld().showText("", Options.screenWidth / 10 * 6,Options.screenHeight / 10 * 4);
            getWorld().showText("", Options.screenWidth / 10 * 6,Options.screenHeight / 10 * 5);
            getWorld().showText("", Options.screenWidth / 10 * 6,Options.screenHeight / 10 * 6);
            getWorld().showText("", Options.screenWidth / 10 * 6,Options.screenHeight / 10 * 7);
            getWorld().showText("", Options.screenWidth / 10 * 2,Options.screenHeight / 10 * 8);
        } else {
            setLocation(Options.screenWidth / 2, Options.screenHeight / 2);
            getWorld().showText("Help and Options", Options.screenWidth / 10 * 5,Options.screenHeight / 10 * 1);
            getWorld().showText("Controls", Options.screenWidth / 10 * 2,Options.screenHeight / 20 * 3);
            getWorld().showText("Player 1", Options.screenWidth / 10 * 2,Options.screenHeight / 10 * 2);
            getWorld().showText("Player 2", Options.screenWidth / 10 * 4,Options.screenHeight / 10 * 2);
            getWorld().showText("Function", Options.screenWidth / 10 * 6,Options.screenHeight / 10 * 2);
            getWorld().showText("Volume", Options.screenWidth / 10 * 8,Options.screenHeight / 10 * 2);
            getWorld().showText("Jump / Climb", Options.screenWidth / 10 * 6,Options.screenHeight / 10 * 3);
            getWorld().showText("Duck / Slide", Options.screenWidth / 10 * 6,Options.screenHeight / 10 * 4);
            getWorld().showText("Move Right", Options.screenWidth / 10 * 6,Options.screenHeight / 10 * 5);
            getWorld().showText("Move Left", Options.screenWidth / 10 * 6,Options.screenHeight / 10 * 6);
            getWorld().showText("Interact", Options.screenWidth / 10 * 6,Options.screenHeight / 10 * 7);
            getWorld().showText("Screen Size:", Options.screenWidth / 10 * 2,Options.screenHeight / 10 * 8);
        }
    }
    ActorsOptions() {
        GreenfootImage menu = new GreenfootImage ("Black.png");
        menu.scale(Options.screenWidth / 10 * 9,Options.screenHeight / 10 * 9);
        menu.setTransparency(200);
        setImage(menu);
    }
    public static void optionsMenu() {
        if (!ActorsOptions.optionsOpen) {
            ActorsOptions.optionsOpen = true;
        } else {
            ActorsOptions.optionsOpen = false;
        } 
    } 
}
