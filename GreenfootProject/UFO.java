import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

public class UFO extends ActorsMenu
{
    private int startingY;
    private boolean started = false;
    private GreenfootImage image;
    Random random = new Random();
    
    private boolean movingUp = random.nextBoolean();
    UFO (String color) {
        image = new GreenfootImage("ship" + color + "Manned.png");
        setImage(image);
    }
    public void act() 
    {
        if (!started) {
            startingY = getY();
            started = true;
        } else {
            if (getY() <= (startingY + Options.blockSize) && !movingUp) {
                setLocation(getX(), getY() + 1);
            } else if (getY() > (startingY + Options.blockSize)) {
                movingUp = true;
            }
            if (getY() >= (startingY - Options.blockSize) && movingUp) {
                setLocation(getX(), getY() - 1);
            } else {
                movingUp = false;
            } 
        }
    }    
}
