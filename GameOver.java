import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver1.
     * 
     * 
     */
    private static int speed = 1;
    private GreenfootImage bgImage = new GreenfootImage("ufostars.png");
    public static int distance = 0;
    private GreenfootImage movingImage;
    private int movingPosition = 0;
    private int addUFO = 400;
    public static int ufoCount =0;
    public int addBulls = 0;
    public GameOver()
    {    
        super(800,400,1);
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels. 
        GreenfootImage background = new GreenfootImage(800,400);
        addObject(new Grass(), 400,397);
        addObject(new menuCow(), 707 ,372);
        addObject(new menuCow(), 533 ,372);
        addObject(new menuCow(), 400 ,372);
        addObject(new menuCow(), 233 ,372);
        addObject(new menuCow(), 53 ,372);
        addObject(new BACKTOMENU(), 627 ,352);
        movingImage = getMovingImage(800,400);
        background.drawImage(movingImage,0,0);
        setBackground(background);
    }
    public void act()
    {
        if(speed > 0 && movingPosition <= 0)
        {
            movingPosition = getWidth();
        }
        if(speed < 0 && movingPosition >= getWidth())
        {
            movingPosition = 0;
        }
        movingPosition -= speed;
        distance++;
        fill(movingPosition);
        addUFO++;
        //addUFOCheck();
        addBulls++;
        //addBull();
        
        ScoreBoard sb = new ScoreBoard("GAME OVER", "Distance: ", "Goal: 7000",Launch.getDistance());
        addObject(sb,418,185);
    }
    public void fill(int loc)
    {
        GreenfootImage currentBg = getBackground();
        currentBg.drawImage(movingImage,loc,0);
        currentBg.drawImage(movingImage,loc-movingImage.getWidth(),0);
    }
    public GreenfootImage getMovingImage(int width, int height)
    {
        GreenfootImage image = new GreenfootImage(width, height);
        for(int x = 0; x < width; x += bgImage.getWidth()) {
            for(int y = 0; y < height; y += bgImage.getHeight()) {
                image.drawImage(bgImage, x+15, y);
            }
        }
        return image;
    }
    public void addUFOCheck()
    {
        if(addUFO >= 400 && ufoCount != 1)
        {
            addObject(new ufoMenu(), 790,Greenfoot.getRandomNumber(180));
            ufoCount =1;
            addUFO = 0;
        }
        if(true)
        {
            if(Greenfoot.getRandomNumber(230) < 2)
            {
                Balloon b = new Balloon();
                b.setScale(1);
                addObject(b,790, Greenfoot.getRandomNumber(400));
            }
        }
    }
    public void addBull()
    {
        if(addBulls == 600)
        {
            addObject(new menuBull(),790,372);
            addBulls = 0;
        }
        
    }
}
