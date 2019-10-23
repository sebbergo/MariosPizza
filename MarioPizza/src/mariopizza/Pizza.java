
package mariopizza;

import java.util.ArrayList;


public class Pizza {
    int nummer;
    String navn;
    int pris;
    String fyld;

    public Pizza(int nummer, String navn, int pris, String fyld) {
        this.nummer = nummer;
        this.navn = navn;
        this.fyld = fyld;
    }
    
    //Pizza pep = new pizza(14, asdasda);

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }
}
