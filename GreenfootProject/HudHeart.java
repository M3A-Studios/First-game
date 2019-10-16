import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HudHeart extends Actor
{
    GreenfootImage image;
    private int heart;
    HudHeart(int heart) 
    {
        this.heart = heart;
        renderHeart();
    }
    public void renderHeart() {
        String state;
        if (heart == 1) {
            if (Player.health == 1) {
                state = "half";
            } else if (Player.health >= 2) {
                state = "full";
            } else {
                state = "empty";
            }
        } else if (heart == 2) {
            if (Player.health == 3) {
                state = "half";
            } else if (Player.health >= 4) {
                state = "full";
            } else {
                state = "empty";
            }
        } else if (heart == 3) {
            if (Player.health == 5) {
                state = "half";
            } else if (Player.health >= 6) {
                state = "full";
            } else {
                state = "empty";
            }
        } else {
            state = "empty";
        }
        if (state == "half") {
            image = new GreenfootImage ("hudHeartHalf.png");
        } else if (state == "full") {
            image = new GreenfootImage ("hudHeartFull.png");
        } else {
            image = new GreenfootImage ("hudHeartEmpty.png");
        }
        image.scale((Options.blockSize),(Options.blockSize));
        setImage(image);
    }     
    public void act() {
        renderHeart();
        setLocation(Options.blockSize * heart - (int) (Options.blockSize * 0.5), (int) (Options.blockSize * 0.5));
    }
}
