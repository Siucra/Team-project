package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Users {
 
	public static boolean addUsers(String email, String password){
		
	      String sql = ("INSERT INTO userAccounts (email, password) VALUES(?, ?) ");
	      
	      
	      try {
	       Connection conn = DatabaseConnection.connect();
	       PreparedStatement statement = conn.prepareStatement(sql);
	       statement.setString(1, email);
	       statement.setString(2, password);
	       statement.execute();
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
		
	      String sql = ("SELECT * FROM userAccounts where email = ? and Password = ?");
	      
	      
	      try {
	       Connection conn = DatabaseConnection.connect();
	       
	       if(conn == null) {
	    	   System.out.println("Connection Failed");
	    	   return false;
	       }
	       
	       PreparedStatement statement = conn.prepareStatement(sql);
	       statement.setString(1, email);
	       statement.setString(2, password);
	       ResultSet result =statement.executeQuery();
	      
	       return result.next();
	      
	      
	      }
	      catch (SQLException e) {
	          e.printStackTrace();
	          return false;
	      }
	      
	}
}
