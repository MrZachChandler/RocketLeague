import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bolt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bolt extends Basic
{
    /**
     * Act - do whatever the Bolt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       move(speed);
       GreenfootImage image = getImage();
       image.scale(25, 25);
       checkEdge();
    }    
}
