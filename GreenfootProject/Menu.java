import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World
{
    private GifImage animation = new GifImage("menuBackground.gif");
    private int frame = 0;
    public Menu() {    
        super(Options.screenWidth, Options.screenHeight, 1, false);
        prepare();
        setBackground(animation.getCurrentImage());
        renderMenu();
    }
    private void renderMenu() {
        ActorsOptions menu = new ActorsOptions();
        addObject (menu, 0, 0);
    }
    public void act() {
        frame ++;
        if (frame >= 9) {
            setBackground(animation.getCurrentImage());
            frame = 0;
        }
    }
    private void prepare()
    {
        UFO uFO = new UFO("Blue");
        addObject(uFO,Options.blockSize * 4, Options.blockSize * 5);
        UFO uFO2 = new UFO("Beige");
        addObject(uFO2,Options.blockSize * 7, Options.blockSize * 9);
        UFO uFO3 = new UFO("Pink");
        addObject(uFO3,Options.blockSize * 24, Options.blockSize * 10);
        UFO uFO4 = new UFO("Green");
        addObject(uFO4,Options.blockSize * 19, Options.blockSize * 15);
        UFO uFO5 = new UFO("Yellow");
        addObject(uFO5,Options.blockSize * 27, Options.blockSize * 5);
        MenuNewGame menuNewGame = new MenuNewGame();
        addObject(menuNewGame,Options.screenWidth/2,Options.screenHeight - (Options.screenHeight / 10 * 8));
        MenuContinue menuContinue = new MenuContinue();
        addObject(menuContinue,Options.screenWidth/2,Options.screenHeight - (Options.screenHeight / 10 * 6));
        MenuOptions menuOptions = new MenuOptions();
        addObject(menuOptions,Options.screenWidth/2,Options.screenHeight - (Options.screenHeight / 10 * 4));
        MenuExit menuExit = new MenuExit();
        addObject(menuExit,Options.screenWidth/2,Options.screenHeight - (Options.screenHeight / 10 * 2));
        
    } 
}
