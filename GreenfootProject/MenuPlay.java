import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MenuPlay extends ActorsMenu
{
    MenuPlay() {
        GreenfootImage image = new GreenfootImage("Play.png");
        image.scale((Options.blockSize) * 4,(Options.blockSize) * 2);
        setImage(image);
    }
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Tutorial());
        }
    }
}
