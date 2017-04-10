import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 200;

    /**
     * Create a score board for the final result.
     */
    public ScoreBoard(String title, String prefix, String goal, int Dist)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 25, 60);
        image.drawString(goal, 25, 110);
        image.drawString(prefix + Dist, 25, 170);
        setImage(image);
    }
    public void act()
    {
        restart();
    }
    public int getlocx()
    {
        return getX();
    }
    public int getlocy()
    {
        return getY();
    }
    public void restart()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Menu l = new Menu();
            Greenfoot.setWorld(l);
        }
    }
    

}
