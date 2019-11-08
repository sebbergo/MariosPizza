
package mariopizza.Util;
import java.sql.*;
import java.sql.DriverManager;

public class DBConnector {
    
    public static Connection getConnector() throws SQLException, ClassNotFoundException {
        Connection connector = null;
        String url = "jdbc:mysql://localhost:3306/movies?" + 
                     "serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        String user = "root";
        String password = "Dug83cmn";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        connector = DriverManager.getConnection(url, user, password);
        return connector;
    }

}
