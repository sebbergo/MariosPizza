package mariopizza.Model;
//@author Marc
import mariopizza.Model.Kunde;
import mariopizza.Model.Pizza;
import java.util.ArrayList;
import mariopizza.View.Menukort;
import mariopizza.View.Statistik;

public class Bestilling implements Comparable<Object>{

    private String tid;
    private Kunde kunde;
    private double pris = 0.0;
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
            this.pris += Menukort.pizzaChecker(pizzaerNummer[i]).getPris();
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
            this.pris += Menukort.pizzaChecker(pizzaerNummer[i]).getPris();
        }
    }

    public double getPris() {
        return pris;
    }
    
    public String returnPizzaer(){
        String retVal = "";
        for (Pizza piz : pizza) {
            retVal += piz.getNavn() + ", ";
        }
        retVal = retVal.substring(0, retVal.length() - 1);
        return retVal;
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

    @Override
    public int compareTo(Object o) {
        Bestilling other = (Bestilling) o;
        int thisHour = Integer.parseInt(this.tid.split(":")[0]);
        int thisMin = Integer.parseInt(this.tid.split(":")[1]);
        int otherHour = Integer.parseInt(other.getTid().split(":")[0]);
        int otherMin = Integer.parseInt(other.getTid().split(":")[1]);
        
        if(thisHour > otherHour){
            return 1;
        } else if (thisHour < otherHour){
            return -1;
        } else {
            if(thisMin > otherMin){
                return 1;
            } else if (thisMin < otherMin){
                return -1;
            } else {
                return 0;
            }
        }
    }

}


