
package mariopizza;

import java.util.ArrayList;


public class Bestilling {
    String tid;
    ArrayList <Pizza> pizza = new ArrayList();

    public Bestilling(String tid, String pizzaNummer) {
        this.tid = tid;
        String[] pizzaer = pizzaNummer.split(",");
        int[] pizzaerNummer = new int [pizzaer.length];
        
        for(int i = 0; i < pizzaer.length; i++){
            pizzaerNummer[i] = Integer.parseInt(pizzaer[i]);
            pizza.add(Menukort.pizzaChecker(pizzaerNummer[i]));
            }
        }
    
    public void printBes(){
        for(Pizza p: pizza){
            System.out.println(p.getNavn());
        }
    }
    }
    //Bestilling("18:30", "14,1,10,10");

