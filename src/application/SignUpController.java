package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class SignUpController {

	@FXML
	private TextField signUpEmail;
	    
	@FXML
	 private PasswordField signUpPassword;
	
	@FXML
	private Label messageLbl;
	
	@FXML
	    private void handleSignUp(){
		 
		  String email = signUpEmail.getText();
		  String password = signUpPassword.getText();

	        if(email == null || email.isEmpty()) {
	        	messageLbl.setText("Please enter an email.");
	        	return;
	        } 
	        
	        
	        if(password == null || password.isEmpty()) {
	        	messageLbl.setText("Please create a password");
	        	return;
	        } 
	        	
	        messageLbl.setText("Strong Password");
	        System.out.println("Password " + email);
	        }
	        
	     

	 }


