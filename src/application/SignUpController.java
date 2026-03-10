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
	    private void start(){
		 
		  String email = signUpEmail.getText();
		  String password = signUpPassword.getText();

	        if(email == null || email.isEmpty()) {
	        	messageLbl.setText("Please enter an email.");
	        	return;
	        } 
	        
	        if(!email.contains("@") || !email.contains(".")) {
	        	messageLbl.setText("Sorry, your doesn't contain @ and .");
	        	return;
	        }
	        
	        
	        if(password == null || password.isEmpty()) {
	        	messageLbl.setText("Please create a password");
	        	return;
	        } 
	        
	        if(password.length() < 6) {
	        	messageLbl.setText("Sorry, passowrd must have at least 6 characters");
	        	return;
	        }
	        	
	        	userLogin newUserLogin = new userLogin(email, password);
	        	usersdetails.add(newUserLogin);
	        	
	        	messageLbl.setText("Account created");
	       
	        }
	        
	 @FXML
	    private void handleSignUp(ActionEvent e) {
	    	
	    	try {
	    		Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
	    		Scene scene = new Scene(root);
	    		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
	    		stage.setScene(scene);
	    		stage.show();
	    		
	    	} catch(IOException ev) {
	    		ev.printStackTrace();
	    	}
	    	
	    }

	 }


