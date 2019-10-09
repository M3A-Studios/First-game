import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Blocks extends Actor
{  
    Blocks(int ID) {
        GreenfootImage image = new GreenfootImage (ID + ".png");
        image.scale((Options.blockSize),(Options.blockSize));
        setImage(image);
    }
}
