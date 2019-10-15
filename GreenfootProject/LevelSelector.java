import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class LevelSelector extends World
{
    public static double dsx = 0;
    public static double dsy = 0;
    private static double leftoverDsx;
    private static double leftoverDsy;
    public static int scrolledX;
    public static int scrolledY;
    Scroller scroller; // the object that performs the scrolling
    Actor scrollActor; // an actor to stay in view*
    public static int getLevelX(int level) {
        if (level == 0) return getScaledX(3500);
        else if (level == 1) return getScaledX(3300);
        else if (level == 2) return getScaledX(2900);
        else if (level == 3) return getScaledX(2500);
        else if (level == 4) return getScaledX(2700);
        else if (level == 5) return getScaledX(3100);
        else if (level == 6) return getScaledX(2700);
        else if (level == 7) return getScaledX(2900);
        else if (level == 8) return getScaledX(3100);
        else if (level == 9) return getScaledX(2800);
        else if (level == 10) return getScaledX(2700);
        else if (level == 11) return getScaledX(3300);
        else if (level == 12) return getScaledX(3100);
        else if (level == 13) return getScaledX(2600);
        else if (level == 14) return getScaledX(2100);
        else if (level == 15) return getScaledX(1800);
        else if (level == 16) return getScaledX(1500);
        else if (level == 17) return getScaledX(1000);
        else if (level == 18) return getScaledX(1600);
        else if (level == 19) return getScaledX(1000);
        else if (level == 20) return getScaledX(1600);
        else if (level == 21) return getScaledX(1400);
        else if (level == 22) return getScaledX(1200);
        else if (level == 23) return getScaledX(1000);
        else if (level == 24) return getScaledX(800);
        else if (level == 25) return getScaledX(1700);
        else if (level == 26) return getScaledX(800);
        else if (level == 27) return getScaledX(1000);
        else if (level == 28) return getScaledX(1500);
        else if (level == 29) return getScaledX(2100);
        else return 100;
    }
    public static int getLevelY(int level) {
        if (level == 0) return getScaledY(5200);
        else if (level == 1) return getScaledY(4800);
        else if (level == 2) return getScaledY(4500);
        else if (level == 3) return getScaledY(4300);
        else if (level == 4) return getScaledY(3900);
        else if (level == 5) return getScaledY(3600);
        else if (level == 6) return getScaledY(3300);
        else if (level == 7) return getScaledY(3000);
        else if (level == 8) return getScaledY(2600);
        else if (level == 9) return getScaledY(2000);
        else if (level == 10) return getScaledY(1600);
        else if (level == 11) return getScaledY(1400);
        else if (level == 12) return getScaledY(700);
        else if (level == 13) return getScaledY(300);
        else if (level == 14) return getScaledY(500);
        else if (level == 15) return getScaledY(550);
        else if (level == 16) return getScaledY(500);
        else if (level == 17) return getScaledY(900);
        else if (level == 18) return getScaledY(1300);
        else if (level == 19) return getScaledY(1600);
        else if (level == 20) return getScaledY(1900);
        else if (level == 21) return getScaledY(2200);
        else if (level == 22) return getScaledY(2500);
        else if (level == 23) return getScaledY(2800);
        else if (level == 24) return getScaledY(3300);
        else if (level == 25) return getScaledY(3600);
        else if (level == 26) return getScaledY(4100);
        else if (level == 27) return getScaledY(4700);
        else if (level == 28) return getScaledY(5000);
        else if (level == 29) return getScaledY(4700);
        else return 100;
    }
    protected void renderWorld() {
        Actor levelNode = new LevelNode("Tutorial", 0);
        Actor levelNode1 = new LevelNode("Lava", 1);
        Actor levelNode2 = new LevelNode("Lava", 2);
        Actor levelNode3 = new LevelNode("Lava", 3);
        Actor levelNode4 = new LevelNode("Lava", 4);
        Actor levelNode5 = new LevelNode("Lava", 5);
        Actor levelNode6 = new LevelNode("Lava", 6);
        Actor levelNode7 = new LevelNode("Lava", 7);
        Actor levelNode8 = new LevelNode("Lava", 8);
        Actor levelNode9 = new LevelNode("Lava", 9);
        Actor levelNode10 = new LevelNode("Lava", 10);
        Actor levelNode11 = new LevelNode("Lava", 11);
        Actor levelNode12 = new LevelNode("Lava", 12);
        Actor levelNode13 = new LevelNode("Lava", 13);
        Actor levelNode14 = new LevelNode("Lava", 14);
        Actor levelNode15 = new LevelNode("Lava", 15);
        Actor levelNode16 = new LevelNode("Lava", 16);
        Actor levelNode17 = new LevelNode("Lava", 17);
        Actor levelNode18 = new LevelNode("Lava", 18);
        Actor levelNode19 = new LevelNode("Lava", 19);
        Actor levelNode20 = new LevelNode("Lava", 20);
        Actor levelNode21 = new LevelNode("Lava", 21);
        Actor levelNode22 = new LevelNode("Lava", 22);
        Actor levelNode23 = new LevelNode("Lava", 23);
        Actor levelNode24 = new LevelNode("Lava", 24);
        Actor levelNode25 = new LevelNode("Lava", 25);
        Actor levelNode26 = new LevelNode("Lava", 26);
        Actor levelNode27 = new LevelNode("Lava", 27);
        Actor levelNode28 = new LevelNode("Lava", 28);
        addObject(levelNode, getLevelX(0), getLevelY(0));
        addObject(levelNode1, getLevelX(1), getLevelY(1));
        addObject(levelNode2, getLevelX(2), getLevelY(2));
        addObject(levelNode3, getLevelX(3), getLevelY(3));
        addObject(levelNode4, getLevelX(4), getLevelY(4));
        addObject(levelNode5, getLevelX(5), getLevelY(5));
        addObject(levelNode6, getLevelX(6), getLevelY(6));
        addObject(levelNode7, getLevelX(7), getLevelY(7));
        addObject(levelNode8, getLevelX(8), getLevelY(8));
        addObject(levelNode9, getLevelX(9), getLevelY(9));
        addObject(levelNode10, getLevelX(10), getLevelY(10));
        addObject(levelNode11, getLevelX(11), getLevelY(11));
        addObject(levelNode12, getLevelX(12), getLevelY(12));
        addObject(levelNode13, getLevelX(13), getLevelY(13));
        addObject(levelNode14, getLevelX(14), getLevelY(14));
        addObject(levelNode15, getLevelX(15), getLevelY(15));
        addObject(levelNode16, getLevelX(16), getLevelY(16));
        addObject(levelNode17, getLevelX(17), getLevelY(17));
        addObject(levelNode18, getLevelX(18), getLevelY(18));
        addObject(levelNode19, getLevelX(19), getLevelY(19));
        addObject(levelNode20, getLevelX(20), getLevelY(20));
        addObject(levelNode21, getLevelX(21), getLevelY(21));
        addObject(levelNode22, getLevelX(22), getLevelY(22));
        addObject(levelNode23, getLevelX(23), getLevelY(23));
        addObject(levelNode24, getLevelX(24), getLevelY(24));
        addObject(levelNode25, getLevelX(25), getLevelY(25));
        addObject(levelNode26, getLevelX(26), getLevelY(26));
        addObject(levelNode27, getLevelX(27), getLevelY(27));
        addObject(levelNode28, getLevelX(28), getLevelY(28));
        if (Globals.level >= 29) {
            Actor levelNode29 = new LevelNode("Lava", 29);
            addObject(levelNode29, getLevelX(29), getLevelY(29));
        }
    }
    public LevelSelector() {
        super(Options.screenWidth, Options.screenHeight, 1, false);
        Globals.selectedLevel = Globals.lastLevel;
        renderWorld();
        initiateScroll("test.png");
        
        Saver.saveGame();
    }
    public static int getScaledX(double x) {
        return (int) ((x/1920) * (double) Options.screenWidth);
    }
    public static int getScaledY(double y) {
        return (int) ((y/1080) * (double) Options.screenHeight);
    }
    public void initiateScroll(String backgroundImage) {
        GreenfootImage bg = new GreenfootImage(backgroundImage); // creates an image to scroll (adjust as needed)
        bg.scale(Options.screenWidth * 2, Options.screenHeight * 5);
        
        Globals.selectedLevel = Globals.lastLevel;
        
        scroller = new Scroller(this, bg, Options.screenWidth * 2, Options.screenHeight * 5); 
        scrollActor = new SelectorCharacter("green"); 
        addObject(scrollActor, getLevelX(Globals.selectedLevel), getLevelY(Globals.selectedLevel));
        
        if (Globals.selectedLevel <= 12) {
            scroll(Options.screenWidth * 2, getLevelY(Globals.selectedLevel) - Options.screenHeight/2);
        } else if (Globals.selectedLevel <= 17) {
            scroll(getLevelX(Globals.selectedLevel), 0);
        } else {
            scroll(Options.screenWidth * 1, getLevelY(Globals.selectedLevel) - Options.screenHeight/2);
        }
    }
    public void scroll(int dsx2, int dsy2) {
        scroller.scroll(dsx2, dsy2);
    }
    public void act() {
        scroll();
        scrolledX = scroller.getScrolledX();
        scrolledY = scroller.getScrolledY();
    }
    public void scroll() {
        dsx = dsx + leftoverDsx;
        dsy = dsy + leftoverDsy;
        scroller.scroll((int) dsx, (int) dsy);
        leftoverDsx = dsx - (int) dsx;
        leftoverDsy = dsy - (int) dsy;
        dsx = 0;
        dsy = 0;
    }
} 
