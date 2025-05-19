import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * This elephant is the hero in this game
 * @author (your name) Frank
 * @version (a version number or a date) May 2025
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] heroRight = new GreenfootImage[8];
    GreenfootImage[] heroLeft = new GreenfootImage[8];
    
    boolean canUseSpace = false;
    int lastPowerScore = 0;
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    
    public Elephant()
    {
        for(int i = 0 ; i<heroRight.length;i++)
        {
             heroRight[i] = new GreenfootImage("images/elephanthero/hero"+i+".png"); 
             heroRight[i].scale(100,100);
        }
        for(int i = 0 ; i<heroLeft.length;i++)
        {
             heroLeft[i] = new GreenfootImage("images/elephanthero/hero"+i+".png"); 
             heroLeft[i].mirrorHorizontally();
             heroLeft[i].scale(100,100);
        }
        
        animationTimer.mark();
        setImage(heroRight[0]);
    }
    int imageIndex = 0;
    public void animateElephant()
    {
       if(animationTimer.millisElapsed() < 100)
       {
           return;
       }
       animationTimer.mark();
       if(facing.equals("right"))
       {
           setImage(heroRight[imageIndex]);
           imageIndex = (imageIndex + 1) % heroRight .length; 
       }
       else
       {
           setImage(heroLeft[imageIndex]);
           imageIndex = (imageIndex + 1) % heroLeft .length; 
       }
       
    }
    
    
    
    public void act()
    {   
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
            facing = "left";
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            move(2);
            facing = "right";
        }
        eat();
        
        animateElephant();
    }
        
        //ELEPHANT EAT
        
    /**
     * This method we want create a new apple after the apple is eaten by
     * the elephants.
     */
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
}

