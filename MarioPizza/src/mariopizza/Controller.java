package mariopizza;

import java.util.Scanner;

public class Controller {

    public static void run() {
        Scanner myScan = new Scanner(System.in);
        boolean exitValue = true;
        while (exitValue) {
            int cases = 1;
            //valg muligheder til brugeren
            cases = getUserNumber(
                    "Skriv 1 for at lave ny bestilling\n" + 
                    "Skriv 2 for at slette en bestilling\n" +
                    "Skriv 3 for at tilføje en ny pizza\n" +
                    "Skriv 4 for at se statistik\n" + 
                    "Skriv 5 for at se menukort\n" +
                    "Skriv 6 for at lukke programmet");
            switch (cases) {
                //valg mulighed 1 til at lave en pizza
                case 1:
                    String tid = getUserText("Skriv tidspunk til afhentning");
                    String pizzaNummere = getPizzaer("Skriv pizza nummer eller exit for at slutte");
                    String navn = getUserText("Skriv kundens navn");
                    
                    int tlfnr = getUserNumber("Skriv telefonnummer hvis der ikke er et så skriv 0");
                    
                    tilføjBestilling(tid, pizzaNummere, navn, tlfnr);
                    Statistik.printBestillingStat();
                    
                    break;
                case 2:
                    System.out.println("Tuesday");
                    break;
                case 3:
                    System.out.println("Wednesday");
                    break;
                case 4:
                    System.out.println("Thursday");
                    break;
                case 5:
                    System.out.println("Friday");
                    break;
                //Valgmulighed 6 lukker programmet    
                case 6:
                    exitValue = false;
                    System.out.println("Program lukker!");
                    break;
            }
        }
    }
    //Methode til at hente alle pizzaer
    public static String getPizzaer(String skriv){
        //retVal den værdig vi 'nsker at retuner
        //pizza er den pizza vi lige har hentet og pizzaNummere er alle pizzer der er blevet valgt i en String
        String retVal = "";
        String pizza = "";
        String pizzaNummere = "";
        
        //While loop der køre indtil brugeren skriver exit
        //hvergang det køre spøgere det om en pizza
        while(!pizza.equals("exit")){
            pizza = getUserText(skriv);
                                              
            pizzaNummere += pizza + ",";
        }
        //Fjerner ,exit, fra stringen før vi sender den retur 
        retVal = pizzaNummere.substring(0, pizzaNummere.length() - 6);
        return retVal;
    }
    
    public static String getUserText(String skriv) {
        Scanner myScan = new Scanner(System.in);
        System.out.println(skriv);
        String resultat = myScan.nextLine();
        return resultat;
    }

    public static int getUserNumber(String skriv) {
        Scanner myScan = new Scanner(System.in);
        System.out.println(skriv);
        int resultat = myScan.nextInt();
        myScan.nextLine();
        return resultat;
    }

    public static void tilføjBestilling(String tid, String pizzaNummer, String navn, int tlfnr) {
        Bestilling bes;
        if (tlfnr == 0) {
            bes = new Bestilling(tid, pizzaNummer, navn);
        } else {
            bes = new Bestilling(tid, pizzaNummer, navn, tlfnr);
        }
        Statistik.addBestillingStat(bes);
        Statistik.addBestilling(bes);
    }

    public static void fjernBestilling(int id) {
        Bestilling bes = Statistik.bestillingChecker(id);
        if (bes != null) {
            Statistik.removeBestilling(bes);
        }
    }
}
