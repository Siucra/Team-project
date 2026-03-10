package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

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
    private Label wrongLogin;
    
	//@FXML
	//private Label passwordEmpty;
	
	//@FXML
	//private Button openSignUpButton;

    @FXML
    private void handleLogin() {
    	
        String email = loginEmail.getText();
        String password = loginPassword.getText();

        if (email == null || email.isEmpty()) {
            wrongLogin.setText("Please enter an email.");
            return;
        } 
        
        
        if(password == null || password.isEmpty()) {
        	wrongLogin.setText("Please enter a password");
        	return;
        }
        	
        wrongLogin.setText("Login successful!");
        
     
    }
    
    @FXML
    private void openSignUp(ActionEvent e) {
    	
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
    		Scene scene = new Scene(root);
    		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
    		stage.setScene(scene);
    		stage.show();
    		
    	} catch(IOException ev) {
    		ev.printStackTrace();
    	}
    	
    }
}