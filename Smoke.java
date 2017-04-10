import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Smoke here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Smoke extends Basic
{
    /**
     * Act - do whatever the Smoke wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int alive = 0;
    public void act() 
    {
        if(alive == 20)
        {
            getWorld().removeObject(this);
        }
        alive++;
        move(speed);
    }    
}
