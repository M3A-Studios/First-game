import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class LevelSelector extends World
{
    public static int level = 0;
    Scroller scroller; // the object that performs the scrolling
    Actor scrollActor; // an actor to stay in view*
    
    protected void renderWorld() {
        Actor levelNode = new LevelNode("Tutorial", 0);
        Actor levelNode1 = new LevelNode("Lava", 1);
        Actor levelNode2 = new LevelNode("Lava", 2);
        Actor levelNode3 = new LevelNode("Lava", 3);
        Actor levelNode4 = new LevelNode("Lava", 4);
        Actor levelNode5 = new LevelNode("Lava", 5);
        addObject(levelNode, getScaledX(3500), getScaledY(5100));
        addObject(levelNode1, getScaledX(3300), getScaledY(4900));
        addObject(levelNode2, getScaledX(3100), getScaledY(4700));
        addObject(levelNode3, getScaledX(3100), getScaledY(4500));
        addObject(levelNode4, getScaledX(3200), getScaledY(4300));
        addObject(levelNode5, getScaledX(3500), getScaledY(4100));
    }
    public LevelSelector() {
        super(Options.screenWidth, Options.screenHeight, 1, false);
        renderWorld();
        initiateScroll("test.png");
    }
    public int getScaledX(double x) {
        return (int) ((x/1920) * (double) Options.screenWidth);
    }
    public int getScaledY(double y) {
        return (int) ((y/1080) * (double) Options.screenHeight);
    }
    public void initiateScroll(String backgroundImage) {
        GreenfootImage bg = new GreenfootImage(backgroundImage); // creates an image to scroll (adjust as needed)
        bg.scale(Options.screenWidth * 2, Options.screenHeight * 5);
        
        scroller = new Scroller(this, bg, Options.screenWidth * 2, Options.screenHeight * 5); 
        scrollActor = new SelectorCharacter("green"); 
        addObject(scrollActor, Options.screenWidth * 2, Options.screenHeight * 5);
        
        scroll(Options.screenWidth * 2, Options.screenHeight * 5); //scroll relatively to 0,0 so directly to these cords
    }
    public void scroll(int dsx, int dsy) {
        scroller.scroll(dsx, dsy);
    }
} 
