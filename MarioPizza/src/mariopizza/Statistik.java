
package mariopizza;

import java.util.ArrayList;


public class Statistik {
    private  ArrayList <Bestilling> bestillinger = new ArrayList();
    
    
    public void addBestilling(Bestilling bestilling){
        bestillinger.add(bestilling);
    }
    
    public  void printBestilling(){
        for (Bestilling bestilling : bestillinger) {
            System.out.println(bestilling.getTid() + " , " + bestilling.printBes());
           
        }
    }
}
