
package mariopizza;

import java.util.ArrayList;


public class Pizza {
    int nummer;
    String navn;
    int pris;
    String fyld;
    static int Counter = 1;

    public Pizza(String navn, int pris, String fyld) {
        this.navn = navn;
        this.fyld = fyld;
        nummer = Counter;
        Counter++;
    }
    
    //Pizza pep = new pizza(14, asdasda);

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }
}
