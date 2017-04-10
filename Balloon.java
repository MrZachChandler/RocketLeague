import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Balloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balloon extends Basic
{
    private static final int SCALE1 = 37;
    private static final int SCALE2 = 75;
    private static final int SCALE3 = 120;
    private int scale = 1;
    private int damage = 5;
    private GreenfootImage im2 = new GreenfootImage("explosion-big.png");
    /**
     * Act - do whatever the Balloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
               
               Smoke s = new Smoke();
                    w.addObject(s, getX(),getY());
               Greenfoot.playSound("pop.wav");
               w.removeObject(this);
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
                    Smoke s = new Smoke();
                    w.addObject(s, x,y);
                    Greenfoot.playSound("pop.wav");
                    Balloon b1 = new Balloon();
                    b1.setScale(1);
                    Balloon b2 = new Balloon();
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
                    w.removeObject(this);
                    Smoke s = new Smoke();
                    w.addObject(s, x,y);
                    Greenfoot.playSound("pop.wav");
                    Balloon b1 = new Balloon();
                    b1.setScale(2);
                    Balloon b2 = new Balloon();
                    b2.setScale(2);
                    b1.turn(4);
                    b2.turn(-4);
                    w.addObject(b1,x+5,y+20);
                    w.addObject(b2,x-5,y-20);         
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
