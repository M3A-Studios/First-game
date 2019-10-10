import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Objects
{
    public boolean activated = false;
    public GreenfootImage imageInactive;
    public GreenfootImage imageActive;
    Button(int ID) {
        super(ID);
        imageInactive = cropImage(ID + ".png");
        imageActive = cropImage((ID + 1) + ".png");
    }
}
