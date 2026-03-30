module GradeTrackerFX {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	requires junit;
	
	opens application to javafx.graphics, javafx.fxml;
}
