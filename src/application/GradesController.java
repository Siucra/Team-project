package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

import java.io.IOException;

public class GradesController {

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
}
