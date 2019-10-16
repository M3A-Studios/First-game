 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ActorsOptions extends Actor
{
    public static boolean optionsOpen = false;
    public void act() 
    {
        if (!optionsOpen) { 
            setLocation(Options.screenWidth * 2, Options.screenHeight * 2);//just setting it far out of frame
        } else {
            setLocation(Options.screenWidth / 2, Options.screenHeight / 2);
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
