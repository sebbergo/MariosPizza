package mariopizza.Util;

import java.sql.*;

public class DBConnection {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/mariopizza?";
        url += "serverTimezone=UTC&allowPublicKeyRetrieval=true&";
        url += "useSSL=false";
        String user = "root";
        String password = "aldrig#glem?log-in!";
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Establish connection object
        Connection connection = DriverManager.getConnection(url, user, password);
        
        return connection;
    }
    
}
