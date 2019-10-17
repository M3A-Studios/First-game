import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Resolution extends ActorsOptions
{
    GreenfootImage image;
    public void act() 
    {
        if (!ActorsOptions.optionsOpen) { 
            setLocation(Options.screenWidth * 2, Options.screenHeight * 2);//just setting it far out of frame
        } else {
            setLocation(Options.screenWidth / 10 * 4,Options.screenHeight / 10 * 8);
        }
        image = new GreenfootImage(Options.screenHeight + "p.png");
        image.scale((Options.blockSize) * 4,(Options.blockSize) * 1);
        setImage(image);
        if (Greenfoot.mouseClicked(this))
        {
            if (Options.screenHeight == 1080) Options.screenHeight = 720;
            else if (Options.screenHeight == 720) Options.screenHeight = 768;
            else if (Options.screenHeight == 768) Options.screenHeight = 900;
            else if (Options.screenHeight == 900) Options.screenHeight = 1080;
            Options.screenWidth = Options.screenHeight / 9 * 16;
            Options.blockSize = Options.screenWidth / 30;
            if (getWorld() instanceof Menu) Greenfoot.setWorld(new Menu());
            else if(getWorld() instanceof LevelSelector) Greenfoot.setWorld(new LevelSelector());
        } 
    }    
}
