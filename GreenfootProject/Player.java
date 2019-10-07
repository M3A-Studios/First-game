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
    private int sinceLastAnimation;
    boolean started;
    boolean dead = false;
    int intro;
    Player() {
        /* Gets the image
         * Sets the size to current size devided by scalingFactor in Options class
         * Sets the image to the new resized image*/ 
        GreenfootImage image = getImage();
        
        image.scale((image.getWidth() / Options.scalingFactor),(image.getHeight() / Options.scalingFactor));
        setImage(image);
        imageStart = image;
        image1.scale((image1.getWidth() / Options.scalingFactor),(image1.getHeight() / Options.scalingFactor));
        image2.scale((image2.getWidth() / Options.scalingFactor),(image2.getHeight() / Options.scalingFactor));
        
        setMovementSpeed(5); //set the player's WALKING speed
        setGravity(1); //set gravity of this player
        
        //set what classes the player can't move through
        setBlockingClasses(new Class[]{Solid.class});
        setPlatformClasses(new Class[]{Platform.class});
        setSlopeLeftClasses(new Class[]{SlopeLeft.class});
        setSlopeRightClasses(new Class[]{SlopeRight.class});
        setDyingClasses(new Class[]{HalfSaw.class});
        
        started = false;
        
        setLocation(0, 1354);
        
        //String world = getWorld().getClass().getName();
        //System.out.println(world);
    }
    public void act() 
    {
        doGravity();
        if (!started) {
            if (intro == 0) { 
                setLocation(-32, getY());
            }
            if (intro % 15 == 0) {
                if (getImage() == image1) {
                    setImage(image2);
                } else {
                    setImage(image1);
                }
            }
            if (intro >= 200) {
                setImage(imageStart);
                started = true;
            } else {
                setLocation(getX() + 1, getY());
            }
            intro += 1;
        } else if (!dead) {
            if(Greenfoot.isKeyDown(Options.leftButtonPlayer1))
            {
                moveLeft();
            } 
            if(Greenfoot.isKeyDown(Options.rightButtonPlayer1))
            {
                moveRight();
            }
            if(Greenfoot.isKeyDown(Options.jumpButtonPlayer1) ||  Greenfoot.isKeyDown(Options.jumpButton2Player1)) // Only jump if on ground
            {
                if (onSlope()) {
                    setLocation(getX(), getY() - 1);
                    jump(20); // jump()'s parameter should be rather large
                } else if (onGround()) {
                    jump(20);
                } 
            }
            if (atBottom()) {
                dead = true;
            } else {
            dead = died(); //set dead state to the died check. so true or false
            }
        } else {
            System.out.println("Play death animation btw");
        }
    } 
}
