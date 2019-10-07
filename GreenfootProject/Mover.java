import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Handle movement of objects. including collision and gravity
 * 
 * @author Alexander
 * @version 0.1
 */
public class Mover extends Actor
{
    private int acceleration = 0;                   // down (gravity)
    private int speed = 0;                          // running speed (sideways)
    private Class[] barrier = new Class[0];
    private Class[] platform = new Class[0];
    private Class[] slopeLeft = new Class[0];
    private Class[] slopeRight = new Class[0];
    private Class[] dyingClass = new Class[0];
    private int vSpeed = 0;                         // current vertical speed
    
    public boolean died () {
        for (Class c: dyingClass) {
            if (getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/2 - 1, c) != null //bottom right
                || getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/-2 + 1, c) != null //top right
                || getOneObjectAtOffset(getImage().getWidth()/-2, getImage().getHeight()/-2 + 1, c) != null //top left
                || getOneObjectAtOffset(getImage().getWidth()/-2, getImage().getHeight()/2 - 1, c) != null) //bottom left
                {
                System.out.println("Dieded");
                return true;
                }
        }
        return false;
    }
    
    public void moveRight() { //moving right method
        if (canMoveRight()) //check if we can move right, check method below
            setLocation(getX() + speed,getY()); //move right
    }
    public boolean canMoveRight() //check if we can move right
    {
        for(Class c: barrier) //check for barrier blocks (barrier classes can be set in the subclass)
        {
            if (onSlopeRight()) {setLocation(getX(), getY() - 2);}
            if (getOneObjectAtOffset(getImage().getWidth()/2 + speed, getImage().getHeight()/2, c) != null //get object at bottom right of object
                || getOneObjectAtOffset(getImage().getWidth()/2 + speed, getImage().getHeight()/-2, c) != null) { //get object at top right of object
                return false; //if either is has an object there thats part of the barriers it will set canMoveRight to false
            } 
        }
        for(Class c: slopeRight) {
            if (getOneObjectAtOffset(getImage().getWidth()/2 - speed, getImage().getHeight()/2, c) != null //get object at bottom left of object
                || getOneObjectAtOffset(getImage().getWidth()/2 - speed, getImage().getHeight()/-2, c) != null) { //get object at top left of object
                setLocation(getX() + speed, getY() - speed - 2); //if either is has an object there thats part of the barriers it will set canMoveLeft to false
                return false;
            }
        }
        if ((getX() + getImage().getWidth()*3/2 + Globals.currentX + speed) > Globals.worldWidth) { //check if you reached end of the world
            return false; //if so return false
        }
        return true; //return true if code hasn't returned anything yet
    }
    public void moveLeft() { //moving left method
        if (canMoveLeft()) //check if we can move left, check method below
            setLocation(getX() - speed,getY()); //move left
    }
    public boolean canMoveLeft() //check if we can move left
    {
        for(Class c: barrier) //check for barrier blocks (barrier classes can be set in the subclass)
        {
            if (onSlopeLeft()) {setLocation(getX(), getY() - 2);}
            if (getOneObjectAtOffset(getImage().getWidth()/-2 - speed, getImage().getHeight()/2, c) != null //get object at bottom left of object
                || getOneObjectAtOffset(getImage().getWidth()/-2 - speed, getImage().getHeight()/-2, c) != null) { //get object at top left of object
                return false; //if either is has an object there thats part of the barriers it will set canMoveLeft to false
            }
        }
        for(Class c: slopeLeft) {
            if (getOneObjectAtOffset(getImage().getWidth()/-2 - speed, getImage().getHeight()/2, c) != null //get object at bottom left of object
                || getOneObjectAtOffset(getImage().getWidth()/-2 - speed, getImage().getHeight()/-2, c) != null) { //get object at top left of object
                setLocation(getX() - speed, getY() - speed - 2); //if either is has an object there thats part of the barriers it will set canMoveLeft to false
                return false;
            }
        }
        if ((getImage().getWidth()/-2 + getX() + Globals.currentX - speed) < 0) { //check if you are at the start if the world
            return false; //if so return false
        }
        return true; //return true if code hasn't returned anything yet
    }
    
    public void jump(int speed) //jump method
    {
        if(canMoveUpwards()) //check if we can move upwards
            vSpeed = -speed; //jump at speed speed
    }
    public boolean canMoveUpwards() { //check if we don't have a block above us
        boolean b = true; //by default true
        for(Class c: barrier) //check for barrier blocks (barrier classes can be set in the subclass)
        {
            if (getOneObjectAtOffset(getImage().getWidth()/-2, getImage().getHeight()/-2 + vSpeed, c) != null //get object at top left pixel of object
                || getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/-2 + vSpeed, c) != null) { //get object at top right of object
                b = false; //if either has an object there thats part of the barriers it will set canMoveUpwards to false
            }
        }
        return b; //return true or false
    }
    
    public boolean onGround() { //check if we're on the ground
        boolean b = false; //by default false
        for(Class c: barrier) //check for barrier blocks (barrier classes can be set in the subclass)
        {
            if (getOneObjectAtOffset(getImage().getWidth()/-2, getImage().getHeight()/2 + vSpeed, c) != null //get object at lower left pixel of object
                || getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/2 + vSpeed, c) != null) { //get object at lower right pixel of object
                b = true; //if either has an object there thats part of the barriers it will set on ground to true
            }
        }
        for (Class c: platform) {
            if (vSpeed >= 0) {
                boolean insidePlatform = false;
                Actor platformBelow = (getOneObjectAtOffset(getImage().getWidth()/-2, getImage().getHeight()/2 + vSpeed, c));
                if (platformBelow != null) {
                    insidePlatform = ((platformBelow.getY() - Options.heightSize) < getY());
                }
                if (getOneObjectAtOffset(getImage().getWidth()/-2, getImage().getHeight()/2 + vSpeed, c) != null //get object at lower left pixel of object
                    || getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/2 + vSpeed, c) != null) { //get object at lower right pixel of object
                    if (!insidePlatform) {
                    b = true; //if either has an object there thats part of the barriers it will set on ground to true
                    }
                }
            }
        }
        return b; //return true or false
    }
    public boolean onSlopeLeft() {
        boolean onSlopeLeft = false;
        for (Class c: slopeLeft) { //check for slope blocks 
            Actor slopeLeftBelow = (getOneObjectAtOffset(getImage().getWidth()/-2, getImage().getHeight()/2 + vSpeed - 1, c));
            if (slopeLeftBelow != null) {
                int toTheRight = ((getX() + getImage().getWidth()/-2) - slopeLeftBelow.getX()); 
                int slopePixelY = slopeLeftBelow.getY() + toTheRight;
                while (getY() + getImage().getHeight()/2 > slopePixelY) { //anti clip
                    setLocation(getX(), getY() - 1);
                }
                onSlopeLeft = ((getY() + getImage().getHeight()/2) >= slopePixelY);
            }
        }
        return onSlopeLeft;
    }
    public boolean onSlopeRight() {
        boolean onSlopeRight = false;
        for (Class c: slopeRight) {
            Actor slopeRightBelow = (getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/2 + vSpeed - 1, c));
            if (slopeRightBelow != null) {
                int toTheLeft = ((getX() + getImage().getWidth()/2) - (slopeRightBelow.getX() + slopeRightBelow.getImage().getWidth()/2));
                int slopePixelY = slopeRightBelow.getY() + slopeRightBelow.getImage().getHeight()/2 - (Options.widthSize + toTheLeft);
                while (getY() + getImage().getHeight()/2 > slopePixelY) { //anti clip
                    setLocation(getX(), getY() - 1);
                }
                onSlopeRight = ((getY() + getImage().getHeight()/2) >= slopePixelY);
            }
        }
        return onSlopeRight;
    }
    public boolean onSlope() {
        if (onSlopeRight() || onSlopeLeft()) { return true; }
        return false;
    }
    public void doGravity() //gravity method
    {
        if(vSpeed != 0 && onGround()) {vSpeed = 0;} //if object is on the ground vertical speed is 0
        else if (vSpeed != 0 && onSlope()) {vSpeed = 0;} //if object is on a slope. vertical speed is 0
        else if(vSpeed < 0 && (!canMoveUpwards()))  {vSpeed = 0;} //if object is moving up and hit a block vertical speed is 0
        setLocation(getX(), getY() + vSpeed); //set object location to new Y location
        vSpeed = vSpeed + acceleration; //up the object's vertical speed by the acceleration
        
    }
    protected boolean atBottom() //check if player is on the bottom of the screen
    {
        return getY() >= getWorld().getHeight() - 2; //check if player's Y is 2 or less from the bottom of the screen
    } 
    protected void setMovementSpeed(int newSpeed) //set the movement speed
    {
        speed = newSpeed; 
    }
    protected void setBlockingClasses(Class[] c) //set the blocking classes
    {
        barrier = c; //barriers defined in subclass
    }
    protected void setPlatformClasses(Class[] c)
    {
        platform = c;
    }
    protected void setSlopeLeftClasses(Class[] c)
    {
        slopeLeft = c;
    }
    protected void setSlopeRightClasses(Class[] c)
    {
        slopeRight = c;
    }
    protected void setDyingClasses(Class[] c) {
        dyingClass = c;
    }
    protected void setGravity(int g) //set the object's acceleration (pixels/s to slow down by vertically
    {
        acceleration = g;
    } 
    protected void setVSpeed(int v) //set the object's vertical speed
    {
        vSpeed = v;
    }
}
