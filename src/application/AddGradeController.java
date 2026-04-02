package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

public class AddGradeController {

    @FXML
    private ComboBox<GradeType> gradeTypeBox;

    @FXML
    private TextField scoreField;

    @FXML
    public void initialize() {
        gradeTypeBox.setItems(FXCollections.observableArrayList(GradeType.values()));
    }

    public void addGradeAndReturn(ActionEvent event) throws IOException {
        GradeType selectedType = gradeTypeBox.getValue();
        String scoreText = scoreField.getText();

        if (selectedType == null) {
            JOptionPane.showMessageDialog(null, "Please select a grade type.", "Missing grade type",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (scoreText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a grade.", "Missing grade",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        double score;

        try {
            score = Double.parseDouble(scoreText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Invalid grade",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (score < 0 || score > 100) {
            JOptionPane.showMessageDialog(null, "Grade must be between 0 and 100.", "Invalid grade",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Subject selectedSubject = SubjectManager.selectedSubject;

        if (selectedSubject != null) {
            selectedSubject.addGrade(new Grade(selectedType, score));
            SubjectFileHandler.saveSubjects(SubjectManager.subjects);
        }

        Parent root = FXMLLoader.load(getClass().getResource("grades.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void goBackToGrades(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("grades.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
