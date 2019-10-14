import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;

public class MenuExit extends ActorsMenu
{
    MenuExit() {
        GreenfootImage image = new GreenfootImage("Exit.png");
        image.scale((Options.blockSize) * 4,(Options.blockSize) * 2);
        setImage(image);
        normalWidth = image.getWidth();
        normalHeight = image.getHeight();
    }
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            //quit game here
        }
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            List objects = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), getClass());
            boolean overObjectCheck = false;
            for (Object object : objects)
            {
                if (object == this)
                {
                    overObjectCheck = true;
                    if (!overObject) {
                        getImage().scale(normalWidth + normalWidth / 10
                            , normalHeight + normalHeight / 10);
                        overObject = true;
                    }
                }
            }
            if (!overObjectCheck) {
                overObject = false;
                getImage().scale(normalWidth, normalHeight);
            }
        }
    }    
}
