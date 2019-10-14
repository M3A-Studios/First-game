import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Physics
{
    public int health = 6;
    boolean started = false;
    private int animationFrame = 0;
    public int introFrame = 0;
    public boolean endingAnimation = false;
    public int endingFrame = 0;
    public boolean dead = false;
    public int deathAnimationFrame = 0;
    private int leftTime = 0;
    private int rightTime = 0;
    private int downTime = 0;
    private int jumpTime = 0;
    
    public GreenfootImage imageFront;
    public GreenfootImage imageDuck;
    public GreenfootImage imageStand;
    public GreenfootImage imageJump;
    public GreenfootImage imageWalk1;
    public GreenfootImage imageWalk2;
    public GreenfootImage imageSwim1;
    public GreenfootImage imageSwim2;
    public GreenfootImage imageClimb1;
    public GreenfootImage imageClimb2;
    public GreenfootImage imageHit;
    public GreenfootImage cropImage(String image) {
        GreenfootImage cutImage = new GreenfootImage (image);
        cutImage.scale(Options.blockSize,Options.blockSize);
        return cutImage;
    }
    Player(String color, int player) {
        setGravity(1);
        
        imageFront = cropImage(color + "Front.png");
        imageDuck = cropImage(color + "Duck.png");
        imageStand = cropImage(color + "Stand.png");
        imageJump = cropImage(color + "Jump.png");
        imageWalk1 = cropImage(color + "Walk1.png");
        imageWalk2 = cropImage(color + "Walk2.png");
        imageSwim1 = cropImage(color + "Swim1.png");
        imageSwim2 = cropImage(color + "Swim2.png");
        imageClimb1 = cropImage(color + "Climb1.png");
        imageClimb2 = cropImage(color + "Climb2.png");
        
        setBarrierClasses(new Class[]{Solid.class});
        setPlatformClasses(new Class[]{Platform.class});
        setSlopeLeftClasses(new Class[]{SlopeLeft.class});
        setSlopeRightClasses(new Class[]{SlopeRight.class});
        setDamagingClasses(new Class[]{HalfSaw.class});
    }
    public void act() 
    {
        if (!dead) setRelativeLocation(Globals.entityOffsetX,Globals.entityOffsetY);
        if (!started) {
            if (introFrame == 0) { 
                setNewLocation(-32.0, (Options.screenHeight - Options.screenHeight/8*2));
                setDoubleY(getY());
                setDoubleX(getX());
            }
            if (introFrame % 7 == 0) {
                if (getImage() == imageWalk1) {
                    setImage(imageWalk2);
                } else {
                    setImage(imageWalk1);
                }
            }
            if (introFrame >= 100) {
                setImage(imageStand);
                started = true;
            } else {
                moveRight(2.0);
            }
            introFrame += 1;
            doGravity();
        } else if (endingAnimation) {
            if (endingFrame % 7 == 0) {
                if (getImage() == imageWalk1) {
                    setImage(imageWalk2);
                } else {
                    setImage(imageWalk1);
                }
            }
            if (endingFrame >= 100) {
                setImage(imageStand);
                if (getWorld() instanceof Tutorial) Greenfoot.setWorld(new LevelSelector(0));
                else if (getWorld() instanceof Level1) Greenfoot.setWorld(new LevelSelector(1));
                else if (getWorld() instanceof Level2) Greenfoot.setWorld(new LevelSelector(2));
                else if (getWorld() instanceof Level3) Greenfoot.setWorld(new LevelSelector(3));
            } else {
                setRelativeLocation(0, 2.0);
            }
            endingFrame += 1;
            doGravity();
        } else if (!dead) {
            doGravity();
            String key = Greenfoot.getKey();
            if(Options.leftButtonPlayer1.equals(key)) {leftTime = 0;}
            if(Options.rightButtonPlayer1.equals(key)) {rightTime = 0;}
            if(Options.jumpButtonPlayer1.equals(key)) {jumpTime = 0;}
            if(Options.downButtonPlayer1.equals(key)) {downTime = 0;}
            animationFrame ++;
            if (animationFrame > 60) animationFrame = 0;
            if(Greenfoot.isKeyDown(Options.leftButtonPlayer1))
            {
                if (canMoveLeft(leftTime / 10 + 4.0)) {
                    leftTime += 1;
                    if (leftTime > 60) leftTime = 60;
                    moveLeft(leftTime / 10 + 4.0);
                }
            } 
            if(Greenfoot.isKeyDown(Options.rightButtonPlayer1))
            {
                if (canMoveRight(rightTime / 10 + 4.0)) {
                    rightTime += 1;
                    if (rightTime > 60) rightTime = 60;
                    moveRight(rightTime / 10 + 4.0);
                    if (endingFrame % (int) (22 - 2*(rightTime / 10)) == 0) {
                        if (getImage() == imageWalk1) {
                            setImage(imageWalk2);
                        } else {
                            setImage(imageWalk1);
                        }
                    }
                }
            }
            if(Greenfoot.isKeyDown(Options.jumpButtonPlayer1) ||  Greenfoot.isKeyDown(Options.jumpButton2Player1)) // Only jump if on ground
            {
                if (onGround() || onSlope()) {
                    setNewLocation(getDoubleX(), getDoubleY() - 1.0);
                    jump(20); // jump()'s parameter should be rather large
                } 
                jumpTime += 1;
            }
            if (finishedLevel()) {
                endingAnimation = true;
            }
            if (atBottom()) {
                dead = true;
                health = 0;
            } else {
            dead = died(); //set dead state to the died check. so true or false
            }
        } else if (dead) {
            Globals.alive = false;
            if (deathAnimationFrame < 30) {
                setRelativeLocation(0,-(deathAnimationFrame / 3));
            } else if (deathAnimationFrame > 30 && deathAnimationFrame < 40) {
                setRelativeLocation(0,(deathAnimationFrame - 40));
            } else if (deathAnimationFrame > 40 && deathAnimationFrame < 50) {
                setRelativeLocation(0,(deathAnimationFrame - 40));
            } else {
                setRelativeLocation(0,(deathAnimationFrame / 5));
            }
            deathAnimationFrame += 1;
            if (getY() > Options.screenHeight + getImage().getHeight()) {
                dead = false;
                Globals.alive = true;
                if (getWorld() instanceof Tutorial) Greenfoot.setWorld(new Tutorial());
                else if (getWorld() instanceof Level1) Greenfoot.setWorld(new Level1());
                else if (getWorld() instanceof Level2) Greenfoot.setWorld(new Level2());
                else if (getWorld() instanceof Level3) Greenfoot.setWorld(new Level3());
            }
        }
    }     
}
