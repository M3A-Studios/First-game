import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.image.*;
import java.awt.*;

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
    protected GreenfootImage cutImage(String imageLink) {
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
}
