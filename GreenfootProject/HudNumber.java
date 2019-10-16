import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HudNumber extends Actor
{
    public String purpose;
    public int position;
    GreenfootImage number;
    public int value = 0;
    HudNumber(String purpose, int position) {
        this.purpose = purpose;
        this.position = position;
    }
    public void act() 
    {
        if (purpose == "coins") {
            if (getWorld() instanceof LevelSelector) {
                setLocation((Options.blockSize / 4 * 3 + (int) (Options.blockSize * 0.5 * position)), (Options.blockSize / 2));
            } else {
                setLocation((Options.blockSize / 4 * 3 + (int) (Options.blockSize * 0.5 * position)), (int) (Options.blockSize * 1.25));
            }
        }
        GreenfootImage image = new GreenfootImage ("hud" + value + ".png");
        image.scale((Options.blockSize),(Options.blockSize));
        setImage(image);
    }    
}
