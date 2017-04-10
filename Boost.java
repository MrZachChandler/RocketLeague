import greenfoot.*; 
import java.awt.*; 
import java.util.List;
/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boost extends Actor
{
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img = new GreenfootImage(300,120);
    public static int counter = 200;
    
    public Boost()
    {
        setImage(img);
        img.setColor(Color.BLACK);
        img.drawRect(9, 39, 201, 13);
        img.setColor(Color.BLUE);
        img.fillRect(10, 40, counter, 12);
    }
    public void act() 
    {
        setCounter();
        addBoost();
    } 
    public void setCounter()
    {
        if(Greenfoot.isKeyDown("b"))
        {
            if(counter > 0)
            {
               img.clear();
               counter--;
               img.setColor(Color.BLACK);
               img.drawRect(9, 39, 201, 13);
               img.setColor(Color.BLUE);
               img.fillRect(10,40,counter,12);
            }
        }
    }
    public static int getCounter()
    {
        return counter;
    }
    public void addBoost()
    {
        List checkBolt = getWorld().getObjects(Bolt.class);
        if(checkBolt.size() == 0)
        {
            return;
        }
        else
        {
            List objects = getObjectsInRange(1000, Bolt.class);
            Bolt b = (Bolt)objects.get(0);
            List objects1 = getObjectsInRange(1000, Rocket.class);
            Rocket r = (Rocket)objects1.get(0);
            if(r.canSee(Bolt.class))
            {
                getWorld().removeObject(b);
                Greenfoot.playSound("Sonic.Ring.mp3");
                if(counter <= 150)
                {
                   counter = counter + 50;
                   img.clear();
                   img.setColor(Color.BLACK);
                   img.drawRect(9, 39, 201, 13);
                   img.setColor(Color.BLUE);
                   img.fillRect(10,40,counter,12);
                }
                else if(counter == 0 || counter == -1)
                {
                   counter = 50;
                   img.clear();
                   img.setColor(Color.BLACK);
                   img.drawRect(9, 39, 201, 13);
                   img.setColor(Color.BLUE);
                   img.fillRect(10,40,counter,12);
                }
                else if(counter > 150)
                {
                   counter = 200;
                   img.clear();
                   img.setColor(Color.BLACK);
                   img.drawRect(9, 39, 201, 13);
                   img.setColor(Color.BLUE);
                   img.fillRect(10,40,counter,12);
                }
            }
        }
        
    }
    

    
}
