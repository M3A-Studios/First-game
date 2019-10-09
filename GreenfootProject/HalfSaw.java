import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.image.*;
import java.awt.*;

public class HalfSaw extends Mover
{
    private int movementRange = 4;
    private int startingX;
    private boolean movingRight = true;
    public double speed = 5.0;
    private boolean started;
    private int frames = 0;
    
    private GreenfootImage image1 = new GreenfootImage ("39.png");
    private GreenfootImage image2 = new GreenfootImage ("40.png");
    private GreenfootImage currentImage;
    public GreenfootImage CutImage(String imageLink) {
        GreenfootImage image = new GreenfootImage(imageLink);
        image.scale((Options.blockSize),(Options.blockSize));
        
        BufferedImage bufImage = image.getAwtImage();
        bufImage = bufImage.getSubimage(0,Options.blockSize/2,Options.blockSize,Options.blockSize/2);
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
        
        setBlockingClasses(new Class[]{Solid.class, SlopeLeft.class, SlopeRight.class});
    }
    public void act() 
    {
        if (!started) {
            setNewLocation(getX(), getY() + Options.blockSize / 4 - 1);
            this.startingX = this.getX();
            started = true;
        } else {
            setRelativeLocation(Globals.entityOffsetX,Globals.entityOffsetY);
        }
        if (currentImage == image1) {
            setImage(image2);
            currentImage = image2;
        } else {
            setImage(image1);
            currentImage = image1;
        }
        if (movingRight && (getDoubleX() + Globals.currentX) < (startingX + speed + movementRange * Options.blockSize) && canMoveRight(speed)) {
            moveRight(speed);
        } else {
            movingRight = false;
            if (canMoveLeft(speed) && (getX() + Globals.currentX - speed) > (startingX - movementRange * Options.blockSize)) {
                moveLeft(speed);
            } else {
                movingRight = true;
            }
        }    
    } 
}
