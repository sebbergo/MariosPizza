package mariopizza;
//@author Marc

import java.util.Scanner;

public class Controller {

    //Programmet starter og mulighederne vises på skærmen
    public static void run() {
        Menukort.menukortLoad();
        Statistik.StatLoad();

        Scanner myScan = new Scanner(System.in);
        boolean exitValue = true;
        String tempInput = "";

        Statistik.bestillingerEfterTid();
        Statistik.gemBestillingerCsv();

        while (exitValue) {
            int cases = 1;
            //valg muligheder til brugeren
            cases = getUserNumber(
                    "Hvis du ønsker at stoppe hvad du laver skriv stop\n"
                    + "Skriv 1 for at lave ny bestilling\n"
                    + "Skriv 2 for at slette en bestilling\n"
                    + "Skriv 3 for at tilføje en ny pizza\n"
                    + "Skriv 4 for at slette en pizza\n"
                    + "Skriv 5 for at se statistik\n"
                    + "Skriv 6 for at se menukort\n"
                    + "Skriv 7 for at lukke programmet");
            switch (cases) {
                //valg mulighed 1 til at lave en pizza
                case 1:
                    String tid = "";

                    //if else statements der sørger for programmet fortsætter
                    //uanset om man går videre eller stopper
                    String pizzaNummere = "";
                    String navn = "";
                    int tlfnr = 0;
                    tempInput = getTid("Skriv hvilken time maden skal afhentes", "Skriv hvilket min Den skal hentes");
                    if (!tempInput.contains("stop")) {
                        tid = tempInput;
                        tempInput = getPizzaer("Skriv hvliken pizza der skal bestilles eller exit for at gå ud");
                        if (!tempInput.contains("stop")) {
                            pizzaNummere = tempInput;
                            tempInput = getUserText("Skriv kundens navn");
                            if (!tempInput.contains("stop")) {
                                navn = tempInput;
                                tempInput = getUserText("Skriv telefonnummer hvis der ikke er et så skriv 0");
                                if (!tempInput.contains("stop")) {
                                    tlfnr = Integer.parseInt(tempInput);
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }

                    tilføjBestilling(tid, pizzaNummere, navn, tlfnr);
                    Statistik.printBestilling();
                    Statistik.gemBestillingerCsv();
                    Statistik.bestillingerEfterTid();
                    Statistik.gemBestillingerCsv();
                    break;

                case 2:
                    //fjern eksisterende bestilling
                    Statistik.printBestilling();
                    int bestillingId = 0;
                    tempInput = getUserText("Skriv nummer på den bestilling du ønsker at fjerne");
                    if (!tempInput.contains("stop")) {
                        bestillingId = Integer.parseInt(tempInput);
                    } else {
                        break;
                    }

                    fjernBestilling(bestillingId);
                    Statistik.bestillingerEfterTid();
                    Statistik.gemBestillingerCsv();
                    break;
                case 3:
                    //Lav en ny pizza der bliver tilføjet til csv fil
                    String pizzaNavn = "";
                    int pizzaPris = 0;
                    String fyld = "";

                    tempInput = getUserText("Skriv pizzaens navn");
                    if (!tempInput.contains("stop")) {
                        pizzaNavn = tempInput;
                        tempInput = getUserText("Skriv pizzaens pris");
                        if (!tempInput.contains("stop")) {
                            pizzaPris = Integer.parseInt(tempInput);
                            tempInput = getPizzaer("skriv hvilket fyld eller exit for at stoppe");
                            if (!tempInput.contains("stop")) {
                                fyld = tempInput;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }

                    Menukort.addPizzaToCsv(pizzaNavn, pizzaPris, fyld);
                    Menukort.gemCsv();
                    break;

                case 4:
                    //Fjern eksisterende pizza fra csv fil
                    Menukort.printPizza();
                    int pizzaId = 0;
                    tempInput = getUserText("Skriv nummer på pizza du ønsker at slette");
                    if (!tempInput.contains("stop")) {
                        pizzaId = Integer.parseInt(tempInput);
                    } else {
                        break;
                    }

                    Menukort.sletLine(pizzaId);
                    break;

                case 5:
                    //Antal køb af hver pizza eller alle bestillinger
                    cases = getUserNumber(
                            "Skriv 1 for at se antal køb af hver pizza\n"
                            + "Skriv 2 for at se bestillinger");
                    switch (cases) {
                        case 1:
                            Statistik.printAntalKøbtePizzaer();

                            break;
                        case 2:
                            Statistik.printBestilling();
                            break;

                    }
                    break;

                //Se menukort
                case 6:
                    Menukort.printMenukort();
                    break;

                //Luk program
                case 7:
                    exitValue = false;
                    System.out.println("Program lukker!");
                    break;
            }
        }
    }

    //Methode til at hente alle pizzaer
    public static String getPizzaer(String skriv) {
        //retVal den værdig vi ønsker at retuner
        //pizza er den pizza vi lige har hentet og pizzaNummere er alle pizzer der er blevet valgt i en String
        String retVal = "";
        String pizza = "";
        String pizzaNummere = "";

        //While loop der kører indtil brugeren skriver exit
        //hvergang det køre spørger det om en pizza
        while (!pizza.equals("exit") && !pizza.equals("stop")) {
            pizza = getUserText(skriv);
            pizzaNummere += pizza + ",";
        }
        if (pizza.equals("stop")) {
            return pizzaNummere.substring(0, pizzaNummere.length() - 1);
        }
        //Fjerner exit fra stringen før vi sender den retur 
        retVal = pizzaNummere.substring(0, pizzaNummere.length() - 5);
        return retVal;
    }

    //Vi bruger den her som String fra useren istedet for
    //at bruge scanneren manuelt hver gang
    public static String getUserText(String skriv) {
        Scanner myScan = new Scanner(System.in);
        System.out.println(skriv);
        String resultat = myScan.nextLine();
        return resultat;
    }

    //Vi bruger den her som int fra useren istedet for
    //at bruge scanneren manuelt hver gang
    public static int getUserNumber(String skriv) {
        Scanner myScan = new Scanner(System.in);
        System.out.println(skriv);
        int resultat = myScan.nextInt();
        myScan.nextLine();
        return resultat;
    }

    //Metode til at tilføje en bestilling og adde den direkte til arrayliste
    //med bestillinger og statistikken
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

    //Fjern bestilling fra bestillingsliste array, hvis bestillingen findes
    public static void fjernBestilling(int id) {
        Bestilling bes = Statistik.bestillingChecker(id);
        if (bes != null) {
            Statistik.removeBestilling(bes);
        }
    }

    //metode til at sætte tidspunkt bestillingen skal hentes på
    public static String getTid(String time, String min) {
        String satTidTime = "";
        String satTidMin = "";
        int satTidTimeInt = -1;
        int satTidMinInt = -1;

        while (!satTidTime.contains("stop") && satTidTimeInt < 0 || !satTidTime.contains("stop") && satTidTimeInt > 24) {
            satTidTime = getUserText(time);
            satTidTimeInt = Integer.parseInt(satTidTime);

        }
        while (!satTidMin.contains("stop") && satTidMinInt < 0 || !satTidMin.contains("stop") && satTidMinInt > 60) {
            satTidMin = getUserText(min);
            satTidMinInt = Integer.parseInt(satTidMin);
        }

        System.out.println(satTidTimeInt);
        return satTidTime + ":" + satTidMin;
    }

}
