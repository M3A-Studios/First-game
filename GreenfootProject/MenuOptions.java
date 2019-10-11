import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MenuOptions extends ActorsMenu
{
    MenuOptions() {
        GreenfootImage image = getImage();
        image.scale((Options.blockSize) * 6,(Options.blockSize) * 2);
        setImage(image);
    } 
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            //call options here
        }
    }
}
