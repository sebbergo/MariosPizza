package mariopizza;

import java.util.ArrayList;

public class MarioPizza {
    public static void main(String[] args) {      
        Menukort menukort = new Menukort();
        
        Menukort.printPizza();
        
        System.out.println("");
        
        Controller.tilføjBestilling("10:30", "1,2,1,1,1", "Preben", 0);
        Controller.tilføjBestilling("10:30", "1,2,1,1,1", "Preben", 0);
        
        Statistik stat = new Statistik();
        
        stat.printBestillingStat();

        System.out.println("");
        Controller.fjernBestilling(1);
        stat.printBestilling();
        
        stat.printBestillingStat();
        
        Controller.run();

    }
}
