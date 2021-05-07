package helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteConnector {
    public static Connection Connector() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:data.db");
        } catch (Exception e) {
            return null;
        }
    }
}
