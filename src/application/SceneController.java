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
        HBox.setHgrow(subjectText, Priority.ALWAYS);

        row.getChildren().addAll(subjectText, editBtn);

        subjectsContainer.getChildren().add(row);
    }

    @FXML
    private void selectedRadioBtn() {
        RadioButton selected = (RadioButton) levelButton.getSelectedToggle();

        if (selected == null) {
            System.out.println("Please select a level");
            return;
        }

        String subjectName = subjectField.getText();
        String level = selected.getText();

        System.out.println("Subject added: " + subjectName + " (" + level + ")");
    }

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

    public void addSubjectAndReturn(ActionEvent event) throws IOException {

        String name = subjectField.getText().trim();
        String level = "Ordinary";

        if (higherBtn.isSelected()) {
            level = "Higher";
        }
        
        if(!name.isEmpty()) {
        	subjectService.addSubject(name, level);
        }

        subjectService.addSubject(name, level);

        switchToSubjectScene(event);
    }
}