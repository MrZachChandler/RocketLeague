import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

public class k extends Actor
{
    public static final float FONT_SIZE = 12.0f;
    public static final int WIDTH = 150;
    public static final int HEIGHT = 40;
    public GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
    /**
     * Create a score board for the final result.
     */
    public k()
    {
        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        //image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString("Distance: " + Space.getDistance(), 699,20 );
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
        image.clear();
        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString("Distance: " + Launch.getDistance(), 18, 20);
        setImage(image);
    }
    

}
