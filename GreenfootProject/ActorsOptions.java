 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ActorsOptions extends Actor
{
    public static boolean optionsOpen = false;
    public void act() 
    {
        if(Greenfoot.getKey() == "escape") {
            optionsMenu();
        } 
    }   
    public void optionsMenu() {
        if (!ActorsOptions.optionsOpen) {
            System.out.println("Open Options");
            ActorsOptions.optionsOpen = true;
        } else {
            System.out.println("Close Options");
            ActorsOptions.optionsOpen = false;
        } 
    }
}
