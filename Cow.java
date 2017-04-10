import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cow extends Basic
{
    /**
     * Act - do whatever the Cow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(8);
        checkEdge();
    }    
    public int getLocX()
    {
        return getX();
    }
    public int getLocY()
    {
        return getY();
    }
}
