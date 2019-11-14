package mariopizza.Model;

public class Kunde {

    int tlfNum;
    String navn;

    public Kunde(int tlfNummer, String navn) {
        this.tlfNum = tlfNummer;
        this.navn = navn;
    }

    public Kunde(String navn) {
        this.navn = navn;
    }

    public int getTlfNummer() {
        return tlfNum;
    }

    public void setTlfNummer(int tlfNummer) {
        this.tlfNum = tlfNummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

}
