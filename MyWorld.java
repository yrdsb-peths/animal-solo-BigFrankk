import greenfoot.*;
public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    public MyWorld() {
       
        //create a new world
        super(600, 400, 1,false);
        
        //Create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant,300,200);
        
        //create a label
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
        
        createApple();
    }
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("'Game Over",100);
        addObject(gameOverLabel,300,200);
    }
    /**
     * Increase our score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    public void createApple()
    {
        Apple apple = new Apple();
        int x =Greenfoot.getRandomNumber(600);
        int y =0;
        addObject(apple,x,y);
        
    }
}
