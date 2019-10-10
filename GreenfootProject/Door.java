import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Door extends Objects
{
    public boolean locked;
    Door(int ID) {
        super(ID);
        if (ID == 223) locked = false;
        if (ID == 221) locked = true;
    }
}
