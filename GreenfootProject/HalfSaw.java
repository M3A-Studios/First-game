import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HalfSaw extends Enemy
{
    private boolean started;
    
    HalfSaw() {
        speed = 5.0;
        movementRange = 4;
        movingRight = false;
        animation1 = cutImage("39.png");
        animation2 = cutImage("40.png");
        deathImage = cutImage("38.png");
        
        setImage(animation1);
        currentImage = getImage();
        
        setBarrierClasses(new Class[]{Solid.class, SlopeLeft.class, SlopeRight.class});
    } 
    public void act() 
    {
        if (!started) {
            setNewLocation(getX(), getY() + Options.blockSize / 4);
            startingX = getX();
            startingY = getX();
            started = true;
        } else {
            setRelativeLocation(Globals.entityOffsetX,Globals.entityOffsetY);
        }
        if (currentImage == animation1) {
            setImage(animation2);
            currentImage = animation2;
        } else {
            setImage(animation1);
            currentImage = animation1;
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
