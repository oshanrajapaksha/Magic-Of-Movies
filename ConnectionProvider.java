package DatAcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    public Connection getMySQLConnection() {
        Connection db = null;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bookings";
            String username = "root";
            String password = "";
            db = DriverManager.getConnection(url, username, password);
        } catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch(SQLException e1){
            System.out.println(e1.getMessage());
        }
        return db;
    }
}
