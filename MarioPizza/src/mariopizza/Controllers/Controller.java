package mariopizza.Controllers;
//@author Marc

import mariopizza.Model.Bestilling;
import java.util.Scanner;
import mariopizza.Model.Kunde;
import mariopizza.Model.Pizza;
import mariopizza.Util.DBCallsKunde;
import mariopizza.Util.DBCallsPizza;
import mariopizza.Util.ArrayListHolder;
import mariopizza.Util.ArrayListHolder;

public class Controller {


    public static void fjernPizza(int id){
        ArrayListHolder.getAllePizzaer().remove(ArrayListHolder.pizzaChecker(id));
        DBCallsPizza.deleteFromPizza(id);
    }
    
    public static double beregnenOrderPris(String pizzaer){
        double retVal = 0;
        String[] pizza = pizzaer.split(",");
        for (int i = 0; i < pizza.length; i++) {
            retVal += ArrayListHolder.pizzaChecker(Integer.parseInt(pizza[i])).getPris();
        }
        return retVal;
    }
    
    public static boolean checkIfStirngParseToInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
        public static boolean checkIfStringOnlyContainsPizza(String string) {
        try {
            String[] pizzaer = string.split(",");
            for(int i = 0; i < pizzaer.length; i++) {
                if(Integer.parseInt(pizzaer[i]) > ArrayListHolder.getAllePizzaer().size() + 1){
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    

}
