
package mariopizza;

import java.util.ArrayList;


public class Menukort {
    static ArrayList <Pizza> allePizzaer = new ArrayList();
    Pizza pep = new Pizza(1,"pep",100,"Tomat, Pep, ost");
    Pizza ost = new Pizza(2,"ost",90,"Tomat, ost");
    Pizza tomat = new Pizza(3,"tomat",80,"Tomat");
    
    
    
    public static Pizza pizzaChecker(int nummer){
        for(Pizza pizza: allePizzaer){
            if(pizza.getNummer() == nummer){
                return pizza;
            }
        }
        return null;
    }
}
