import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class SelectorCharacter extends Physics
{
    public GreenfootImage imageFront;
    private boolean moving = false;
    private int current;
    private int next;
    private int currentX;
    private int nextX;
    private int currentY;
    private int nextY;
    private int level;
    private double newX;
    private double newY;
    private int movingFrame;
    public GreenfootImage cropImage(String image) {
        GreenfootImage cutImage = new GreenfootImage (image);
        cutImage.scale(Options.blockSize * 2,Options.blockSize * 2);
        return cutImage;
    }
    SelectorCharacter(String color) {
        imageFront = cropImage(color + "Front.png");
        setImage(imageFront);
    }
    private void moveFromTo(int currentu, int nextu) {
        if (nextu <= Globals.level) {
            this.current = currentu;
            this.next = nextu;
            currentX = LevelSelector.getLevelX(current);
            currentY = LevelSelector.getLevelY(current);
            nextX = LevelSelector.getLevelX(next);
            nextY = LevelSelector.getLevelY(next);
            newX = (currentX - nextX);
            newY = (currentY - nextY);
            moving = true;
            Globals.selectedLevel = next;
        }
    }
    public void move() {
        setNewLocation(getX() -(newX/30), getY() -(newY/30));
        if (current != 0) {
            if (next > current) {
                if (next < 13 || next > 16) {
                    LevelSelector.dsy = -newY/30;
                }
                if (next > 12 && next < 17) {
                    LevelSelector.dsx = -newX/30;
                }
            } else {
                if (next < 12 || next > 15) {
                    LevelSelector.dsy = -newY/30;
                }
                if (next > 11 && next < 17) {
                    LevelSelector.dsx = -newX/30;
                }
            }
        }
    }
    public void act() 
    {
        String key = Greenfoot.getKey();
        if("escape".equals(key)) {ActorsOptions.optionsMenu();}
        level = Globals.selectedLevel;
        if (!ActorsOptions.optionsOpen) {
            if (moving) {
                if (movingFrame >= 30) {
                    movingFrame = 0;
                    moving = false;
                    setLocation((LevelSelector.getLevelX(next) -LevelSelector.scrolledX),(LevelSelector.getLevelY(next) - LevelSelector.scrolledY));
                } else {
                    movingFrame ++;
                    move();
                }
            } else {
                if(Options.leftButtonPlayer1.equals(key)) {
                    if (level == 2 || level == 6 || level == 9 || level == 12 || level == 13 || level == 14 || level == 15 || level == 16 || level == 18 || level == 21 || level == 23) {
                        moveFromTo(level, level + 1);
                    } else if (level == 5|| level == 8 || level == 11|| level == 20 || level == 25 || level == 28 || level == 29) {
                        moveFromTo(level, level - 1);
                    }
                }
                if(Options.rightButtonPlayer1.equals(key)) {
                    if (level == 4 || level == 10 || level == 24 || level == 27 || level == 28) {
                        moveFromTo(level, level + 1);
                    } else if (level == 3 || level == 13 || level == 14 || level == 15 || level == 16 || level == 19 || level == 22) {
                        moveFromTo(level, level - 1);
                    }
                }
                if(Options.jumpButtonPlayer1.equals(key)) {
                    if (level <= 12) {
                        moveFromTo(level, level + 1);
                    } else if (level >= 17 && level < 29) {
                        moveFromTo(level, level - 1);
                    }
                }
                if(Options.downButtonPlayer1.equals(key)) {
                    if (level >= 16 && level < 29) {
                        moveFromTo(level, level + 1);
                    } else if (level > 0 && level <= 13) {
                        moveFromTo(level, level - 1);
                    }
                }
                if("enter".equals(key)) {
                    if (Globals.selectedLevel == 0) Greenfoot.setWorld(new Tutorial());
                    else if (Globals.selectedLevel == 1) Greenfoot.setWorld(new Level1());
                    else if (Globals.selectedLevel == 2) Greenfoot.setWorld(new Level2());
                    else if (Globals.selectedLevel == 3) Greenfoot.setWorld(new Level3());
                    else if (Globals.selectedLevel == 4) Greenfoot.setWorld(new Level4());
                    else if (Globals.selectedLevel == 5) Greenfoot.setWorld(new Level5());
                    else if (Globals.selectedLevel == 6) Greenfoot.setWorld(new Level6());
                    else if (Globals.selectedLevel == 7) Greenfoot.setWorld(new Level7());
                    else if (Globals.selectedLevel == 8) Greenfoot.setWorld(new Level8());
                    else if (Globals.selectedLevel == 9) Greenfoot.setWorld(new Level9());
                    else if (Globals.selectedLevel == 10) Greenfoot.setWorld(new Level10());
                    else if (Globals.selectedLevel == 11) Greenfoot.setWorld(new Level11());
                    else if (Globals.selectedLevel == 12) Greenfoot.setWorld(new Level12());
                    else if (Globals.selectedLevel == 13) Greenfoot.setWorld(new Level13());
                    else if (Globals.selectedLevel == 14) Greenfoot.setWorld(new Level14());
                    else if (Globals.selectedLevel == 15) Greenfoot.setWorld(new Level15());
                    else if (Globals.selectedLevel == 16) Greenfoot.setWorld(new Level16());
                    else if (Globals.selectedLevel == 17) Greenfoot.setWorld(new Level17());
                    else if (Globals.selectedLevel == 18) Greenfoot.setWorld(new Level18());
                    else if (Globals.selectedLevel == 19) Greenfoot.setWorld(new Level19());
                    else if (Globals.selectedLevel == 20) Greenfoot.setWorld(new Level20());
                    else if (Globals.selectedLevel == 21) Greenfoot.setWorld(new Level21());
                    else if (Globals.selectedLevel == 22) Greenfoot.setWorld(new Level22());
                    else if (Globals.selectedLevel == 23) Greenfoot.setWorld(new Level23());
                    else if (Globals.selectedLevel == 24) Greenfoot.setWorld(new Level24());
                    else if (Globals.selectedLevel == 25) Greenfoot.setWorld(new Level25());
                    else if (Globals.selectedLevel == 26) Greenfoot.setWorld(new Level26());
                    else if (Globals.selectedLevel == 27) Greenfoot.setWorld(new Level27());
                    else if (Globals.selectedLevel == 28) Greenfoot.setWorld(new Level28());
                    else if (Globals.selectedLevel == 29) Greenfoot.setWorld(new Level29());
                }
            }
        } 
    }  
}
