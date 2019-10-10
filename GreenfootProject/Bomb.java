import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bomb extends Objects
{
    public boolean lit = false;
    public int timeLeft = 300;
    private GreenfootImage imageUnlit;
    private GreenfootImage imageLit;
    Bomb(int ID) {
        super(ID);
        imageUnlit = cropImage("197.png");
        imageLit = cropImage("198.png");
    }
}
