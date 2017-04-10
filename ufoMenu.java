import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class ufo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ufoMenu extends Basic
{
    /**
     * Act - do whatever the ufo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage im1 = new GreenfootImage("ufopng.png");
    private GreenfootImage im2 = new GreenfootImage("uforay.png");
    private boolean c1 = true, c2 = true, c3 = true, c4 = true, c5 = true; 
    public static int cowLocX = 53;
    public int cowLocy = 2;
    public boolean a = false;
    private int balloonDrop = 100;
    public ufoMenu()
    {
        setImage(im1);
    }
    public void act() 
    {
        
        if(getX() != cowLocX){
            
            setLocation(getX()-1,getY());
        }
        else if(a == true)
        {
            setLocation(getX()-1,getY()-2);
        }
        if(getX() == cowLocX)
        {
                setLocation(cowLocX,getY()+1);
                setImage(im2);
                if(this.canSee(menuCow.class))
                {
                    List objects = getObjectsInRange(30, menuCow.class);
                    menuCow cow = (menuCow)objects.get(0);
                    getWorld().removeObject(cow);
                    setImage(im1);
                    setLocation(getX()-1,getY()-2);
                    a = true;
                    if(cowLocX == 53)
                    {
                        cowLocX = 233;
                        
                    }
                    else if(cowLocX == 400)
                    { 
                        cowLocX = 533;
                        
                    }
                    else if(cowLocX == 707)
                    {
                        cowLocX = -1;
                        
                    }
                    else if(cowLocX == 533)
                    {
                        cowLocX = 707;
                    }
                    else if(cowLocX == 233)
                    {
                        cowLocX = 400;
                    }
                    
                }
            }
        dropBalloon();
        balloonDrop--;
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
    public boolean getCow()
    {
        List objects = getObjectsInRange(150, menuCow.class);
        menuCow cow = (menuCow)objects.get(0);
        do
        {
            cow.setLocation(cow.getX(),getY()-1);
        }while(cow.getX() != getX());
        if(this.canSee(menuCow.class))
        {
            getWorld().removeObject(cow);
            return true;
        }
        else
        {
            return false;
        }
    }
        public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }
    public void dropBalloon()
    {
        if(balloonDrop == 0)
        {
            balloonDrop = 200;
            getWorld().addObject(new Balloon(), getX(),getY());
        }
    }
    public void checkWorld()
    {
        if(canSee(menuBull.class) )
        { 
            getWorld().addObject(new Fire(),getX(),getY());
            Menu.ufoCount = 0;
            
            Greenfoot.playSound("explosion.wav");
            getWorld().removeObject(this);
        }
        else if(atWorldEdge())
        {
           Menu.ufoCount = 0;
           getWorld().removeObject(this);
        }
    }
}
