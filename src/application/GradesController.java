package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

import java.io.IOException;

public class GradesController {
	
	@FXML
	private VBox gradesContainer;

    @FXML
    private Label subjectNameLabel;

    @FXML
    private Label averageLabel;

    @FXML
    public void initialize() {
        Subject selected = SubjectManager.selectedSubject;

        if (selected != null) {
            if (subjectNameLabel != null) {
                subjectNameLabel.setText(selected.getName());
            }

            if (averageLabel != null) {
                averageLabel.setText(String.format("%.1f%%", selected.getAverage()));
            }
            
            if (gradesContainer != null) {
                gradesContainer.getChildren().clear();

                for (Grade g : selected.getGrades()) {
                    Label type = new Label(g.getType().toString());
                    Label score = new Label(g.getScore() + "%");

                    Pane spacer = new Pane();
                    HBox.setHgrow(spacer, Priority.ALWAYS);

                    HBox row = new HBox(10);
                    row.getChildren().addAll(type, spacer, score);

                    gradesContainer.getChildren().add(row);
                }
            }
        }
    }
    public void goBackToSubjects(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Subjects.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToAddGradeScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddGrade.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
