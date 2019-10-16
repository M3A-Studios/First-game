import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HudNumber extends Actor
{
    public String purpose;
    public int position;
    private int start;
    GreenfootImage number;
    public String value = "0";
    private String coins;
    private String score;
    HudNumber(String purpose, int position) {
        this.purpose = purpose;
        this.position = position;
    }
    public void act() 
    {
        if (purpose == "coins") {
            if (getWorld() instanceof LevelSelector) {
                setLocation((Options.blockSize / 4 * 3 + (int) (Options.blockSize * 0.5 * position)), (Options.blockSize / 2));
                coins = Integer.toString(Globals.coins);
                start = 4;
            } else {
                setLocation((Options.blockSize / 4 * 3 + (int) (Options.blockSize * 0.5 * position)), (int) (Options.blockSize * 1.25));
                coins = Integer.toString(Globals.coinsThisLevel);
                start = 3;
            }
            String strArray[] = coins.split("");
            start = start - strArray.length + 1;
            if (position >= start) {		
	 	value = strArray[position-start];
            }
        }
        if (purpose == "score") {
            if (getWorld() instanceof LevelSelector) {
                setLocation((Options.blockSize * 26 + (int) (Options.blockSize * 0.5 * position)), (Options.blockSize / 2));
                score = Integer.toString(Globals.score);
                start = 7;
            } else {
                setLocation((Options.blockSize * 27 + (int) (Options.blockSize * 0.5 * position)), (int) (Options.blockSize * 0.5));
                score = Integer.toString(Globals.scoreThisLevel);
                start = 5;
            }
            String strArray[] = score.split("");
            start = start - strArray.length + 1;
            if (position >= start) {		
	 	value = strArray[position-start];
            }
        }
        GreenfootImage image = new GreenfootImage ("hud" + value + ".png");
        image.scale((Options.blockSize),(Options.blockSize));
        setImage(image);
    }    
}
