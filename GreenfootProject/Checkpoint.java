import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Checkpoint extends Objects
{
    public boolean active = false;
    public GreenfootImage imageInactive;
    public GreenfootImage imageActive1;
    public GreenfootImage imageActive2;
    Checkpoint(int ID) {
        super(ID);
        imageInactive = cropImage(ID + ".png");
        imageActive1 = cropImage((ID - 2) + ".png");
        imageActive2 = cropImage((ID - 1) + ".png");
    }   
}
