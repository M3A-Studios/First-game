import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Player
{
    boolean started = false;
    String color = "blue";
    Player2() {
        imageFront = cropImage(color + "Front.png");
        imageDuck = cropImage(color + "Duck.png");
        imageStand = cropImage(color + "Stand.png");
        imageJump = cropImage(color + "Jump.png");
        imageWalk1 = cropImage(color + "Walk1.png");
        imageWalk2 = cropImage(color + "Walk2.png");
        imageSwim1 = cropImage(color + "Swim1.png");
        imageSwim2 = cropImage(color + "Swim2.png");
        imageClimb1 = cropImage(color + "Climb1.png");
        imageClimb2 = cropImage(color + "Climb2.png");
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
                if (getImage() == imageWalk1) {
                    setImage(imageWalk2);
                } else {
                    setImage(imageWalk1);
                }
            }
            if (introFrame >= 100) {
                setImage(imageStand);
                started = true;
            } else {
                moveRight(2.0);
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
