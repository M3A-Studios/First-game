import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.image.*;
import java.awt.*;

public class Platform extends Blocks
{
    Platform(int ID) {
        super(ID);
        BufferedImage bufImage = getImage().getAwtImage(); //Whatever
        bufImage = bufImage.getSubimage(0,0,64,32);
        
        GreenfootImage gImage = new GreenfootImage(bufImage.getWidth(), bufImage.getHeight());
        BufferedImage gBufImg = gImage.getAwtImage();
        Graphics2D graphics = (Graphics2D)gBufImg.getGraphics();
        graphics.drawImage(bufImage, null, 0, 0);
         
        setImage(gImage);
    } 
}
