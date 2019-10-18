import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Slime extends Enemy
{
    private boolean started = false;
    private int deadTime = 0;
    private int animationFrame;
    public boolean dead;
    Slime(int ID) {
        
        movementRange = 4;
        movingRight = false;
        if (ID >= 44 && ID <= 47) {
            speed = 3.0;
            animation1 = cutImage("46.png");
            animation2 = cutImage("47.png");
            deathImage = cutImage("45.png");
        } else if (ID >= 48 && ID <= 51) {
            speed = 4.0;
            animation1 = cutImage("50.png");
            animation2 = cutImage("51.png");
            deathImage = cutImage("49.png");
        } else {
            speed = 5.0;
            animation1 = cutImage("54.png");
            animation2 = cutImage("55.png");
            deathImage = cutImage("53.png");
        }
        setImage(animation1);
        currentImage = getImage();
        
        setBarrierClasses(new Class[]{Solid.class, SlopeLeft.class, SlopeRight.class});
    }
    public void act() 
    {
        if (!dead) {
            if (!started) {
                setNewLocation(getX(), getY() + Options.blockSize / 4);
                startingX = getX();
                startingY = getX();
                started = true;
            } else {
                setRelativeLocation(Globals.entityOffsetX,Globals.entityOffsetY);
            }
            if (animationFrame > 6) {
                if (currentImage == animation1) {
                    setImage(animation2);
                    currentImage = animation2;
                } else {
                    setImage(animation1);
                    currentImage = animation1;
                }
                animationFrame = 0;
            } else {
                animationFrame += 1;
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
        } else {
            if (deadTime < 30) {
                setImage(deathImage);
            } else {
                getWorld().removeObject(this);
            }
            deadTime += 1;
        }
    }    
}
