package mariopizza.Model;
//@author Marc

import java.util.ArrayList;
import mariopizza.Controllers.Controller;
import mariopizza.Util.ArrayListHolder;

public class Bestilling implements Comparable<Object> {

    public static void setCounter(int counter) {
        Bestilling.counter = counter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String tid;
    private int kundeId;
    private double pris = 0.0;
    private ArrayList<Pizza> pizza = new ArrayList();
    private String pizzaerString = "";
    private int id;
    private String status = "";
    private static int counter;

    public Bestilling(String tid, String pizzaNummer, String navn, int tlfnr, String status, int kundeId) {
        this.tid = tid;
        this.id = ++counter;
        this.kundeId = kundeId;
        this.pizzaerString = pizzaNummer;
        this.status = status;

        String[] pizzaer = pizzaNummer.split(",");
        int[] pizzaerNummer = new int[pizzaer.length];

        for (int i = 0; i < pizzaer.length; i++) {
            pizzaerNummer[i] = Integer.parseInt(pizzaer[i]);
            pizza.add(ArrayListHolder.pizzaChecker(pizzaerNummer[i]));
            this.pris += ArrayListHolder.pizzaChecker(pizzaerNummer[i]).getPris();
        }
    }

    public Bestilling(String tid, String pizzaNummer, String navn, int tlfnr, String status, int id, int kundeId) {
        this.tid = tid;
        this.id = id;
        this.counter = id;
        this.kundeId = kundeId;
        this.pizzaerString = pizzaNummer;
        this.status = status;

        String[] pizzaer = pizzaNummer.split(",");
        int[] pizzaerNummer = new int[pizzaer.length];

        for (int i = 0; i < pizzaer.length; i++) {
            pizzaerNummer[i] = Integer.parseInt(pizzaer[i]);
            pizza.add(ArrayListHolder.pizzaChecker(pizzaerNummer[i]));
            this.pris += ArrayListHolder.pizzaChecker(pizzaerNummer[i]).getPris();
        }
    }

    public String returnPizzaer() {
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

    public String getPizzaerString() {
        return pizzaerString;
    }

    public int getKundeId() {
        return kundeId;
    }

    public double getPris() {
        return pris;
    }

    @Override
    public int compareTo(Object o) {
        Bestilling other = (Bestilling) o;
        int thisHour = Integer.parseInt(this.tid.split(":")[0]);
        int thisMin = Integer.parseInt(this.tid.split(":")[1]);
        int otherHour = Integer.parseInt(other.getTid().split(":")[0]);
        int otherMin = Integer.parseInt(other.getTid().split(":")[1]);

        if (thisHour > otherHour) {
            return 1;
        } else if (thisHour < otherHour) {
            return -1;
        } else {
            if (thisMin > otherMin) {
                return 1;
            } else if (thisMin < otherMin) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
