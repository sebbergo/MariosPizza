package mariopizza;

import java.util.ArrayList;

public class MarioPizza {
    public static void main(String[] args) {
//        Pizza pep = new Pizza("pep",100,"Tomat,Pep,ost");
//        Pizza ost = new Pizza("ost",90,"Tomat,ost");
//        Pizza tomat = new Pizza("tomat",80,"Tomat");
        
        Menukort menukort = new Menukort();
        
//        menukort.addPizza(pep);
//        menukort.addPizza(ost);
//        menukort.addPizza(tomat);
        
        Menukort.printPizza();
        System.out.println("");
        
        Kunde kunde1 = new Kunde(81924185, "Ali");
        
        Bestilling bes1 = new Bestilling("10:30", "1,2,1,1,1", kunde1);
        Statistik stat = new Statistik();
        stat.addBestilling(bes1);
        stat.printBestilling();
        System.out.println("");
        bes1.printBes();
        

    }
}
