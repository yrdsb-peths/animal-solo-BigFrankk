import greenfoot.*;
public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        
        Elephant elephant = new Elephant();
        addObject(elephant,300,200);
        
        Apple apple = new Apple();
        addObject(apple,300,0);
        
    }
    
    
    public void createApple()
    {
        Apple apple = new Apple();
        int x =Greenfoot.getRandomNumber(600);
        int y =Greenfoot.getRandomNumber(300);
        addObject(apple,x,y);
        
    }
}
