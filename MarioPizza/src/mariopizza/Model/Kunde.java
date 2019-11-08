package mariopizza.Model;
//@author Marcus
public class Kunde {

    int tlfNum;
    String navn;

    public Kunde(int nummer, String navn) {
        this.tlfNum = nummer;
        this.navn = navn;
    }

    public Kunde(String navn) {
        this.navn = navn;
    }

    public int getNummer() {
        return tlfNum;
    }

    public void setNummer(int nummer) {
        this.tlfNum = nummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

}
