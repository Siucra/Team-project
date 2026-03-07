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
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.Priority;
import javafx.geometry.Pos;

import java.io.IOException;

import javafx.event.ActionEvent;

public class SceneController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML 
	private TextField subjectField;
	
	@FXML
	private RadioButton higherBtn;
	
	@FXML
	private RadioButton ordinaryBtn;
	
	@FXML
	private VBox subjectsContainer;
	
	@FXML
	private Text noSubjectsText;
	
	@FXML
	private VBox emptyStateBox;
	
	@FXML
	public void initialize() {
		//TEST PRINT
		// System.out.println(subjectsContainer);
		
	    // Example data
		subjectsContainer.setSpacing(15);
		
		 if (SubjectManager.subjects.isEmpty()) {

	        Subject maths = new Subject("Maths", "Higher");
	       maths.addGrade(new Grade(GradeType.CLASS_TEST, 80));
	       maths.addGrade(new Grade(GradeType.EXAM, 90));

	       //second subject 
	       Subject english = new Subject("English","Ordinary");
	       english.addGrade(new Grade(GradeType.MOCK_EXAM,60));
	       english.addGrade(new Grade(GradeType.ASSIGNMENT,70));
	       
	        SubjectManager.subjects.add(maths);
	        SubjectManager.subjects.add(english);
	    }
		 
	    
		
	    if (subjectsContainer == null) {
	        return;
	    }
	    
	    if (SubjectManager.subjects.isEmpty()) {
	        emptyStateBox.setVisible(true);
	        subjectsContainer.setVisible(false);
	        return;
	    }
	    
	    emptyStateBox.setVisible(false);
	    subjectsContainer.setVisible(true);
	    
		for (Subject s : SubjectManager.subjects) {

			Text subjectName = new Text(s.getName());

			Text subjectAverage = new Text(
			    String.format("%.1f%%", s.getAverage())
			);

			VBox subjectText = new VBox(3);
			subjectText.setAlignment(Pos.CENTER);
			subjectText.getChildren().addAll(subjectName, subjectAverage);
			
			
            
            Image editIcon = new Image(getClass().getResourceAsStream("images/editSymbol.png"));
            ImageView editView = new ImageView(editIcon);
            editView.setFitWidth(18);
            editView.setFitHeight(18);

            Button editBtn = new Button();
            editBtn.setGraphic(editView);
            editBtn.setStyle("-fx-background-color: transparent;");
            
            editBtn.setOnAction(e -> {
                System.out.println("Edit subject: " + s.getName());
                // later this will open  edit screen
            });

            HBox row = new HBox(20);
            row.prefWidthProperty().bind(subjectsContainer.widthProperty());
            row.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(subjectText, Priority.ALWAYS);
            row.getChildren().addAll(subjectText, editBtn);

            subjectsContainer.getChildren().add(row);
        }
    }
	
	@FXML 
	private ToggleGroup levelButton;
	
	@FXML
	private void selectedRadioBtn() {
		RadioButton selected = (RadioButton) levelButton.getSelectedToggle();
		String subjectName = subjectField.getText();
		
		if (selected == null) {
			System.out.println("Please select a level");
			return;
		}
		
		
		String level = selected.getText(); //either higher or ordinary
		
		Subject newSubject = new Subject(subjectName, level);
		
		SubjectManager.subjects.add(newSubject);
		
		System.out.println("subject add: " + subjectName + "(" + level + ")");
	}
	
	public void switchToSubjectScene(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Subjects.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToAddSubjectScene(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("AddSubject.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void addSubjectAndReturn(ActionEvent event) throws IOException{
		String name = subjectField.getText();
		String level = "Ordinary";
		
		if (higherBtn.isSelected()) {
			level = "Higher";
		}
		
		Subject subject = new Subject(name, level);
		SubjectManager.subjects.add(subject);
		
		switchToSubjectScene(event);
	}
	
	
}
