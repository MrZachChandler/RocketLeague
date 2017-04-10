import greenfoot.*; 
import java.awt.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img = new GreenfootImage(300,120);
    int counter = 200;
    
    public Health()
    {
        setImage(img);
        img.setColor(Color.BLACK);
        img.drawRect(9, 39, 201, 13);
        img.setColor(Color.RED);
        img.fillRect(10, 40, counter, 12);
    }
    public void act() 
    {
        redraw();
        addHealth();
        if(counter <= 0)
        {
            Rocket.backgroundMusic.pause();
            Greenfoot.playSound("gameover.mp3");
            GameOver go = new GameOver();
            Greenfoot.setWorld(go);
            
        }
    }  
    public void redraw()
    {
        img.clear();
        img.setColor(Color.BLACK);
        img.drawRect(9, 39, 201, 13);
        img.setColor(Color.RED);
        img.fillRect(10,40,counter,12);
    }
    public void setCounter(int damage)
    {
        if((counter -damage) < 0)
        counter = 0;
        else
        counter = counter - damage;
    }
    public int getCounter()
    {
        return counter;
    }
    public void addHealth()
    {
        List checkHeart = getWorld().getObjects(Heart.class);
        if(checkHeart.size() == 0)
        {
            return;
        }
        else
        {
            List objects = getObjectsInRange(1000, Heart.class);
            Heart h = (Heart)objects.get(0);
            List objects1 = getObjectsInRange(1000, Rocket.class);
            Rocket r = (Rocket)objects1.get(0);
            if(r.canSee(Heart.class))
            {
                getWorld().removeObject(h);
                Greenfoot.playSound("Sonic.Ring.mp3");
                if(counter <= 150)
                {
                    setCounter(-50); // -50 is addition of health
                    redraw();
                }
                else
                {
                    counter = 200;
                    redraw();
                }
            }
        }
    }
}
