import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Physics
{
    public int health = 6;
    public int introFrame = 0;
    public boolean dead = false;
    public int deathAnimationFrame = 0;
    
    public GreenfootImage imageFront;
    public GreenfootImage imageDuck;
    public GreenfootImage imageStand;
    public GreenfootImage imageJump;
    public GreenfootImage imageWalk1;
    public GreenfootImage imageWalk2;
    public GreenfootImage imageSwim1;
    public GreenfootImage imageSwim2;
    public GreenfootImage imageClimb1;
    public GreenfootImage imageClimb2;
    public GreenfootImage imageHit;
    public GreenfootImage cropImage(String image) {
        GreenfootImage cutImage = new GreenfootImage (image);
        cutImage.scale(Options.blockSize,Options.blockSize);
        return cutImage;
    }
    Player() {
        setGravity(1);
        
        setBarrierClasses(new Class[]{Solid.class});
        setPlatformClasses(new Class[]{Platform.class});
        setSlopeLeftClasses(new Class[]{SlopeLeft.class});
        setSlopeRightClasses(new Class[]{SlopeRight.class});
        setDamagingClasses(new Class[]{HalfSaw.class});
    }
    public void act() 
    {
    }     
}
