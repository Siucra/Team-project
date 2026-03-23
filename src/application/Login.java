package application;

import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.scene.control.TextField;

public class Login {

	public Login() {}


@FXML
	private TextField userEmail;

@FXML
private Button continueButton;

@FXML
private Label wrongLogin;

@FXML
private Button signUpButton;

@FXML
private Button nextButton;


public void userLogin(ActionEvent event)
	throws IOException{
	checkLogin();
}

public void checkLogin()
	throws IOException {
	// Main m = new Main();
	if(userEmail.getText().toString().equals("Javacoding")) {
		wrongLogin.setText("Success!");
		
		
	}else if(userEmail.getText().isEmpty()) {
		wrongLogin.setText("Please enter your email");
	}
	else {
		wrongLogin.setText("Wrong email!");
	}
}
}
