import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.*;
/**
 * Write a description of class Grass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grass extends Actor
{
    /**
     * Act - do whatever the Grass wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img = new GreenfootImage(800,50);
    public Grass()
    {
        setImage(img);
       img.setColor(Color.BLACK);
       img.drawRect(9, 39, 800, 50);
       img.setColor(Color.GREEN);
       img.fill();
    }
    
    public void act() 
    {
       
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
