package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField userEmail;

    @FXML
    private Label wrongLogin;

    @FXML
    private void handleLogin() {
    	
        String email = userEmail.getText();

        if (email == null || email.isEmpty()) {
            wrongLogin.setText("Please enter an email.");
        } else {
            wrongLogin.setText("Login is successful!");
            System.out.println("Email entered: " + email);
        }
    }
}