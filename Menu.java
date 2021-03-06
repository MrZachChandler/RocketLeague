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
public class Menu extends World
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 50;
    private int addUFO = 400;
    public static int ufoCount =0;
    public int addBulls = 0;
    public static GreenfootSound backgroundMusic = new GreenfootSound("Smash_Bros_Melee__Menu_1.wav");
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1); 
        addObject(new Grass(), 400,397);
        addObject(new menuCow(), 707 ,372);
        addObject(new LOGO(), 600 ,142);
        addObject(new menuCow(), 533 ,372);
        addObject(new menuCow(), 400 ,372);
        addObject(new menuCow(), 233 ,372);
        addObject(new menuCow(), 53 ,372);
        addObject(new BACKTOMENU(), 627 ,352);
        addObject(new Button(),110,50);
        addObject(new Level(),300,50);
        getBackground().drawString("Level Select",270,90);
        getBackground().drawString("Start Race!",78,90);
        addObject(new Instructions(),200,50);
        getBackground().drawString(" Instuctions",168,90);
        backgroundMusic.playLoop();

    }
    public void act() 
    {
        addUFO++;
        addUFOCheck();
        addBulls++;
        addBull();
        play();
    }  
    public void addUFOCheck()
    {
        if(addUFO >= 400 && ufoCount != 1)
        {
            addObject(new ufoMenu(), 790,Greenfoot.getRandomNumber(180));
            ufoCount =1;
            addUFO = 0;
        }
        if(true)
        {
            if(Greenfoot.getRandomNumber(230) < 2)
            {
                Balloon b = new Balloon();
                b.setScale(1);
                addObject(b,790, Greenfoot.getRandomNumber(400));
            }
        }
    }
    public void addBull()
    {
        if(addBulls == 600)
        {
            addObject(new menuBull(),790,372);
            addBulls = 0;
        }
        
    }
    public void play()
    {
        backgroundMusic.playLoop();
    }
}


