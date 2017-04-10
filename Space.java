import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class cartoonSky here.
 * 
 * @author Zach Chandler
 * @version feb 27 2014
 */
public class Space extends World
{
    private static final int EASY = 1000;
    private static final int HARD = 3500;
    private static final int HARDER = 5000;
    private static final int SCALE1 = 37;
    private static final int SCALE2 = 75;
    private static final int SCALE3 = 150;
    private GreenfootImage bgImage = new GreenfootImage("space.jpg");
    public static int distance = 0;
    private GreenfootImage movingImage;
    private int movingPosition = 0;
    public int addPower = 1000;
    public int addGas = 200;
    public int addHeart = 1000;
    public static boolean winner = false;
    public int add = 600;
    /**
     * Constructor for objects of class cartoonSky.
     * 
     */
    public Space()
    {    
        // Create a new world with 800x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1); 
        distance = 0;
        addObject(new k(), 729,17);
        //Greenfoot.playSound("AssaultOnMistCastle.mp3");//back ground music
        Launch.setDistance(distance);
        GreenfootImage background = new GreenfootImage(800,400);
        movingImage = getMovingImage(800,400);
        background.drawImage(movingImage,0,0);
        setBackground(background);
        
        addObject(new Rocket(), 200 ,200);
        addObject(new Pointer(), 200, 300);
        
        getBackground().drawString("HEALTH",220,30);
        getBackground().drawString("BOOST",220,15);
        getBackground().drawString("TIME",220,46);
        getBackground().drawString("Distance: ",699,20);
        getBackground().drawString(getDistanceString(),759,20);
       
        addObject(new Boost(),150, 25);
        addObject(new Health(), 150,40);
        addObject(new Fuel(),150, 55);
    }
    public void act()
    {
        if(Launch.getSpeed() > 0 && movingPosition <= 0)
        {
            movingPosition = getWidth();
        }
        if(Launch.getSpeed() < 0 && movingPosition >= getWidth())
        {
            movingPosition = 0;
        }
        movingPosition -= Launch.getSpeed();
        distance++;
        Launch.setDistance(distance);
        fill(movingPosition);
        getBackground().drawString("HEALTH",220,30);
        getBackground().drawString("BOOST",220,15);
        getBackground().drawString("TIME",220,46);
        getBackground().drawString("Distance: ",699,20);
        getBackground().drawString(getDistanceString(),759,20);
        
        boltPop();
        heartPop();
        fuelPop();
        attack1();
        attack2();
        attack3();
        attack4();
        Stampeed();
        nextLevel();
    }
    public void fill(int loc)
    {
        GreenfootImage currentBg = getBackground();
        currentBg.drawImage(movingImage,loc,0);
        currentBg.drawImage(movingImage,loc-movingImage.getWidth(),0);
    }
    public GreenfootImage getMovingImage(int width, int height)
    {
        GreenfootImage image = new GreenfootImage(width, height);
        for(int x = 0; x < width; x += bgImage.getWidth()) {
            for(int y = 0; y < height; y += bgImage.getHeight()) {
                image.drawImage(bgImage, x+15, y);
            }
        }
        return image;
    }
    public static int getDistance()
    {
        return distance;
    }
    public void boltPop()
    {
        
        if(getDistance() > addPower)
        {
            addObject(new Bolt(),790, Greenfoot.getRandomNumber(400));
            addPower = addPower + 800;
        }
    }
    public void fuelPop()
    {
      
        List checkGas = getObjects(Gas.class);
        if( checkGas.size() == 0)
        {
            if(getDistance() > addGas)
            {
                addObject(new Gas(),790, Greenfoot.getRandomNumber(400));
                addGas = addGas + 100;
            }
        }
        
    }
    public String getDistanceString()
    {
        String temp = String.valueOf(distance);
        return temp;
    }
    public void attack1()
    {
        if(getDistance() < EASY)
        {
            if(Greenfoot.getRandomNumber(100) < 2)
            {
                SpaceRock s = new SpaceRock();
                s.setScale(1);
                addObject(s,790, Greenfoot.getRandomNumber(400));
            }
        }
    }
    public void attack2()
    {
        if(getDistance() < HARD && getDistance() > EASY)
        {
            if(Greenfoot.getRandomNumber(150) < 2)
            {
                SpaceRock s = new SpaceRock();
                s.setScale(2);
                addObject(s,790, Greenfoot.getRandomNumber(400));
            }
        }
    }
    public void attack3()
    {
        if(getDistance() > HARD)
       {
            if(Greenfoot.getRandomNumber(180) < 2)
            {
                SpaceRock s = new SpaceRock();
                s.setScale(3);
                addObject(s,790, Greenfoot.getRandomNumber(400));
            }
        }
    }
    public void attack4()
    {
        if(getDistance() > HARDER)
       {
            if(Greenfoot.getRandomNumber(180) < 2)
            {
                SpaceRock s = new SpaceRock();
                
                addObject(s,790, Greenfoot.getRandomNumber(400));
            }
            else if(Greenfoot.getRandomNumber(150) < 2)
            {
                SpaceRock s = new SpaceRock();
                s.setScale(2);
                addObject(s,790, Greenfoot.getRandomNumber(400));
            }
            else if(Greenfoot.getRandomNumber(100) < 2)
            {
                SpaceRock s = new SpaceRock();
                s.setScale(1);
                addObject(s,790, Greenfoot.getRandomNumber(400));
            }
            
        }
    }
    public void heartPop()
    {
      
        List checkGas = getObjects(Heart.class);
        if( checkGas.size() == 0)
        {
            if(getDistance() > addHeart)
            {
                addObject(new Heart(),790, Greenfoot.getRandomNumber(400));
                addHeart = addHeart + 2500;
            }
        }
        
    }
    public void nextLevel()
    {
        if(distance > 7000)
        {
            Rocket.backgroundMusic.pause();
            winner = true;
            addObject(new ScoreBoard("SUCCESS", "Next Level", "Click For" ,0), 418,185);
            World w = new Final();
            Greenfoot.setWorld(w);
        }
    }
    public void Stampeed()
    {
        if(distance == add)
        {
            addObject(new Bull(),790, Greenfoot.getRandomNumber(400));
            add +=900;
        }
    }
    public static boolean getWinner()
    {
        return winner;
    }
}
