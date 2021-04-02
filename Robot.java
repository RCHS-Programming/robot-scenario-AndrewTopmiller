import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends Actor
{
    private GreenfootImage robotimage1;
    private GreenfootImage robotimage2;
    private GreenfootImage gameOver1;
    private int lives;
    private int score;
    private int pizzaEaten;
    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Robot()
    {
         robotimage1=new GreenfootImage("man01.png");
         robotimage2=new GreenfootImage("man02.png");
         gameOver1=new GreenfootImage("gameover.png");
         lives=3;
         score=0;
         pizzaEaten=0;
         
    }
    public void act() 
    {
       robotMovement();
       detectWallCollision();
       detectHome();
       eatPizza();
       dectectBlockCollision();
       endGame();
       showStatus();// Add your action code here.
    }   
    
    public void robotMovement()
    {
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation( getX(), getY() -3 );
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation( getX(), getY()  +3 );
        }
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation( getX()+3, getY() );
        }
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation( getX()-3, getY() );
        }
        if(getImage()== robotimage1)
        {
            setImage( robotimage2);
        }
        else
        {
            setImage ( robotimage1);
        } 
    }
    
    public void detectWallCollision()
    {
        if (isTouching(Wall.class))
        {
            setLocation(30, 40);
            lives = lives - 1;
            Greenfoot.playSound("hurt.wav");
            showStatus();
        }
    }
    public void dectectBlockCollision()
    {
        if (isTouching(Block.class))
        {
            setLocation(30, 40);
            lives = lives - 1;
            Greenfoot.playSound("hurt.wav");
            showStatus();
        }
    }
    public void detectHome()
    {
        if (pizzaEaten == 5 )
        {
            Greenfoot.stop();
            setLocation(30, 40);
            Greenfoot.playSound("yipee.wav");
            pizzaEaten = pizzaEaten - 5;
            showStatus();
        }
        if (isTouching(Home.class))
        {
            setLocation(30, 40);
            Greenfoot.playSound("yipee.wav");
            
        }
        increaseScore();
        showStatus();
    }
    public void eatPizza()
    {
        if (isTouching(Pizza.class))
        {
            removeTouching(Pizza.class);
            Greenfoot.playSound("eat.wav");
            pizzaEaten = pizzaEaten + 1;
            showStatus();
        }
    }
    public void endGame()
    {
        if (lives == 0 )
        {
            Greenfoot.stop();
        
            setImage(gameOver1);
        
        }
    }
    public void increaseScore()
    {
        if (isTouching(Home.class))
        {
            score = score + 1;
            showStatus();
        }
    }
    public void showStatus()
    {
        getWorld().showText("Lives : "+lives,70, 540);
        getWorld().showText("Pizzas: "+pizzaEaten, 70,560);
    }
}
