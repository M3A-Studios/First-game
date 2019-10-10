import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Enemy extends Physics

{
    protected double speed;
    protected int movementRange;
    protected boolean movingRight;
    protected int startingX;
    protected int startingY;
    protected GreenfootImage animation1;
    protected GreenfootImage animation2;
    protected GreenfootImage deathImage;
    protected GreenfootImage currentImage;
    protected boolean dead = false;
    protected int deathAnimationFrame = 0;
    public void act() 
    {  
    }      
}
