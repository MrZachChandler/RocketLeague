import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pointer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pointer extends Actor
{
    /**
     * Act - do whatever the Pointer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MouseInfo info = Greenfoot.getMouseInfo();
        if (info != null)
        {
            setLocation(info.getX(), info.getY());
        }
    } 
    public Pointer()
    {
        GreenfootImage i = new GreenfootImage("ball.png");
        i.setTransparency(0);
        setImage(i);
    }
}