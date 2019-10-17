import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HudCoin extends Actor
{
    HudCoin() {
        GreenfootImage image = new GreenfootImage ("hudCoin.png");
        image.scale((Options.blockSize),(Options.blockSize));
        setImage(image);
    } 
    public void act() 
    {
        if (getWorld() instanceof LevelSelector) {
            setLocation(Options.blockSize - (int) (Options.blockSize * 0.5), (int) (Options.blockSize * 0.5));
        } else {
            setLocation(Options.blockSize - (int) (Options.blockSize * 0.5), (int) (Options.blockSize * 1.25));
        }
    }    
}
