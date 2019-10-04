import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList;
import java.util.Arrays;

public class Levels extends World
{
    public static boolean check(Integer[] arr, int toCheckValue) {
        boolean test
                = Arrays.asList(arr)
                .contains(toCheckValue);
        return test;
    }
    public Levels()
    {    
        super(600, 400, 1); 
    } 
    public Levels(int x, int y, int cellsize, boolean idk) {
        super(x, y, cellsize, idk);
    }
}
