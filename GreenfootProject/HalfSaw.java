import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.image.*;
import java.awt.*;

public class HalfSaw extends Mover
{
    private int movementRange = 4;
    private int startingX;
    private boolean movingRight = true;
    public int speed = 5;
    private boolean started;
    private int frames = 0;
    
    private GreenfootImage image1 = new GreenfootImage ("39.png");
    private GreenfootImage image2 = new GreenfootImage ("40.png");
    private GreenfootImage currentImage;
    private GreenfootImage CutImage(String imageLink) {
        GreenfootImage image = new GreenfootImage(imageLink);
        image.scale((Options.widthSize),(Options.heightSize));
        
        BufferedImage bufImage = image.getAwtImage();
        bufImage = bufImage.getSubimage(0,Options.heightSize/2,Options.widthSize,Options.heightSize/2);
        GreenfootImage gImage = new GreenfootImage(bufImage.getWidth(), bufImage.getHeight());
        BufferedImage gBufImg = gImage.getAwtImage();
        Graphics2D graphics = (Graphics2D)gBufImg.getGraphics();
        graphics.drawImage(bufImage, null, 0, 0);
        return(gImage);
    }
    HalfSaw() {
        image1 = CutImage("39.png");
        image2 = CutImage("40.png");
        
        setImage(image1);
        
        setMovementSpeed(speed);
        setBlockingClasses(new Class[]{Solid.class, SlopeLeft.class, SlopeRight.class});
    }
    public void act() 
    {
        if (!started) {
            setLocation(getX(), getY() + Options.heightSize / 4 - 1);
            this.startingX = this.getX();
            started = true;
        }
        
        if (currentImage == image1) {
            setImage(image2);
            currentImage = image2;
        } else {
            setImage(image1);
            currentImage = image1;
        }
        if (movingRight && (getX() + Globals.currentX) < (startingX + speed + movementRange * Options.widthSize) && canMoveRight()) {
            moveRight();
        } else {
            movingRight = false;
            if (canMoveLeft() && (getX() + Globals.currentX - speed) > (startingX - movementRange * Options.widthSize)) {
                moveLeft();
            } else {
                movingRight = true;
            }
        }    
    } 
}
