
package mariopizza;

import java.util.ArrayList;


public class Pizza {
    private int nummer;
    private String navn;
    private int pris;
    private String fyld;
    private static int Counter = 1;

    public Pizza(String navn, int pris, String fyld) {
        this.navn = navn;
        this.fyld = fyld;
        this.pris = pris;
        nummer = Counter;
        Counter++;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }
    
    public String getFyld() {
        return fyld;
    }

    public void setFyld(String fyld) {
        this.fyld = fyld;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
    
    //Pizza pep = new pizza(14, asdasda);

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    @Override
    public String toString() {
        return "Navn: " + this.navn;
    }
    
}
