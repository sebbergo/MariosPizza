package mariopizza;

import java.util.ArrayList;


public class MarioPizza {
    ArrayList <Bestilling> bestillinger = new ArrayList();
    
    public void addBestilling(Bestilling bestilling){
        bestillinger.add(bestilling);
    }
        
}
