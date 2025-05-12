import greenfoot.*;
public class MyWorld extends World {
    public MyWorld() {
        //create a new world
        super(600, 400, 1);
        
        //Create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant,300,200);
        
        //create a label
        Lable scoreLabel = new Lable;
        createApple();
    }
    
    
    public void createApple()
    {
        Apple apple = new Apple();
        int x =Greenfoot.getRandomNumber(600);
        int y =0;
        addObject(apple,x,y);
        
    }
}
