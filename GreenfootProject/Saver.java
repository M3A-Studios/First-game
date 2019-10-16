import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.io.*;
import java.util.Scanner;
public class Saver extends Actor
{
    public Saver()
    {
    } 
    public static void createSave() {
        BufferedWriter file = null;
        try {
            file = new BufferedWriter(new FileWriter("save.txt"));
            file.write("");
            file.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            try {
                file.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
    public static void saveGame() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("save.txt"));
            
            bw.write("MaxLevel:" + Globals.level +"\n" + "LastLevel:" + Globals.lastLevel +"\n" + "SelectedLevel:" + Globals.selectedLevel +"\n" + "Coins:" + Globals.coins +"\n" 
                    + "Score:" +Globals.score +"\n");
            bw.newLine();
            
            bw.close();
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
        }
    } 
    public static void loadGame() {
        File readFile = new File("save.txt"); //set what file to read
        if (!readFile.exists()){
            createSave();
        }
        Scanner dataReader = null; //scanner for the file
        try
        {
            dataReader = new Scanner(readFile); //try to read the file
        }
        catch(IOException e) //error report
        {
            System.out.println("File Read error" + e); //show error
        }
        while(dataReader.hasNext()) //while there's a next line
        {
           String line = dataReader.next(); //line is next line
           if (line.contains("MaxLevel:")) {
               line = line.replaceAll("MaxLevel:","");
               Globals.level = Integer.parseInt(line);
           }
           if (line.contains("LastLevel:")) {
               line = line.replaceAll("LastLevel:","");
               Globals.lastLevel = Integer.parseInt(line);
           }
           if (line.contains("SelectedLevel:")) {
               line = line.replaceAll("SelectedLevel:","");
               Globals.selectedLevel = Integer.parseInt(line);
           }
           if (line.contains("Coins:")) {
               line = line.replaceAll("Coins:","");
               Globals.coins = Integer.parseInt(line);
           }
           if (line.contains("Score:")) {
               line = line.replaceAll("Score:","");
               Globals.score = Integer.parseInt(line);
           }
        }
        dataReader.close();
        if (Globals.level != 0) {
            Greenfoot.setWorld(new LevelSelector());
        } else {
            Greenfoot.setWorld(new Tutorial());
        }
    } 
} 
