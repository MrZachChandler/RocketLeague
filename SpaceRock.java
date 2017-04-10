import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceRock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceRock extends Basic
{
    private static final int SCALE1 = 37;
    private static final int SCALE2 = 75;
    private static final int SCALE3 = 120;
    private int scale = 1;
    private int damage = 5;
    private GreenfootImage im2 = new GreenfootImage("explosion-big.png");
    /**
     */
    public void act() 
    {    
        remove();
    }
    public void remove()
    {
        GreenfootImage image = getImage();
        World w = getWorld();
        if(scale == 1)
        {
            image.scale(SCALE1, SCALE1);
            move(speed);
            if(canSee(Bullet.class))
            {
               Fire s = new Fire();
               w.addObject(s, getX(),getY());
               w.removeObject(this);
               Greenfoot.playSound("explosion.wav");
            }
            else if(atWorldEdge())
            {
                w.removeObject(this);
                
            }
        }
        if(scale == 2)
        {
            image.scale(SCALE2, SCALE2);
            move(speed);
            int health2 = 20;
            if(atWorldEdge())
            {
               w.removeObject(this);
            }
            else if(canSee(Bullet.class))
            {

                    int x = getX();
                    int y = getY();
                    Actor actor = getOneObjectAtOffset(0, 0, Bullet.class);
                    w.removeObject(actor);
                    w.removeObject(this);
                    Fire s = new Fire();
                    w.addObject(s, x,y);
                    Greenfoot.playSound("explosion.wav");
                    SpaceRock b1 = new SpaceRock();
                    b1.setScale(1);
                    SpaceRock b2 = new SpaceRock();
                    b2.setScale(1);
                    b1.turn(4);
                    b2.turn(-4);
                    w.addObject(b1,x+5,y+40);
                    w.addObject(b2,x-5,y-40);         
            }
            else if(canSee(Bull.class))
            {

                    int x = getX();
                    int y = getY();
                    w.removeObject(this);
                   
                    Greenfoot.playSound("explosion.wav");
                    SpaceRock b1 = new SpaceRock();
                    b1.setScale(1);
                    SpaceRock b2 = new SpaceRock();
                    b2.setScale(1);
                    b1.turn(4);
                    b2.turn(-4);
                    w.addObject(b1,x+5,y+40);
                    w.addObject(b2,x-5,y-40);         
            }
        }
        if(scale == 3)
        {
            image.scale(SCALE3, SCALE3);
            move(speed);
            if(atWorldEdge())
            {
               w.removeObject(this);
            }
            else if(canSee(Bullet.class))
            { 

                    int x = getX();
                    int y = getY();
                    Actor actor = getOneObjectAtOffset(0, 0, Bullet.class);
                    w.removeObject(actor);
                    Fire s = new Fire();
                    w.addObject(s, x,y);
                    w.removeObject(this);
                    Greenfoot.playSound("explosion.wav");
                    SpaceRock b1 = new SpaceRock();
                    b1.setScale(2);
                    SpaceRock b2 = new SpaceRock();
                    b2.setScale(2);
                    b1.turn(4);
                    b2.turn(-4);
                    w.addObject(b1,x+5,y+20);
                    w.addObject(b2,x-5,y-20);         
            }
            else if(canSee(Bull.class))
            {

                    int x = getX();
                    int y = getY();
                    w.removeObject(this);
                    Greenfoot.playSound("explosion.wav");
                    
                    SpaceRock b1 = new SpaceRock();
                    b1.setScale(1);
                    SpaceRock b2 = new SpaceRock();
                    b2.setScale(1);
                    SpaceRock b3 = new SpaceRock();
                    SpaceRock b4 = new SpaceRock();
                    b1.turn(4);
                    b2.turn(-4);
                    w.addObject(b1,x+5,y+40);
                    w.addObject(b2,x-5,y-40);
                    w.addObject(b3,x,y+20);
                    w.addObject(b4,x,y-20); 
            }
        }
    }
    public void setScale(int i)
    {
        scale = i;
    }

    public int getScale()
    {
        return scale;
    }
}
