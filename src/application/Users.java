package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Users {
 
	public static boolean addUsers(String email, String password){
		
	      String sql = ("INSERT INTO useraccounts (email, password) VALUES(?, ?) ");
	      
	      
	      try {
	       Connection conn = DatabaseConnection.connect();
	       //Testing database connection
	       if(conn == null) {
	    	   System.out.println(" DB Connection Failed");
	    	   return false;
	       }
	       
	       PreparedStatement statement = conn.prepareStatement(sql);
	       statement.setString(1, email);
	       statement.setString(2, password);
	       statement.executeUpdate();
	       statement.close();
	       conn.close();
	       return true;
	      }
	      catch (SQLException e) {
	          e.printStackTrace();
	          return false;
	      }
	    
	      
	}
	
	public static boolean loginVerify(String email, String password){
		
	      String sql = ("SELECT * FROM useraccounts where email = ? and password = ?");
	      
	      
	      try {
	       Connection conn = DatabaseConnection.connect();
	       
	       //Testing database connection
	       if(conn == null) {
	    	   System.out.println("DB Connection Failed");
	    	   return false;
	       }
	       
	       PreparedStatement statement = conn.prepareStatement(sql);
	       statement.setString(1, email);
	       statement.setString(2, password);
	       ResultSet result = statement.executeQuery();
	      
	       return result.next();
	      
	      
	      }
	      catch (SQLException e) {
	          e.printStackTrace();
	          return false;
	      }
	      
	}
}
