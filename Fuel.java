import greenfoot.*; 
import java.awt.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fuel extends Actor
{
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img = new GreenfootImage(300,120);
    int counter = 200;
    int count = 0;
    public Fuel()
    {
        setImage(img);
        img.setColor(Color.BLACK);
        img.drawRect(9, 39, 201, 13);
        img.setColor(Color.GREEN);
        img.fillRect(10, 40, counter, 12);
    }
    public void act() 
    {
        if(count == 8)
        {
            redraw();
        }
        count ++;
        if(counter == 0)
        {
            Rocket.backgroundMusic.pause();
            Greenfoot.playSound("gameover.mp3");
            GameOver go = new GameOver();
            Greenfoot.setWorld(go);
            
        }
        addFuel();
    } 
    public void addFuel()
    {
        List checkGas = getWorld().getObjects(Gas.class);
        if(checkGas.size() == 0)
        {
            return;
        }
        else
        {
            List objects = getObjectsInRange(1000, Gas.class);
            Gas g = (Gas)objects.get(0);
            List objects1 = getObjectsInRange(1000, Rocket.class);
            Rocket r = (Rocket)objects1.get(0);
            if(r.canSee(Gas.class))
            {
                getWorld().removeObject(g);
                Greenfoot.playSound("Sonic.Ring.mp3");
                if(counter <= 150)
                {
                   counter = counter + 50;
                   img.clear();
                   img.setColor(Color.BLACK);
                   img.drawRect(9, 39, 201, 13);
                   img.setColor(Color.GREEN);
                   img.fillRect(10,40,counter,12);
                }
                else if(counter == 0)
                {
                   counter = 100;
                   img.clear();
                   img.setColor(Color.BLACK);
                   img.drawRect(9, 39, 201, 13);
                   img.setColor(Color.GREEN);
                   img.fillRect(10,40,counter,12);
                }
                else if(counter > 150)
                {
                   counter = 200;
                   img.clear();
                   img.setColor(Color.BLACK);
                   img.drawRect(9, 39, 201, 13);
                   img.setColor(Color.GREEN);
                   img.fillRect(10,40,counter,12);
                }
            }
        }
        
    }
    public String getCounterString()
    {
        String temp = String.valueOf(counter);
        return temp;
    }
    public void redraw()
    {
        counter--;
        count = 0;
        img.clear();
        img.setColor(Color.BLACK);
        img.drawRect(9, 39, 201, 13);
        img.setColor(Color.GREEN);
        img.fillRect(10, 40, counter, 12);
    }
}
