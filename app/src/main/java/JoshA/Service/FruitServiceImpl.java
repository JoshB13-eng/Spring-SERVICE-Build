//An implementer of Service provider
package JoshA.Service;

import java.util.HashMap;
import java.util.Map;
import JoshA.DataBox.*;
import org.springframework.stereotype.Service;

@Service
public class FruitServiceImpl implements FruitService{
    
    public Map<Integer,Fruit> fruit;
    
    public FruitServiceImpl(){
        
        this.fruit = new HashMap();
        Fruit fruitObj = new Fruit();
        
        Apple apple = new Apple();
        apple.setNumberOfApple(5);
        apple.setAmount(500);
        
        Lemon lemon = new Lemon();
        lemon.setNumberOfLemon(5);
        lemon.setAmount(250);
        
        Orange orange = new Orange();
        orange.setNumberOfOrange(5);
        orange.setAmount(150);
        
        fruitObj.setNumberOfFruit(5);
        fruitObj.setApple(apple);
        fruitObj.setLemon(lemon);
        fruitObj.setOrange(orange);
        
        this.fruit.put(1,fruitObj);
        
        Fruit fruitObj2 = new Fruit();
        
        Apple apple2 = new Apple();
        apple2.setNumberOfApple(10);
        apple2.setAmount(1000);
        
        Lemon lemon2 = new Lemon();
        lemon2.setNumberOfLemon(10);
        lemon2.setAmount(600);
        
        Orange orange2 = new Orange();
        orange2.setNumberOfOrange(10);
        orange2.setAmount(300);
        
        fruitObj2.setNumberOfFruit(10);
        fruitObj2.setApple(apple2);
        fruitObj2.setLemon(lemon2);
        fruitObj2.setOrange(orange2);
        
        this.fruit.put(2,fruitObj2);
    }
    
    
    @Override public Map<Integer,Fruit> getFruit(){
        //Get all fruit bean
        return this.fruit;
    }
    
    @Override public Map<Integer,Fruit> getFruitX(Integer No1, Integer No2){
        //Get two specific fruit bean with index from request path
        if((!(this.fruit.containsKey(No1)))||(!(this.fruit.containsKey(No2)))){
            //
            return null;
        }
        
        
        Map<Integer,Fruit> SpecifiedHeader = new HashMap<>();
        //
        SpecifiedHeader.put(No1,this.fruit.get(No1));
        //
        SpecifiedHeader.put(No2,this.fruit.get(No2));
        
        return SpecifiedHeader;
    }
    
    @Override public void createFruit(Fruit fruitp,Integer FruitIndex){
        //Create a fruit bean element in map
        this.fruit.put(FruitIndex,fruitp);
    }
    
    @Override public void updateFruit(Fruit fruitp,Integer FruitIndex){
        //Update a fruit bean element in map 
        if(this.fruit.containsKey(FruitIndex)){
            //
            this.fruit.remove(FruitIndex);
        } 
        
        this.fruit.put(FruitIndex,fruitp);
    }
    
    @Override public void delete(Integer FruitIndex){
        //Delete a fruit bean element from map
        this.fruit.remove(FruitIndex);
    }
}