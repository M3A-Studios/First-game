import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;
public class MenuNewGame extends ActorsMenu
{
    MenuNewGame() {
        GreenfootImage image = new GreenfootImage("NewGame.png");
        image.scale((Options.blockSize) * 8,(Options.blockSize) * 2);
        setImage(image);
        
        normalWidth = image.getWidth();
        normalHeight = image.getHeight();
    }
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            Saver.createSave();
            Globals.level = 0;
            Globals.lastLevel = 0;
            Globals.selectedLevel = 0;
            Globals.coins = 0;
            
            Greenfoot.setWorld(new Tutorial());
        }
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null && !ActorsOptions.optionsOpen) {
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
