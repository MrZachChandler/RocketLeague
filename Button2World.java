import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button2World extends World
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 50;
    private int addUFO = 400;
    public static int ufoCount =0;
    public int addBulls = 0;
    //public static GreenfootSound backgroundMusic = new GreenfootSound("Smash_Bros_Melee__Menu_1.wav");
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Button2World()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1); 
        addObject(new Grass(), 400,397);
        addObject(new LOGO(), 600 ,142);
        addObject(new menuCow(), 707 ,372);
        addObject(new menuCow(), 533 ,372);
        addObject(new menuCow(), 400 ,372);
        addObject(new menuCow(), 233 ,372);
        addObject(new menuCow(), 53 ,372);
        addObject(new Example1(), 202 ,90);
        addObject(new Example2(), 202 ,130);
        addObject(new Example3(), 202 ,170);
        addObject(new BACKTOMENU(), 627 ,352);
        getBackground().drawString("Add Gas / Time",270,90);
        getBackground().drawString("HOME",617,320);
        getBackground().drawString("Add Boost",270,130);
        getBackground().drawString("Add Health",270,170);
        getBackground().drawString("Click to Shoot",270,210);
        getBackground().drawString("B - to Boost",270,230);
        getBackground().drawString("Rocket follows Mouse",270,270);
        getBackground().drawString("WARNING never get in front of a Bull",270,250);
        getBackground().drawString("MISSION: Follow the Balloons to find Aliens, Kill Aliens to Save Cows on farm!",100,290);
        //backgroundMusic.playLoop();

    }
    public void act() 
    {
       
        
        addBulls++;
        addBull();
        
    }  
    public void addBull()
    {
        if(addBulls == 600)
        {
            addObject(new menuBull(),790,372);
            addBulls = 0;
        }
        
    }

}


