
package mariopizza;

import java.util.ArrayList;


public class Pizza {
    int nummer;
    int navn;
    ArrayList <Fyld> fyld = new ArrayList();

    public Pizza(int nummer, int navn) {
        this.nummer = nummer;
        this.navn = navn;
    }
    
    public void addFyld(Fyld tilføjFyld){
        fyld.add(tilføjFyld);
    }
    
}
