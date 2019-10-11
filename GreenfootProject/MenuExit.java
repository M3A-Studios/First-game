import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MenuExit extends ActorsMenu
{
    MenuExit() {
        GreenfootImage image = getImage();
        image.scale((Options.blockSize) * 4,(Options.blockSize) * 2);
        setImage(image);
    }
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            //quit game here
        }
    }    
}
