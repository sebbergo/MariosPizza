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

    //Fjern bestilling fra bestillingsliste array, hvis bestillingen findes
    public static void fjernBestilling(int id) {
        Bestilling bes = ArrayListHolder.bestillingChecker(id);
        if (bes != null) {
            ArrayListHolder.removeBestilling(bes);
        }
    }
    
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
        System.out.println(retVal);
        return retVal;
    }
    
    public static int getKundeID(int tlf, String navn){
        int retVal = 0;
        for (Kunde kunde : ArrayListHolder.getKunder()) {
            if(kunde.getNummer() == tlf){
                kunde.setNavn(navn);
                return kunde.getId();
            }
        }
        Kunde tempKunde = new Kunde(tlf, navn);
        DBCallsKunde.insertToKunde(navn, tlf);
        ArrayListHolder.addKunde(tempKunde);
        
        return tempKunde.getId();
    }
}
