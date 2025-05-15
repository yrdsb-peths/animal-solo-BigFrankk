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
    GreenfootImage[] hero = new GreenfootImage[8];
    
    public Elephant()
    {
        for(int i = 1 ; i<hero.length+1;i++)
        {
             hero[i] = new GreenfootImage("image/alephanthero/hero"+i+"png"); 
        }
        setImage(hero[0]);
    }
    int imageIndex = 0;
    public void animateElephant()
    {
       setImage(hero[imageIndex]);
       imageIndex = imageIndex = 1 % hero.length+1; 
    }
    
    
    public void act()
    {  
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
        
        //ELEPHANT EAT
        eat();
    }
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
