import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Blocks extends Actor
{  
    Blocks(int ID) {
        GreenfootImage image = new GreenfootImage (ID + ".png");
        image.scale((image.getWidth() / Options.scalingFactor),(image.getHeight() / Options.scalingFactor));
        setImage(image);
    }
}
