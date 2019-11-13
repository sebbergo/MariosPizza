package mariopizza.View;

import java.util.ArrayList;
import mariopizza.Model.Bestilling;
import mariopizza.Model.Pizza;

public class StatistikKunde {

    public static Pizza getKundeFavPiz(int id) {
        Pizza tempPizza = null;
        int[] antal = new int[Statistik.getKunder().size()];
        ArrayList<Pizza> kundensPizzaer = pizzaerKøbAfKunde()[id];
        int most = 0;
        for (Pizza pizza : kundensPizzaer) {
            if (antal[most] < antal[pizza.getNummer() - 1]) {
                most = pizza.getNummer() - 1;
            }
            antal[pizza.getNummer() - 1]++;
        }

        return Menukort.getAllePizzaer().get(most);
    }

    public static ArrayList<Pizza>[] pizzaerKøbAfKunde() {
        ArrayList<Pizza>[] købtPiz = new ArrayList[Statistik.getKunder().size()];

        for (int i = 0; i < Statistik.getKunder().size(); i++) {
            købtPiz[i] = new ArrayList<Pizza>();
        }

        for (Bestilling bes : Statistik.getBestillinger()) {
            for (Pizza pizza : bes.getPizza()) {
                købtPiz[bes.getKundeId() - 1].add(pizza);
            }
        }
        return købtPiz;
    }

    public static int[] kundeAntalKøbtePizzaer() {
        ArrayList<Pizza>[] købtPiz = pizzaerKøbAfKunde();
        int[] antal = new int[Statistik.getKunder().size()];
        for (int i = 0; i < antal.length; i++) {
            for (Pizza piz : købtPiz[i]) {
                antal[i]++;
            }
        }
        return antal;
    }
    
    public static Bestilling getLastOrder(int id ){
        
        int bestillingsID = 0;
        for (Bestilling bestilling : Statistik.getBestillinger()) {
            if(bestilling.getKundeId() == id){
                bestillingsID = bestilling.getId();
            } 
        }
        return Statistik.getBestillinger().get(bestillingsID);
    }
    
    public static double getKundebeløbBrugt(int id){
        ArrayList<Pizza> kundensPizzaer = pizzaerKøbAfKunde()[id];
        double beløb = 0;
        for (Pizza pizza : kundensPizzaer) {
            beløb += pizza.getPris();
        }
        return beløb;
    }
}
