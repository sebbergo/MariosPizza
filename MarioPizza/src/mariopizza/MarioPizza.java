package mariopizza;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import mariopizza.Controllers.Controller;
import mariopizza.DataMappers.DBBestilling;
import mariopizza.DataMappers.DBMenukort;

public class MarioPizza {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {      
        DBMenukort.loadPizzaerFraSQL();
        DBBestilling.loadBestillingerFraSQL();
        Controller.run();
    }
}
