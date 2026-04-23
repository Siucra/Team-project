package application;

public class SignUp {
	
	

	    public static String SignUp_Verifications(String email, String password) {

	    	//Checks if email field is empty or null
	        if(email == null || email.isEmpty()) {
	            return "Please enter an email.";
	        }

	        //Cheks if email format is correct
	        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
	            return "Email is invalid. Please Enter a valid email address";
	        }
	        
	        //Checks if password field is empty or null
	        if(password == null || password.isEmpty()) {
	            return "Please create a password";
	        }
	        
	        //Checks if password length is between 6 and 10 characters
	        if (password.length() < 6 || password.length() > 10) {
	            return "Password must be between 6 and 10 characters";
	        }
	        
	        //Checks the strength of the password
	        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@!£$%&*~#,.?]).+$")) {
	            return "Password is too Weak, must include upper, lower, number and special character";
	        }
	        
	        // All password and email formats is correct and valid sign up is successful
	        return "Sign Up successful";
	    }
	}


