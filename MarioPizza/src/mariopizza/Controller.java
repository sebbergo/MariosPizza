package mariopizza;

import java.util.Scanner;

public class Controller {

    public static void run() {
        
        Scanner myScan = new Scanner(System.in);
        boolean exitValue = true;
        String tempInput = "";
        
        while (exitValue) {
            int cases = 1;
            //valg muligheder til brugeren
            cases = getUserNumber(
                    "Hvis du ønsker at stoppe hvad du laver skriv stop\n" +
                    "Skriv 1 for at lave ny bestilling\n" + 
                    "Skriv 2 for at slette en bestilling\n" +
                    "Skriv 3 for at tilføje en ny pizza\n" +
                    "Skriv 4 for at slette en pizza\n" +
                    "Skriv 5 for at se statistik\n" + 
                    "Skriv 6 for at se menukort\n" +
                    "Skriv 7 for at lukke programmet");
            switch (cases) {
                //valg mulighed 1 til at lave en pizza
                case 1:
                    String tid = "";
                    String pizzaNummere = "";
                    String navn = "";
                    int tlfnr = 0;
                    tempInput = getUserText("Skriv tidspunk til afhentning");
                    if(!tempInput.contains("stop")){
                        tid = tempInput;
                        tempInput = getPizzaer("Skriv pizza nummer eller exit for at slutte");
                        if(!tempInput.contains("stop")){
                            pizzaNummere = tempInput;
                            tempInput = getUserText("Skriv kundens navn");
                            if(!tempInput.contains("stop")){
                                navn = tempInput;
                                tempInput = getUserText("Skriv telefonnummer hvis der ikke er et så skriv 0");
                                if(!tempInput.contains("stop")){
                                    tlfnr = Integer.parseInt(tempInput);
                                }else break;
                            }else break;
                        }else break;
                    }else break;
                    
                    tilføjBestilling(tid, pizzaNummere, navn, tlfnr);
                    Statistik.printBestilling();
                    
                    break;
                case 2:
                    int bestillingId = 0;
                    tempInput = getUserText("Skriv nummer på den bestilling du ønsker at fjerne");
                    if(!tempInput.contains("stop")){
                        bestillingId = Integer.parseInt(tempInput);
                    }else break;
                    
                    // int bestillingId = getUserNumber("Skriv nummer på den bestilling du ønsker at fjerne");
                    fjernBestilling(bestillingId);
                    break;
                case 3:
                    String pizzaNavn = "";
                    int pizzaPris = 0;
                    String fyld = "";
                    
                    tempInput = getUserText("Skriv pizzaens navn");
                    if(!tempInput.contains("stop")){
                        pizzaNavn = tempInput;
                        tempInput = getUserText("Skriv pizzaens pris");
                        if(!tempInput.contains("stop")){
                            pizzaPris = Integer.parseInt(tempInput);
                            tempInput = getPizzaer("skriv hvilket fyld eller exit for at stoppe");
                            if(!tempInput.contains("stop")){
                                fyld = tempInput;
                            }else break;
                        }else break;
                    }else break;

                    Menukort.addPizzaToCsv(pizzaNavn, pizzaPris, fyld);
                    Menukort.gemCsv();
                    break;
                case 4:
                    Menukort.printPizza();
                    int pizzaId = 0;
                    tempInput = getUserText("Skriv nummer på pizza du ønsker at slette");
                    if(!tempInput.contains("stop")){
                        pizzaId = Integer.parseInt(tempInput);
                    }else break;
                    
                    Menukort.sletLine(pizzaId);
                    break;
                case 5:
                    Statistik.printAntalKøbtePizzaer();
                    break;   
                case 6:
                    Menukort.printMenukort();
                    break;
                case 7:
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
        while(!pizza.equals("exit") && !pizza.equals("stop")){
            pizza = getUserText(skriv);                               
            pizzaNummere += pizza + ",";
        }
        if(pizza.equals("stop")){
           return pizzaNummere.substring(0, pizzaNummere.length() - 1); 
        }
        //Fjerner ,exit, fra stringen før vi sender den retur 
        retVal = pizzaNummere.substring(0, pizzaNummere.length() - 5);
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
        Statistik.addBestilling(bes);
        Statistik.addBestillingStat(bes);
    }

    public static void fjernBestilling(int id) {
        Bestilling bes = Statistik.bestillingChecker(id);
        if (bes != null) {
            Statistik.removeBestilling(bes);
        }
    }
}
