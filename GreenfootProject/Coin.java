import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Coin extends Objects
{
    public int value;
    Coin(int ID, int value) {
        super(ID);
        if (ID == 173) value = 25;
        if (ID == 175) value = 50;
        if (ID == 174) value = 100;
    }
}
