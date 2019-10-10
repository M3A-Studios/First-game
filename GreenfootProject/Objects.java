import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Objects extends Actor
{
    Objects (int ID) {
        GreenfootImage image = new GreenfootImage (ID + ".png");
        image.scale((Options.blockSize),(Options.blockSize));
        setImage(image);
    }
    public GreenfootImage cropImage(String image) {
        GreenfootImage cutImage = new GreenfootImage (image);
        cutImage.scale(Options.blockSize,Options.blockSize);
        return cutImage;
    }
}
