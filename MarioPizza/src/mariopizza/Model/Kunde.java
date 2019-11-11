package mariopizza.Model;
//@author Marcus
public class Kunde {
    private int id;
    private int tlfNum;
    private String navn;
    private static int counter = 0;
    

    public Kunde(int nummer, String navn) {
        this.tlfNum = nummer;
        this.navn = navn;
        this.id = ++counter;
    }

    public int getId() {
        return id;
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
