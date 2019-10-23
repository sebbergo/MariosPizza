
package mariopizza;

import java.util.ArrayList;


public class Menukort {
    static ArrayList <Pizza> allePizzaer = new ArrayList();

    public void addPizza(Pizza pizza){
        allePizzaer.add(pizza);
    }
    
    public static void printPizza(){
        for(Pizza pizza: allePizzaer){
            System.out.println(pizza.getNummer());
        }
    }
    
    
    public static Pizza pizzaChecker(int nummer){
        for(Pizza pizza: allePizzaer){
            if(pizza.getNummer() == nummer){
                return pizza;
            }
        }
        return null;
    }
}
