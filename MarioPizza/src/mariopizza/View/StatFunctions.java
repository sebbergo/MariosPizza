package mariopizza.View;

import mariopizza.Util.ArrayListHolder;
import mariopizza.Model.Bestilling;
import mariopizza.Model.Kunde;
import mariopizza.Model.Pizza;


public class StatFunctions {
    
    public static int[] getAntalKøbtePizzaer() {
        int[] antalPizzaer = new int[ArrayListHolder.getAllePizzaer().size()];
        for (Bestilling bestilling : ArrayListHolder.getBestillinger()) {
            for (Pizza piz : bestilling.getPizza()) {
                antalPizzaer[piz.getNummer() - 1]++;
            }
        }
        return antalPizzaer;
    }
}
