package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:gradeTracker.db";

    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);
            createTableIfNotExists(conn);
            System.out.println("Connected to SQLite");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("SQLite connection failed.");
            e.printStackTrace();
            return null;
        }
    }

    private static void createTableIfNotExists(Connection conn) {
        String sql = """
            CREATE TABLE IF NOT EXISTS userAccounts (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                email TEXT UNIQUE NOT NULL,
                password TEXT NOT NULL
            );
            """;

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}