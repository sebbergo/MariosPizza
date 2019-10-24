
package mariopizza;

import java.util.ArrayList;


public class Bestilling {
    private String tid;
    private ArrayList <Pizza> pizza = new ArrayList();

    public Bestilling(String tid, String pizzaNummer) {
        this.tid = tid;
        String[] pizzaer = pizzaNummer.split(",");
        int[] pizzaerNummer = new int [pizzaer.length];
        
        for(int i = 0; i < pizzaer.length; i++){
            pizzaerNummer[i] = Integer.parseInt(pizzaer[i]);
            pizza.add(Menukort.pizzaChecker(pizzaerNummer[i]));
            }
        }
    
    public String printBes(){
        String retVal = "Pizzatype: ";
        for(Pizza p: pizza){
            retVal += p.getNavn() + ",";
        }
        return retVal;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
    
    
    }
    //Bestilling("18:30", "14,1,10,10");

