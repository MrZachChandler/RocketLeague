import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class cartoonSky here.
 * 
 * @author Zach Chandler
 * @version feb 27 2014
 */
public class Launch extends World
{
    private static final int EASY = 1000;
    private static final int HARD = 2500;
    private static final int HARDER = 5000;
    private static final int SCALE1 = 37;
    private static final int SCALE2 = 75;
    private static final int SCALE3 = 150;
    private GreenfootImage bgImage = new GreenfootImage("clouds.png");
    private static int speed = 1;
    public static int distance = 0;
    private GreenfootImage movingImage;
    private int movingPosition = 0;
    public int addPower = 1000;
    public int addGas = 200;
    public int addHeart = 1000;
    public static boolean winner = false;
    
    /**
     * Constructor for objects of class cartoonSky.
     * 
     */
    public Launch()
    {    
        // Create a new world with 800x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1); 
       

        //Greenfoot.playSound("AssaultOnMistCastle.mp3");//back ground music
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
        getBackground().drawString("b- Boost - Click to shoot -- Rocket follows the mouse",50,380);
        getBackground().drawString("Space Race Level 1",50,320);
        getBackground().drawString("DON'T TOUCH THE BALLOONS!!!   Dont run out of health or time",50,335);
        getBackground().drawString("Goal Distance 10,000",50,350);
        getBackground().drawString("Green dots - add Time--Blue dots - add Boost--Heart - add Health",50,365);
    }
    public void act()
    {
        if(speed > 0 && movingPosition <= 0)
        {
            movingPosition = getWidth();
        }
        if(speed < 0 && movingPosition >= getWidth())
        {
            movingPosition = 0;
        }
        movingPosition -= speed;
        distance++;
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
    public static void setSpeed(int s)
    {
            speed = s;
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
                Balloon b = new Balloon();
                b.setScale(1);
                addObject(b,790, Greenfoot.getRandomNumber(400));
            }
        }
    }
    public void attack2()
    {
        if(getDistance() < HARD && getDistance() > EASY)
        {
            if(Greenfoot.getRandomNumber(150) < 2)
            {
                Balloon b = new Balloon();
                b.setScale(2);
                addObject(b,790, Greenfoot.getRandomNumber(400));
            }
        }
    }
    public void attack3()
    {
        if(getDistance() > HARD)
       {
            if(Greenfoot.getRandomNumber(180) < 2)
            {
                Balloon b = new Balloon();
                b.setScale(3);
                addObject(b,790, Greenfoot.getRandomNumber(400));
            }
        }
    }
    public void attack4()
    {
        if(getDistance() > HARDER)
       {
            if(Greenfoot.getRandomNumber(180) < 2)
            {
                Balloon b = new Balloon();
                
                addObject(b,790, Greenfoot.getRandomNumber(400));
            }
            else if(Greenfoot.getRandomNumber(150) < 2)
            {
                Balloon b = new Balloon();
                b.setScale(2);
                addObject(b,790, Greenfoot.getRandomNumber(400));
            }
            else if(Greenfoot.getRandomNumber(100) < 2)
            {
                Balloon b = new Balloon();
                b.setScale(1);
                addObject(b,790, Greenfoot.getRandomNumber(400));
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
            World w = new Space();
            Greenfoot.setWorld(w);
            
        }
    }
    public static boolean getWinner()
    {
        return winner;
    }
    public static void setDistance(int d)
    {
        distance = d;
    }
    public static int getSpeed()
    {
        return speed;
    }
}
