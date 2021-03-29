import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RobotWorld here.
 * 
 * @author Andrew Topmiller 
 * @version (a version number or a date)
 */
public class RobotWorld extends World
{

    /**
     * Constructor for objects of class RobotWorld.
     * 
     */
    public RobotWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        addObject(new Robot(), 30, 40);
        addObject(new Wall(), 50, 150);
        addObject(new Wall(), 150, 150);
        addObject(new Wall(), 250, 150);
        addObject(new Wall(), 550, 150);
        addObject(new Wall(), 650, 150);
        addObject(new Block(), 400, 150);
        addObject(new Home(), 650, 470);
        addObject(new Scorepanel(),80,470);
        addObject(new Pizza(),650,40);
    }
}
