
package application;

import java.util.ArrayList;

public class Login {


	    public static String loginVerification(String email, String password) {
	    	
	    	//Created an Arraylist to store user login details 
	    	ArrayList<userLogin> users = new ArrayList<>();
	    	users.add(new userLogin("email@gmail.com", "Qwer1234."));

	    	//Checks if email is empty
	        if (email == null || email.isEmpty()) {
	            return "Please enter an email.";
	        }
	        
	        //Checks if email format is correct
	        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
	            return "Sorry, your email doesn't contain @ and .";
	        }
	        
	        //Checks if password field is empty or null
	        if (password == null || password.isEmpty()) {
	            return "Please enter a password";
	        }
	        
	        
	        //This loops checks if email and password matches 
	        for (userLogin login : users) {
	            if (login.getEmail().equals(email) && login.getPassword().equals(password)) {
	                return "Login successful!";
	            }
	        }
	        
	        //if there is no match found show error message
	        return "Soryy, you have entered wrong email or password";
	    }
	
}
