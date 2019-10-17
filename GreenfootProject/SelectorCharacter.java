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
                    Greenfoot.setWorld(new Levels(Globals.selectedLevel));
                }
            }
        } 
    }  
}
