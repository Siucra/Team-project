package application;

import java.io.IOException;
import javax.swing.JOptionPane;
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

public class EditGradeController{

    @FXML
    private ComboBox<GradeType> gradeTypeBox;

    @FXML
    private TextField gradeField;

    @FXML
    public void initialize(){
        gradeTypeBox.setItems(FXCollections.observableArrayList(GradeType.values()));

        Grade selected = SubjectManager.selectedGrade;

        if (selected != null){
            gradeTypeBox.setValue(selected.getType());
            gradeField.setText(String.valueOf(selected.getScore()));
        }
    }

    @FXML
    public void saveEditedGrade(ActionEvent event) throws IOException{
        Grade selected = SubjectManager.selectedGrade;

        if (selected == null){
            return;
        }

        GradeType type = gradeTypeBox.getValue();
        String text = gradeField.getText().trim();

        if (type == null){
            JOptionPane.showMessageDialog(null, "Please select a grade type.");
            return;
        }

        if (text.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter a grade.");
            return;
        }

        double value;

        try{
            value = Double.parseDouble(text);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            return;
        }

        if (value < 0 || value > 100){
            JOptionPane.showMessageDialog(null, "Grade must be between 0 and 100.");
            return;
        }

        selected.setType(type);
        selected.setScore(value);

        SubjectFileHandler.saveSubjects(SubjectManager.subjects);

        Parent root = FXMLLoader.load(getClass().getResource("grades.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goBackToGrades(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("grades.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
