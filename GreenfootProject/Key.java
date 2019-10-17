import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Key extends ActorsOptions
{
    private GreenfootImage image;
    private String key;
    private String keyButton;
    private int location;
    private int player;
    Key(String key, int player) {
        this.key = key;
        if (key == "jump") location = 1;
        else if (key == "down") location = 2;
        else if (key == "right") location = 3;
        else if (key == "left") location = 4;
        else if (key == "action") location = 5;
        else location = 100;
        this.player = player;
    }
    public void act() 
    {
        if (player == 1) {
            if (key == "jump") keyButton = Options.jumpButtonPlayer1;
            else if (key == "down") keyButton = Options.downButtonPlayer1;
            else if (key == "right") keyButton = Options.rightButtonPlayer1;
            else if (key == "left") keyButton = Options.leftButtonPlayer1;
            else if (key == "action") keyButton = Options.actionButtonPlayer1;
            else keyButton = "A";
        } else {
            if (key == "jump") keyButton = Options.jumpButtonPlayer2;
            else if (key == "down") keyButton = Options.downButtonPlayer2;
            else if (key == "right") keyButton = Options.rightButtonPlayer2;
            else if (key == "left") keyButton = Options.leftButtonPlayer2;
            else if (key == "action") keyButton = Options.actionButtonPlayer2;
            else keyButton = "A";
        } 
            
        keyButton = keyButton.toUpperCase();
        
        if (!ActorsOptions.optionsOpen) { 
            setLocation(Options.screenWidth * 2, Options.screenHeight * 2);//just setting it far out of frame
        } else {
            setLocation(Options.screenWidth / 10 * ( player * 2),Options.screenHeight / 10 * (2 + location));
        }
        
        image = new GreenfootImage ("Keyboard_Black_" + keyButton + ".png");
        image.scale((Options.blockSize * 2),(Options.blockSize * 2));
        setImage(image);
    } 
}
