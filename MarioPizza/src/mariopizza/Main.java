package mariopizza; 


public class Main {
    public static void main(String[] args) {
        Pizza pep = new Pizza("pep",100,"Tomat, Pep, ost");
        Pizza ost = new Pizza("ost",90,"Tomat, ost");
        Pizza tomat = new Pizza("tomat",80,"Tomat");
        
        Menukort menukort = new Menukort();
        
        menukort.addPizza(pep);
        menukort.addPizza(ost);
        menukort.addPizza(tomat);
        
        Menukort.printPizza();
    }
}
