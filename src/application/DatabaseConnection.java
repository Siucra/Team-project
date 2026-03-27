package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	

	    public static Connection connect() {
	    	//Database URl
	        String url = "jdbc:postgresql://localhost:5432/gradeTracker";
	        //Username for my database 
	        String user = "postgres";
	        //Password for my database
	        String password = "JTWYO2012";

	        // This initialises the connection object
	        Connection conn = null;
	        try {
	        	//This tries to get a connection to the database
	            conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Successfully connected ");
	        } catch (SQLException e) {
	        	//Prints this if the connection fails
	            e.printStackTrace();
	        }
	        
	        //This return the connection object
	        return conn;
	    
	}

}
