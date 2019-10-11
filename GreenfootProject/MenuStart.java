import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MenuStart extends ActorsMenu
{
    MenuStart() {
        GreenfootImage image = getImage();
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
