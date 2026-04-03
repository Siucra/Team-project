package application;

import javax.swing.JOptionPane;
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
import javafx.scene.control.Button;

import java.io.IOException;

public class GradesController{
	private HBox selectedRow;
	
	@FXML
	private VBox gradesContainer;

    @FXML
    private Label subjectNameLabel;

    @FXML
    private Label averageLabel;

    @FXML
    public void initialize(){
    	SubjectManager.selectedGrade = null;
        selectedRow = null;
    	
        Subject selected = SubjectManager.selectedSubject;

        if (selected != null){
            if (subjectNameLabel != null){
                subjectNameLabel.setText(selected.getName());
            }

            if (averageLabel != null){
                averageLabel.setText(String.format("%.1f%%", selected.getAverage()));
            }
            
            if (gradesContainer != null){
                gradesContainer.getChildren().clear();

                for (Grade g : selected.getGrades()){
                    Label type = new Label(g.getType().toString());
                    Label score = new Label(String.format("%.0f%%", g.getScore()));

                    Button deleteBtn = new Button("🗑");
                    deleteBtn.setStyle("-fx-background-color: transparent;");

                    deleteBtn.setOnAction(e -> {
                        int choice = JOptionPane.showConfirmDialog(
                            null,
                            "Delete this grade?",
                            "Delete Grade",
                            JOptionPane.YES_NO_OPTION
                        );

                        if (choice == JOptionPane.YES_OPTION){
                            selected.getGrades().remove(g);
                            SubjectFileHandler.saveSubjects(SubjectManager.subjects);

                            try {
                                Parent root = FXMLLoader.load(getClass().getResource("grades.fxml"));
                                Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
                                Scene scene = new Scene(root);
                                scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                                stage.setScene(scene);
                                stage.show();
                            } catch (IOException ex){
                                ex.printStackTrace();
                            }
                        }
                    });

                    Pane spacer = new Pane();
                    HBox.setHgrow(spacer, Priority.ALWAYS);

                    HBox row = new HBox(10);
                    row.getChildren().addAll(type, spacer, score, deleteBtn);

                    row.setOnMouseClicked(e -> {
                        SubjectManager.selectedGrade = g;

                        if (selectedRow != null) {
                            selectedRow.setStyle("");
                        }

                        selectedRow = row;
                        row.setStyle("-fx-background-color: #eeeeee; -fx-background-radius: 10;");
                    });

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
    
    @FXML
    public void switchToEditGradeScene(ActionEvent event) throws IOException{

        if (SubjectManager.selectedGrade == null){
            javax.swing.JOptionPane.showMessageDialog(
                null,
                "Please select a grade first",
                "No Grade Selected",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        Parent root = FXMLLoader.load(getClass().getResource("EditGrade.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
