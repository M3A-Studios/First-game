import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class SelectorCharacter extends Physics
{
    public GreenfootImage imageFront;
    private boolean moving = false;
    private int currentX;
    private int nextX;
    private int currentY;
    private int nextY;
    public GreenfootImage cropImage(String image) {
        GreenfootImage cutImage = new GreenfootImage (image);
        cutImage.scale(Options.blockSize * 2,Options.blockSize * 2);
        return cutImage;
    }
    SelectorCharacter(String color) {
        imageFront = cropImage(color + "Front.png");
        setImage(imageFront);
    }
    public void moveToFrom(int current, int next) {
        System.out.println("current: " + current + ", next: " + next);
        currentX = LevelSelector.getMapX(current);
        nextX = LevelSelector.getMapX(next);
        currentY = LevelSelector.getMapY(current);
        nextY = LevelSelector.getMapY(next);
        System.out.println(currentX + ", " + currentY + " -> " + nextX + ", " + nextY);
    }
    public void act() 
    {
        String key = Greenfoot.getKey();
        if(Options.leftButtonPlayer1.equals(key) && !moving) {
            moveToFrom(LevelSelector.level, LevelSelector.level);
        }
        if(Options.rightButtonPlayer1.equals(key) && !moving) {
            moveToFrom(LevelSelector.level, LevelSelector.level);
        }
        if(Options.jumpButtonPlayer1.equals(key) && !moving) {
            if (LevelSelector.level <= 12) {
                moveToFrom(LevelSelector.level, LevelSelector.level + 1);
                LevelSelector.level ++; 
            } else if (LevelSelector.level >= 17) {
                moveToFrom(LevelSelector.level, LevelSelector.level - 1);
                LevelSelector.level --;
            }
        }
        if(Options.downButtonPlayer1.equals(key) && LevelSelector.level >  0 && !moving) {
            if (LevelSelector.level <= 12) {
                moveToFrom(LevelSelector.level, LevelSelector.level - 1);
                LevelSelector.level --;
            } else if (LevelSelector.level >= 17) {
                moveToFrom(LevelSelector.level, LevelSelector.level + 1);
                LevelSelector.level ++;
            }
        }
        if("enter".equals(key)) {
            if (LevelSelector.level == 0) Greenfoot.setWorld(new Tutorial());
            else if (LevelSelector.level == 1) Greenfoot.setWorld(new Level1());
            else if (LevelSelector.level == 2) Greenfoot.setWorld(new Level2());
            else if (LevelSelector.level == 3) Greenfoot.setWorld(new Level3());
        }
    }  
}
