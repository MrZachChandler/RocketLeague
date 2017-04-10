import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gas extends Basic
{
    /**
     * Act - do whatever the Gas wants to do. This method is called whenever
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
