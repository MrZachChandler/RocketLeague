import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Bull here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bull extends Basic
{
    /**
     * Act - do whatever the Bull wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage im; 
    private GreenfootImage im2; 
    private int count = 0;
    public Bull()
    {
        im =  new GreenfootImage("bull.png");
        im2 = new GreenfootImage("bull2.png");
        Greenfoot.playSound("Bull.wav");
        setImage(im2);
    }
    public void act() 
    {
        checkEdge();
        switchImage();
        move(-5);
    }    
    public void switchImage()
    {
        count++;
        if(getImage() == im && count < 5)
        {
            setImage(im2);
        }
        if(getImage() == im2 && count > 5)
        {
            setImage(im);
        }
        if(count == 10)
        {count = 0;}

    }
    public void life()
    {
        
    }
}
