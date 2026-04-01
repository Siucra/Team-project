package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;

import java.io.IOException;

//import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class LoginController {

    @FXML
    private TextField loginEmail;
    
    @FXML
    private PasswordField loginPassword;

    @FXML
    private Label loginMessage;
    
	
	
	

    @FXML
    private void handleLogin(ActionEvent e) {
    	
        String email = loginEmail.getText();
        String password = loginPassword.getText();
        
        for(userLogin login : SignUpController.usersdetails) {

        if (email == null || email.isEmpty()) {
        	loginMessage.setText("Please enter an email.");
            return;
        } 
        
        if(!email.contains("@") && !email.contains(".")) {
        	loginMessage.setText("Sorry, your doesn't contain @ and .");
            return;
        } 
        
        
        if(password == null || password.isEmpty()) {
        	loginMessage.setText("Please enter a password");
        	return;
        }
        	

    
        if(login.getEmail().equals(email) && login.getPassword().equals(password)){
        	loginMessage.setText("Login successful!");
        	return;
        }
        }
        loginMessage.setText("Soryy, you have entered wrong email or password");
   
    boolean successful = Users.loginVerify(email,password);
    
    if (successful) {
  
    	
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("Subject.fxml"));
    		Scene scene = new Scene(root);
    		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
    		stage.setScene(scene);
    		stage.show();
    		
    	} catch(IOException ev) {
    		ev.printStackTrace();
    	}
    
    }
    }
    
    @FXML
	private Button SignUpBtn;
    
    @FXML
    private void openSignUp(ActionEvent event) {
        try {
            // Load SignUpPage.fxml
            Parent root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (IOException ev) {
            ev.printStackTrace();
        }
    
}
}