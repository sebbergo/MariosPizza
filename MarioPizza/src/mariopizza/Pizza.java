
package mariopizza;

import java.util.ArrayList;


public class Pizza {
    int nummer;
    String navn;
    int pris;
    ArrayList <Fyld> fyld = new ArrayList();

    public Pizza(int nummer, String navn, int pris) {
        this.nummer = nummer;
        this.navn = navn;
    }
    
    public void addFyld(Fyld tilføjFyld){
        fyld.add(tilføjFyld);
    }
    
}
