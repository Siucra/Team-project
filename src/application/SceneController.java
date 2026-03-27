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
import javafx.scene.layout.Priority;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import java.io.IOException;
import javax.swing.JOptionPane;

public class SceneController { 
    private Stage stage;
    private Scene scene;
    private Parent root;

    private SubjectService subjectService = new SubjectService();

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
    private ToggleGroup levelButton;

    @FXML
    public void initialize() {

        if (subjectsContainer == null) {
            return;
        }

        subjectsContainer.setSpacing(15);


        if (subjectService.getSubjects().isEmpty()) {
            emptyStateBox.setVisible(true);
            subjectsContainer.setVisible(false);
            return;
        }

        emptyStateBox.setVisible(false);
        subjectsContainer.setVisible(true);

        for (Subject s : subjectService.getSubjects()) {
            addSubjectRow(s);
        }
    }

    private void addSubjectRow(Subject s) {

        String displayName = s.getName().replace("_", " ").toLowerCase();
        Text subjectName = new Text(displayName);

        Text subjectAverage = new Text(
                String.format("%.1f%%", s.getAverage())
        );

        VBox subjectText = new VBox(3);
        subjectText.setAlignment(Pos.CENTER_LEFT);
        subjectText.getChildren().addAll(subjectName, subjectAverage);

        Image editIcon = new Image(getClass().getResourceAsStream("images/editSymbol.png"));
        ImageView editView = new ImageView(editIcon);
        editView.setFitWidth(18);
        editView.setFitHeight(18);

        Button editBtn = new Button();
        editBtn.setGraphic(editView);
        editBtn.setStyle("-fx-background-color: transparent;");

        editBtn.setOnAction(e -> {
            try {
                SubjectManager.selectedSubject = s;

                Parent root = FXMLLoader.load(getClass().getResource("grades.fxml"));
                Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        HBox row = new HBox(20);
        row.prefWidthProperty().bind(subjectsContainer.widthProperty());
        row.setMaxWidth(Double.MAX_VALUE);
        row.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(subjectText, Priority.ALWAYS);

        row.getChildren().addAll(subjectText, editBtn);

        row.setOnMouseClicked(e -> {
            if (deleteMode) {
                int choice = JOptionPane.showConfirmDialog(
                        null,
                        "Delete " + displayName + "?",
                        "Delete Subject",
                        JOptionPane.YES_NO_OPTION
                );

                if (choice == JOptionPane.YES_OPTION) {
                    subjectService.deleteSubject(s);
                    subjectsContainer.getChildren().clear();

                    if (subjectService.getSubjects().isEmpty()) {
                        emptyStateBox.setVisible(true);
                        subjectsContainer.setVisible(false);
                    } else {
                        emptyStateBox.setVisible(false);
                        subjectsContainer.setVisible(true);

                        for (Subject subject : subjectService.getSubjects()) {
                            addSubjectRow(subject);
                        }
                    }
                }
            }
        });

        subjectsContainer.getChildren().add(row);
    }

    @FXML
    private void selectedRadioBtn() {
        //null
    }
    
    private boolean deleteMode = false;
    
    @FXML
    public void toggleDeleteMode() {
        deleteMode = !deleteMode;

        if (deleteMode) {
            JOptionPane.showMessageDialog(null, "Delete "
            		+ "mode is on. Click subject to delete it.");
        }
    }

    @FXML
    private Button deleteBtn;

    public void switchToSubjectScene(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Subjects.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    public void switchToAddSubjectScene(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("AddSubject.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    public void addSubjectAndReturn(ActionEvent event) throws IOException{
        String name = subjectField.getText().trim();
        String level = "Ordinary";

        if(higherBtn.isSelected()){
            level = "Higher";
        }

        if(name.isEmpty()){
            return;
        }

        boolean added = subjectService.addSubject(name, level);

        if(added){
            switchToSubjectScene(event);
        }
        else{
        	JOptionPane.showMessageDialog(null, "Subject could not be added. Make sure it is "
        			+ "valid, not already added, and/or you have no more than 7 subjects."
        			+ "","Unable to add subject",
        		    JOptionPane.ERROR_MESSAGE
        		);
        }
    }
}