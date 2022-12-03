
//Service provider
package JoshA.Service;

import java.util.HashMap;
import java.util.Map;
import JoshA.DataBox.Fruit;

public interface FruitService{
    
    public Map<Integer,Fruit> getFruit();
    
    public Map<Integer,Fruit> getFruitX(Integer No1, Integer No2);
    
    public void createFruit(Fruit fruit, Integer FruitIndex);
    
    public void updateFruit(Fruit fruit, Integer FruitIndex);
    
    public void delete(Integer FruitIndex);
}