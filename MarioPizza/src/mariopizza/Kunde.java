
package mariopizza;


public class Kunde {
    int nummer;
    String navn;

    public Kunde(int nummer, String navn) {
        this.nummer = nummer;
        this.navn = navn;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
    
}
