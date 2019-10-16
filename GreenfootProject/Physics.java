import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Physics extends Actor
{
    private double acceleration = 0.0;                   // down (gravity)
    private double vSpeed = 0.0;
    private double doubleX;
    private double doubleY;
    private Class[] barrier = new Class[0];
    private Class[] platform = new Class[0];
    private Class[] slopeLeft = new Class[0];
    private Class[] slopeRight = new Class[0];
    private Class[] lava = new Class[0];
    private Class[] water = new Class[0];
    private Class[] damaging = new Class[0];
    private Class[] superDamaging = new Class[0];
    private Class[] finishFlag = {FinishFlag.class};
    
    public double getDoubleX() {
        return doubleX;
    }
    public double getDoubleY() {
        return doubleY;
    }
    public void setRelativeLocation(double x, double y) {
        doubleX = doubleX + x;
        doubleY = doubleY + y;
        setLocation((int) doubleX, (int) doubleY);
    }
    public void setNewLocation (double x, double y) {
        doubleX = x;
        doubleY = y;
        setLocation((int) doubleX, (int) doubleY);
    }
    public boolean finishedLevel() {
        if (getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/2 - 1, FinishFlag.class) != null //bottom right
            || getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/-2 + 1, FinishFlag.class) != null //top right
            || getOneObjectAtOffset(getImage().getWidth()/-2, getImage().getHeight()/-2 + 1, FinishFlag.class) != null //top left
            || getOneObjectAtOffset(getImage().getWidth()/-2, getImage().getHeight()/2 - 1, FinishFlag.class) != null) //bottom left
            {
            return true;
            }
        return false;
    }
    public boolean tookDamage () {
        for (Class c: damaging) {
            if (getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/2 - 1, c) != null //bottom right
                || getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/-2 + 1, c) != null //top right
                || getOneObjectAtOffset(getImage().getWidth()/-2, getImage().getHeight()/-2 + 1, c) != null //top left
                || getOneObjectAtOffset(getImage().getWidth()/-2, getImage().getHeight()/2 - 1, c) != null) //bottom left
                {
                return true;
            }
        }
        return false;
    }
    public boolean tookSuperDamage() {
        for (Class c: superDamaging) {
            if (getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/2 - 1, c) != null //bottom right
                || getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/-2 + 1, c) != null //top right
                || getOneObjectAtOffset(getImage().getWidth()/-2, getImage().getHeight()/-2 + 1, c) != null //top left
                || getOneObjectAtOffset(getImage().getWidth()/-2, getImage().getHeight()/2 - 1, c) != null) //bottom left
                {
                return true;
            }
        }
        return false;
    }
    public void moveRight(double speed) { //moving right method
        speed = speed * Options.blockSize / 64;
        if (canMoveRight(speed)) //check if we can move right, check method below
            setRelativeLocation(speed,0); //move right
    }
    public boolean canMoveRight(double speed) //check if we can move right
    {
        for(Class c: barrier) //check for barrier blocks (barrier classes can be set in the subclass)
        {
            if (onSlopeRight()) {setNewLocation(getX(), getY() - 2.0);}
            if (getOneObjectAtOffset(getImage().getWidth()/2 + (int) speed, getImage().getHeight()/2, c) != null //get object at bottom right of object
                || getOneObjectAtOffset(getImage().getWidth()/2 + (int) speed, getImage().getHeight()/-2, c) != null) { //get object at top right of object
                return false; //if either is has an object there thats part of the barriers it will set canMoveRight to false
            } 
        }
        for(Class c: slopeRight) {
            if (getOneObjectAtOffset(getImage().getWidth()/2 - (int) speed, getImage().getHeight()/2, c) != null //get object at bottom left of object
                || getOneObjectAtOffset(getImage().getWidth()/2 - (int) speed, getImage().getHeight()/-2, c) != null) { //get object at top left of object
                setRelativeLocation((int) speed, -(int) speed); //if either is has an object there thats part of the barriers it will set canMoveLeft to false
                return false;
            }
        }
        if ((getDoubleX() + getImage().getWidth()*3/2 + Globals.currentX + speed) > Globals.worldWidth) { //check if you reached end of the world
            return false; //if so return false
        }
        return true; //return true if code hasn't returned anything yet
    }
    public void moveLeft(double speed) { //moving left method
        speed = speed * Options.blockSize / 64;
        if (canMoveLeft(speed)) //check if we can move left, check method below
            setRelativeLocation(-speed,0); //move left
    }
    public boolean canMoveLeft(double speed) //check if we can move left
    {
        for(Class c: barrier) //check for barrier blocks (barrier classes can be set in the subclass)
        {
            if (onSlopeLeft()) {setRelativeLocation(0,-2.0);}
            if (getOneObjectAtOffset(getImage().getWidth()/-2 - (int) speed, getImage().getHeight()/2, c) != null //get object at bottom left of object
                || getOneObjectAtOffset(getImage().getWidth()/-2 - (int) speed, getImage().getHeight()/-2, c) != null) { //get object at top left of object
                return false; //if either is has an object there thats part of the barriers it will set canMoveLeft to false
            }
        }
        for(Class c: slopeLeft) {
            if (getOneObjectAtOffset(getImage().getWidth()/-2 - (int) speed, getImage().getHeight()/2, c) != null //get object at bottom left of object
                || getOneObjectAtOffset(getImage().getWidth()/-2 - (int) speed, getImage().getHeight()/-2, c) != null) { //get object at top left of object
                setRelativeLocation(- (int) speed, - (int) speed); //if either is has an object there thats part of the barriers it will set canMoveLeft to false
                return false;
            }
        }
        if ((getImage().getWidth()/-2 + getDoubleX() + Globals.currentX - (int) speed) < 0) { //check if you are at the start if the world
            return false; //if so return false
        }
        return true; //return true if code hasn't returned anything yet
    }
    
    public void jump(double speed) //jump method
    {
        speed = speed * Options.blockSize / 64;
        if(canMoveUpwards()) //check if we can move upwards
            vSpeed = -speed; //jump at speed speed
    }
    public boolean canMoveUpwards() { //check if we don't have a block above us
        boolean b = true; //by default true
        for(Class c: barrier) //check for barrier blocks (barrier classes can be set in the subclass)
        {
            if (getOneObjectAtOffset(getImage().getWidth()/-2, getImage().getHeight()/-2 + (int) vSpeed, c) != null //get object at top left pixel of object
                || getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/-2 + (int) vSpeed, c) != null) { //get object at top right of object
                b = false; //if either has an object there thats part of the barriers it will set canMoveUpwards to false
            }
        }
        return b; //return true or false
    }
    
    public boolean onGround() { //check if we're on the ground
        boolean b = false; //by default false
        for(Class c: barrier) //check for barrier blocks (barrier classes can be set in the subclass)
        {
            if (getOneObjectAtOffset(getImage().getWidth()/-2, (int) (getImage().getHeight()/2 + vSpeed + Options.smallerScreen), c) != null //get object at lower left pixel of object
                || getOneObjectAtOffset(getImage().getWidth()/2, (int) (getImage().getHeight()/2 + vSpeed + Options.smallerScreen), c) != null) { //get object at lower right pixel of object
                b = true; //if either has an object there thats part of the barriers it will set on ground to true
            }
        }
        for (Class c: platform) {
            if (vSpeed >= 0) {
                boolean insidePlatform = false;
                boolean insidePlatform2 = false;
                Actor platformBelow = (getOneObjectAtOffset(getImage().getWidth()/-2, (int) (getImage().getHeight()/2 + vSpeed - 1 + Options.smallerScreen), c));
                if (platformBelow != null) {
                    insidePlatform = (platformBelow.getY() - platformBelow.getImage().getHeight()/2 < getY() + getImage().getHeight()/2);
                }
                Actor platformBelow2 = (getOneObjectAtOffset(getImage().getWidth()/2, (int) (getImage().getHeight()/2 + vSpeed - 1 + Options.smallerScreen), c));
                if (platformBelow2 != null) {
                    insidePlatform2 = (platformBelow2.getY() - platformBelow2.getImage().getHeight()/2 < getY() + getImage().getHeight()/2);
                }
                if (getOneObjectAtOffset(getImage().getWidth()/-2, (int) (getImage().getHeight()/2 + vSpeed + 1), c) != null //get object at lower left pixel of object
                    || getOneObjectAtOffset(getImage().getWidth()/2, (int) (getImage().getHeight()/2 + vSpeed + 1), c) != null) { //get object at lower right pixel of object
                    if (!insidePlatform && !insidePlatform2) {
                    b = true; //if either has an object there thats part of the barriers it will set on ground to true
                    }
                }
            }
        }
        return b; //return true or false
    }
    /* Slopes still need some serious work to them
     * Lots of problems with clipping and walking up slopes right now
     * Not the focus of today but definitly need a rework as this isn't optimal
     * And becomes a problem when walking up multiple slopes */
    public boolean onSlopeLeft() {
        boolean onSlopeLeft = false;
        for (Class c: slopeLeft) { //check for slope blocks 
            Actor slopeLeftBelow = (getOneObjectAtOffset(getImage().getWidth()/-2, getImage().getHeight()/2 + (int) vSpeed - 1, c));
            if (slopeLeftBelow != null) {
                int toTheRight = ((getX() + getImage().getWidth()/-2) - slopeLeftBelow.getX()); 
                int slopePixelY = slopeLeftBelow.getY() + toTheRight;
                while (getY() + getImage().getHeight()/2 > slopePixelY) { //anti clip
                    setRelativeLocation(0,-1.0);
                }
                onSlopeLeft = ((getY() + getImage().getHeight()/2) >= slopePixelY);
            }
        }
        return onSlopeLeft;
    }
    public boolean onSlopeRight() {
        boolean onSlopeRight = false;
        for (Class c: slopeRight) {
            Actor slopeRightBelow = (getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/2 + (int) vSpeed - 1, c));
            if (slopeRightBelow != null) {
                int toTheLeft = ((getX() + getImage().getWidth()/2) - (slopeRightBelow.getX() + slopeRightBelow.getImage().getWidth()/2));
                int slopePixelY = slopeRightBelow.getY() + slopeRightBelow.getImage().getHeight()/2 - (Options.blockSize + toTheLeft);
                while (getY() + getImage().getHeight()/2 > slopePixelY) { //anti clip
                    setRelativeLocation(0,-1.0);
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
        setRelativeLocation(0,vSpeed); //set object location to new Y location
        vSpeed = vSpeed + (acceleration * Options.blockSize/64); //up the object's vertical speed by the acceleration
        
    }
    protected boolean atBottom() //check if player is on the bottom of the screen
    {
        return getY() >= getWorld().getHeight() - 2; //check if player's Y is 2 or less from the bottom of the screen
    } 
    protected void setBarrierClasses(Class[] c) //set the blocking classes
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
    protected void setLavaClasses(Class[] c) {
        lava = c;
    }
    protected void setWaterClasses(Class[] c) {
        water = c;
    }
    protected void setDamagingClasses(Class[] c) {
        damaging = c;
    }
    protected void setSuperDamagingClasses(Class[] c) {
        superDamaging = c;
    }
    protected void setGravity(int g) //set the object's acceleration (pixels/s to slow down by vertically
    {
        acceleration = g;
    } 
    protected void setDoubleX(double x) {
        doubleX = x;
    }
    protected void setDoubleY(double y) {
        doubleY = y;
    }
}
