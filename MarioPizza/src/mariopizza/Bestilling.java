package mariopizza;

import java.util.ArrayList;

public class Bestilling {

    private String tid;
    private Kunde kunde;
    private ArrayList<Pizza> pizza = new ArrayList();
    
    private int id;
    private static int counter;

    public Bestilling(String tid, String pizzaNummer, String navn, int tlfnr) {
        this.tid = tid;
        this.id = ++counter;

        if (Statistik.checkKunde(tlfnr) == null) {
            kunde = new Kunde(tlfnr, navn);
        } else {
            Statistik.checkKunde(tlfnr).setNavn(navn);
        }

        String[] pizzaer = pizzaNummer.split(",");
        int[] pizzaerNummer = new int[pizzaer.length];

        for (int i = 0; i < pizzaer.length; i++) {
            pizzaerNummer[i] = Integer.parseInt(pizzaer[i]);
            pizza.add(Menukort.pizzaChecker(pizzaerNummer[i]));

        }
    }

    public Bestilling(String tid, String pizzaNummer, String navn) {
        this.tid = tid;
        this.kunde = new Kunde(navn);
        this.id = ++counter;

        String[] pizzaer = pizzaNummer.split(",");
        int[] pizzaerNummer = new int[pizzaer.length];

        for (int i = 0; i < pizzaer.length; i++) {
            pizzaerNummer[i] = Integer.parseInt(pizzaer[i]);
            pizza.add(Menukort.pizzaChecker(pizzaerNummer[i]));
        }
    }

    public String printBes() {
        String retVal = "Pizzatype: ";
        for (Pizza p : pizza) {
            retVal += p.getNavn() + ",";
        }
        return retVal;
    }

    public ArrayList<Pizza> getPizza() {
        return pizza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

}


