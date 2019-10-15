import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelNode extends Actor
{
    private GreenfootImage image;
    LevelNode(String type, int level) {
        if (Globals.level < level) {
            image = new GreenfootImage(type + "NodeLocked.png");
        } else {
            image = new GreenfootImage(type + "Node.png");
        }
        image.scale((Options.blockSize * 3),(Options.blockSize * 3));
        if (level < 29 || level == 29 && Globals.level >= 29) setImage(image);
    } 
}
