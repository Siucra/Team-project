package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import java.util.ArrayList;

public class SignUpController {
	

	@FXML
	private TextField signUpEmail;
	    
	@FXML
	 private PasswordField signUpPassword;
	
	@FXML
	private Label messageLbl;
	
	public static ArrayList<userLogin> usersdetails = new ArrayList<>();
	

	 @FXML
	    private void handleSignUp(ActionEvent e) {
		 
		  String email = signUpEmail.getText();
		  String password = signUpPassword.getText();
		  
		  // Email Validation

	        if(email == null || email.isEmpty()) {
	        	messageLbl.setText("Please enter an email.");
	        	return;
	        } 
	        
	        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
	        	messageLbl.setText("Email is invalid. Please Enter a valid email address");
	        	return;
	        }
	        
	        
	        //Password Validation
	        
	        if(password == null || password.isEmpty()) {
	        	messageLbl.setText("Please create a password");
	        	return;
	        	
	        } 
	        
	        
	        if (password.length() < 6 || password.length() > 10) {
	        	messageLbl.setText("Password must be between 6 and 10 characters");
	        	return;
	        }
	        
	      
	        
	        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@!£$%&*~#,.?]).+$") ) {
	        	messageLbl.setText("Password is too Weak, must include upper, lower, number and special character");
	        	return;
	        }
	        	
	       /* 
	        for (userLogin login : usersdetails) {
	        	if(login.getEmail().equals(email)) {
	        		messageLbl.setText("Sorry, account already exists");
		        	return;	
	        	}
	        }
	        
	        
	        	userLogin newUserLogin = new userLogin(email, password);
	        	usersdetails.add(newUserLogin);
	        	
	        	messageLbl.setText("Account created");
	       
	        */
	        
	        UsersInfo users = new UsersInfo(email,password);
	        boolean successful = Users.addUsers(email,password);
	        
	        if (successful) {
	    	// This Switches the page to Login if successful
	    	try {
	    		Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
	    		Scene scene = new Scene(root);
	    		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
	    		stage.setScene(scene);
	    		stage.show();
	    		
	    	} catch(IOException ev) {
	    		ev.printStackTrace();
	    }
	    	
	 } else {
		    messageLbl.setText("Could not create an account, Try again!");
	 }
	 }
}

