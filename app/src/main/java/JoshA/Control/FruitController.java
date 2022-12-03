
//My Controller class

package JoshA.Control;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RequestHeader; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import java.util.HashMap;
import JoshA.DataBox.Fruit;
import JoshA.Service.FruitService;

@RestController
@RequestMapping(path = "/JoshFruit")
public class FruitController{
    
    @Autowired
    public FruitService fruitServ;
    
    @GetMapping(path = "/Fruit", produces = "application/json")
    public ResponseEntity<Object> getFruit(){
        //Get all fruit bean using service provider
        return new ResponseEntity<>(fruitServ.getFruit(),HttpStatus.OK);
        //
    }
    
    
    @GetMapping(path = "/Fruit/{No1}/{No2}", produces = "application/json")
    public ResponseEntity<Object> getFruitX(@PathVariable("No1") Integer No1, @PathVariable("No2") Integer No2){
        //Get two specific fruit bean with index from request path using service provider
        if(fruitServ.getFruitX(No1,No2)==null){
            //
            String str = "\nEither MapKey/FruitIndex "+No1+" or "+No2+" doesnt exist!!.\n Try getting MapKey/FruitIndex 1 and 2 if you have not deleted them.\n";
            return new ResponseEntity<>(str,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(fruitServ.getFruitX(No1,No2),HttpStatus.OK);
    }
    
    
    @PostMapping(path = "/Fruit/Create/{FruitIndex}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createFruit(@RequestBody Fruit fruitp, @PathVariable("FruitIndex") Integer FruitIndex){
        //Create a fruit bean element in map using service provider
        fruitServ.createFruit(fruitp,FruitIndex);
        //
        return new ResponseEntity<>("\nFruit is created successfully\n", HttpStatus.CREATED);
        //
    }
    
    
    @PutMapping(path = "/Fruit/Update/{FruitIndex}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> update(@RequestBody Fruit fruitp, @PathVariable("FruitIndex") Integer FruitIndex){
        //Update a fruit bean element in map using service provider
        fruitServ.updateFruit(fruitp,FruitIndex);
        //
        String str = "\nIndex "+FruitIndex+" of Fruit has been sucessfully updated\n";
        
        return new ResponseEntity<>(str, HttpStatus.OK);
        //
    }
    
    @DeleteMapping(path = "/Fruit/Delete/{FruitIndex}")
    public ResponseEntity<Object> delete(@PathVariable("FruitIndex") Integer FruitIndex){
        //Delete a fruit bean element in map using service provider
        fruitServ.delete(FruitIndex);
        
        String str = "\nIndex "+FruitIndex+" of Fruit has been deleted sucessfully\n";
        
        return new ResponseEntity<>(str, HttpStatus.OK);
        //
    }
    
    @RequestMapping(path = "/Exit")
    public ResponseEntity<Object> Exit(){
        //Exit app
        return new ResponseEntity<>("\nShutting down server...\n", HttpStatus.OK);
    }
}




//Sending GET request
//Browsers: http://localhost:9090/JoshFruit/Fruit
//Shell: curl http://localhost:9090/JoshFruit/Fruit
//THE ABOVE IS FOR .getFruit()

//Browsers: http://localhost:9090/JoshFruit/Fruit/1/2
//Shell: curl http://localhost:9090/JoshFruit/Fruit/1/2
//THE ABOVE IS FOR .getFruitX()


//Sending DELETE request
//Shell: curl -X "DELETE" http://localhost:9090/JoshFruit/Fruit/Delete/3
//THE ABOVE IS FOR .delete(..)


//Sending POST request
//Shell: curl -H "Content-Type: application/json" -X POST -d '{"numberOfFruit":25,"orange":{"numberOfOrange":25,"amount":2500},"apple":{"numberOfApple":25,"amount":12500},"lemon":{"numberOfLemon":25,"amount":7500}}' http://localhost:9090/JoshFruit/Fruit/Create/6
//THE ABOVE IS FOR .createFruit(..)


//Shell: curl -X PUT -d '{"numberOfFruit":15,"orange":{"numberOfOrange":15,"amount":1500},"apple":{"numberOfApple":15,"amount":7500},"lemon":{"numberOfLemon":15,"amount":4500}}' -H "Content-Type: application/json" http://localhost:9090/JoshFruit/Fruit/Update/6
//THE ABOVE IS FOR .update(..)



//In order to exist this program:
//Browsers: For the sake of this FruitController example-->http://localhost:9090/JoshFruit/Exit

//Shell: For the sake of this FruitController example-->curl http://localhost:9090/JoshFruit/Exit