import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Mover
{
    private GreenfootImage imageStart;
    private GreenfootImage image1 = new GreenfootImage ("alienGreen_walk1.png");
    private GreenfootImage image2 = new GreenfootImage ("alienGreen_walk2.png");
    
    boolean started = false;
    boolean dead = false;
    private int deathAnimationFrame = 0;
    
    int health = 6;
    private int introFrame = 0;
    
    Player() {
        /* Gets the image
         * Sets the size to current size devided by scalingFactor in Options class
         * Sets the image to the new resized image*/ 
        GreenfootImage image = getImage();
        
        image.scale(Options.blockSize,Options.blockSize);
        setImage(image);
        imageStart = image;
        
        image1.scale(Options.blockSize,Options.blockSize);
        image2.scale(Options.blockSize,Options.blockSize);
        
        setGravity(1); //set gravity of this player
        
        //set what classes act like what for the player
        setBarrierClasses(new Class[]{Solid.class});
        setPlatformClasses(new Class[]{Platform.class});
        setSlopeLeftClasses(new Class[]{SlopeLeft.class});
        setSlopeRightClasses(new Class[]{SlopeRight.class});
        setDamagingClasses(new Class[]{HalfSaw.class}); //take damage on hit
    }
    
    public void act() 
    {
        if (!dead) setRelativeLocation(Globals.entityOffsetX,Globals.entityOffsetY);
        if (!started) {
            if (introFrame == 0) { 
                setNewLocation(-32.0, (Options.screenHeight - Options.screenHeight/8*2));
                setDoubleY(getY());
                setDoubleX(getX());
            }
            if (introFrame % 7 == 0) {
                if (getImage() == image1) {
                    setImage(image2);
                } else {
                    setImage(image1);
                }
            }
            if (introFrame >= 100) {
                setImage(imageStart);
                started = true;
            } else {
                setRelativeLocation(2.0,0);
            }
            introFrame += 1;
            doGravity();
        } else if (!dead) {
            doGravity();
            if(Greenfoot.isKeyDown(Options.leftButtonPlayer1))
            {
                moveLeft(5.0);
            } 
            if(Greenfoot.isKeyDown(Options.rightButtonPlayer1))
            {
                moveRight(5.0);
            }
            if(Greenfoot.isKeyDown(Options.jumpButtonPlayer1) ||  Greenfoot.isKeyDown(Options.jumpButton2Player1)) // Only jump if on ground
            {
                if (onSlope()) {
                    setNewLocation(getDoubleX(), getDoubleY() - 1.0);
                    jump(20); // jump()'s parameter should be rather large
                } else if (onGround()) {
                    jump(20);
                } 
            }
            if (atBottom()) {
                dead = true;
                health = 0;
            } else {
            dead = died(); //set dead state to the died check. so true or false
            }
        } else if (dead) {
            Globals.alive = false;
            if (deathAnimationFrame < 30) {
                setRelativeLocation(0,-(deathAnimationFrame / 3));
            } else if (deathAnimationFrame > 30 && deathAnimationFrame < 40) {
                setRelativeLocation(0,(deathAnimationFrame - 40));
            } else if (deathAnimationFrame > 40 && deathAnimationFrame < 50) {
                setRelativeLocation(0,(deathAnimationFrame - 40));
            } else {
                setRelativeLocation(0,(deathAnimationFrame / 5));
            }
            deathAnimationFrame += 1;
            if (getY() > Options.screenHeight + getImage().getHeight()) {
                dead = false;
                Globals.alive = true;
                if (getWorld() instanceof Tutorial) Greenfoot.setWorld(new Tutorial());
                else if (getWorld() instanceof Level1) Greenfoot.setWorld(new Level1());
            }
        }
    } 
}
