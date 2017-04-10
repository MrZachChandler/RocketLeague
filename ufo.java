import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class ufo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ufo extends Basic
{
    /**
     * Act - do whatever the ufo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage im1 = new GreenfootImage("ufopng.png");
    private GreenfootImage im2 = new GreenfootImage("uforay.png");
    private int fireRate = 0;
    private int wall = 592;
    public int rando = 1;
    private int balloonDrop = 100;
    private int health = 3;
    public ufo()
    {
        setImage(im1);
    }
    public void act() 
    {
        if(getX() > wall)
        {
            setLocation(getX()-1,getY() - rando);
            if(atWorldEdge())
            {
                rando = rando * -1;
               
            }
        }
        else
        {
            setLocation(getX(),getY() - rando);
            if(atWorldEdge())
            {
                rando = rando * -1;
                
            }
        }
        fire();
        
        
        fireRate++;
        balloonDrop--;
        
        dropBalloon();
        checkWorld();
    }  
    public int getLocX()
    {
        return getX();
    }
    public int getLocY()
    {
        return getY();
    }
    public void fire()
    {
        if(fireRate == 100)
        {
            List objects = getObjectsInRange(1000, Rocket.class);
            World w = getWorld();
            Rocket r =(Rocket)objects.get(0);
            fireRate = 0;
            Cow cow = new Cow();
            w.addObject(cow,getX(),getY());
            cow.turnTowards(r.getX(),r.getY());
        }
    }
    public void checkWorld()
    {
        if(canSee(Bullet.class))
        {
            Actor actor = getOneObjectAtOffset(0, 0, Bullet.class);
            World w = getWorld();
            w.removeObject(actor);
            
            health--;
          
        }
        if(canSee(Bull.class) )
        { 
            getWorld().addObject(new Fire(),getX(),getY());
            Greenfoot.playSound("explosion.wav");
            getWorld().removeObject(this);
        }
        checkHealth();
    }
    public void checkHealth()
    {
        if(health == 0)
        {
            Fire f = new Fire();
            Greenfoot.playSound("explosion.wav");
            getWorld().addObject(f,getX(),getY());
            getWorld().removeObject(this);
        }
    }
        public void dropBalloon()
    {
        if(balloonDrop == 0)
        {
            balloonDrop = 100;
            getWorld().addObject(new Balloon(), getX(),getY());
        }
    }
    
}
