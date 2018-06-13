package Model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by ronnie on 13-Jun-18.
 */
public class DBConnection{
    private static DBConnection dbConnection;
    private static Connection conctn;

    private DBConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            conctn = DriverManager.getConnection("jdbc:sqlite:courseDB.db");
        } catch (Exception e) {
            return;
        }
    }

    public static DBConnection getInstance(){
        if(dbConnection == null)
            dbConnection = new DBConnection();
        return dbConnection;
    }

    public Connection getConnection(){
        return conctn;
    }
}
