package mariopizza.View;

import mariopizza.Model.Kunde;


public class StatFunctions {
    public static Kunde getKundeById(int id) {
        Kunde tempKunde = null;
        
        for (Kunde kunde : Statistik.getKunder()) {
            if (id == kunde.getId()) return kunde;
        }
        
        return tempKunde;
    }
}
