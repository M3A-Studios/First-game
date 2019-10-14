import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;

public class MenuOptions extends ActorsOptions
{
    private boolean overObject = false;
    private int normalWidth;
    private int normalHeight;
    MenuOptions() {
        GreenfootImage image = new GreenfootImage("Options.png");
        image.scale((Options.blockSize) * 6,(Options.blockSize) * 2);
        setImage(image);
        normalWidth = image.getWidth();
        normalHeight = image.getHeight();
    } 
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            optionsMenu();
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
