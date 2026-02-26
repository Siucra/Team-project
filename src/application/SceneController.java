package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class SceneController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToSubjectScene(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Subjects.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToAddSubjectScene(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("AddSubject.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
