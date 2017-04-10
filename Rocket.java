import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Cat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Basic
{
    private GreenfootImage im1 = new GreenfootImage("rocket.png");
    private GreenfootImage im2 = new GreenfootImage("rockettry.png");
    private int wall = 200;
    //public static GreenfootSound backgroundMusic = new GreenfootSound("Smash_Bros_Melee__Menu_1.wav");
    public static GreenfootSound backgroundMusic = new GreenfootSound("GoD.J.wav");
    /**
     * Act - do whatever the Cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Rocket()
    {
        setImage(im1);
        Menu.backgroundMusic.pause();
    }
    public void act() 
    {
        backgroundMusic.playLoop();
        List objects = getObjectsInRange(1000, Pointer.class);
        if (!objects.isEmpty())
        {
            Pointer pointer = (Pointer)objects.get(0);
            int X = pointer.getX();
            int Y = pointer.getY();
            turnTowards(X,Y);
            int y = getY();
            
            if(pointer.getX() < wall || getX() < wall)
            {
                move(3);
            }
            if(getX() >= wall)
            {      
                if(y < pointer.getY())
                { 
                    setLocation(getX(),y + 2);
                }
                if(y > pointer.getY())
                { 
                    setLocation(getX(),y- 2);
                }
            }
            fire();
        }
        checkKeyPressed();
        checkWorld();
    }
    public void fire()
    {
        List objects = getObjectsInRange(1000, Pointer.class);
        World w = getWorld();
        Pointer pointer =(Pointer)objects.get(0);
        if(Greenfoot.mouseClicked(pointer))
        {
            int fireX = pointer.getX();
            int fireY = pointer.getY();
            int rocketX = getX();
            int rocketY = getY();
            Bullet b = new Bullet();
            w.addObject(b,rocketX,rocketY);
            b.turnTowards(fireX,fireY);
            
        }
    }
    public int getXLocation()
    {
        return getX();
    }
    public void checkKeyPressed()
    {
       List objects = getObjectsInRange(1000, Pointer.class);
       Pointer pointer =(Pointer)objects.get(0);
       if(Greenfoot.isKeyDown("b"))
       {
           
           if(Boost.getCounter()>0)
           {
               Launch.distance +=5;
               Launch.setSpeed(5);//all getWorlds were Launch
               Basic.setSpeed(-5);
               setImage(im2);
               if(pointer.getX() < wall || getX() < wall)
               {
                   move(5);
                }
            }
           else
           {
               Launch.setSpeed(2);
               Basic.setSpeed(-2);
           }
       }
       else
       {
           Basic.setSpeed(-2);
           Launch.setSpeed(2);
           setImage(im1);
       }
    }
    public void checkPowerUps()
    {
        if(canSee(Bolt.class))
        {
            eat(Bolt.class);
            List objects = getObjectsInRange(1000, Boost.class);
            Boost boost = new Boost();
            boost.addBoost();
        }
    }
    public void checkWorld()
    {
        if(canSee(Balloon.class) )
        {           
            List objects = getIntersectingObjects(Balloon.class);
            Balloon b =(Balloon)objects.get(0);
            int scaleTemp = b.getScale();
            getWorld().removeObject(b);
            Greenfoot.playSound("pop.wav");
            List health = getObjectsInRange(1000, Health.class);
            Health h = (Health)health.get(0);
            if(scaleTemp == 1)
            {
                h.setCounter(5);
            }
            else if(scaleTemp == 2)
            {
                h.setCounter(10);
            }
            else if(scaleTemp == 3)
            {
                h.setCounter(15);
            }
        }
        if(canSee(SpaceRock.class) )
        {           
            List objects = getIntersectingObjects(SpaceRock.class);
            SpaceRock b =(SpaceRock)objects.get(0);
            int scaleTemp = b.getScale();
            getWorld().removeObject(b);
            Greenfoot.playSound("explosion.wav");
            List health = getObjectsInRange(1000, Health.class);
            Health h = (Health)health.get(0);
            if(scaleTemp == 1)
            {
                h.setCounter(10);
            }
            else if(scaleTemp == 2)
            {
                h.setCounter(20);
            }
            else if(scaleTemp == 3)
            {
                h.setCounter(30);
            }
        }
        if(canSee(Bull.class) )
        { 
            List health = getObjectsInRange(1000, Health.class);
            Health h = (Health)health.get(0);
            h.setCounter(100);
        }
        if(canSee(Cow.class))
        {
            List health = getObjectsInRange(1000, Health.class);
            Health h = (Health)health.get(0);
            h.setCounter(15);
            Actor actor = getOneObjectAtOffset(0, 0, Cow.class);
            getWorld().removeObject(actor);
        }
    }
    
}
