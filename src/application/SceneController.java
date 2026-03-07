package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.control.RadioButton;

import java.io.IOException;

import javafx.event.ActionEvent;

public class SceneController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML 
	private TextField subjectNameField;
	
	@FXML
	private RadioButton higherBtn;
	
	@FXML
	private RadioButton ordinaryBtn;
	
	@FXML
	private VBox subjectsContainer;
	
	@FXML
	private Text noSubjectsText;
	
	@FXML
	public void initialize() {
		//TEST PRINT
		// System.out.println(subjectsContainer);
		
	    // Example data
		/*
		if (SubjectManager.subjects.isEmpty()) {

	        Subject maths = new Subject("Maths", "Higher");
	       maths.addGrade(new Grade(GradeType.CLASS_TEST, 80));
	       maths.addGrade(new Grade(GradeType.EXAM, 90));

	        SubjectManager.subjects.add(maths);
	    }
	    */
		
	    if (subjectsContainer == null) {
	        return;
	    }
	    
	    if (SubjectManager.subjects.isEmpty()) {
	    	noSubjectsText.setVisible(true);
	    	subjectsContainer.setVisible(false);
	    	return;
	    }
	    
	    noSubjectsText.setVisible(false);
	    subjectsContainer.setVisible(true);
	    
		for (Subject s : SubjectManager.subjects) {

            Text subjectName = new Text(s.getName());

            Text subjectAverage = new Text(
                String.format("%.1f%%", s.getAverage())
            );

            HBox row = new HBox(20);
            row.getChildren().addAll(subjectName, subjectAverage);

            subjectsContainer.getChildren().add(row);
        }
    }
	
	
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
	
	public void addSubjectAndReturn(ActionEvent event) throws IOException{
		String name = subjectNameField.getText();
		String level = "Ordinary";
		
		if (higherBtn.isSelected()) {
			level = "Higher";
		}
		
		Subject subject = new Subject(name, level);
		SubjectManager.subjects.add(subject);
		
		switchToSubjectScene(event);
	}
}
