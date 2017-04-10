import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Basic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Basic extends Actor
{
    /**
     * Act - do whatever the PowerUps wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int speed = -2;
    public void act() 
    {
        // Add your action code here.
    }  
    public boolean atWorldEdge()  
    {  
        if(getX() < 10 || getX() > getWorld().getWidth() - 10)  
            return true;  
        if(getY() < 10 || getY() > getWorld().getHeight() - 10)  
            return true;  
        else  
            return false;  
    }
    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }
    public void eat(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
    }
    public static void setSpeed(int s)
    {
            speed = s;
    }
    public void checkEdge()
    {
        if(atWorldEdge())
        {
           getWorld().removeObject(this);
        }
    }
}


