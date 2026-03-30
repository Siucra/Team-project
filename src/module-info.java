module GradeTrackerFX {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	requires java.sql;
	requires junit;
	
	opens application to javafx.graphics, javafx.fxml;
	exports application;   
}
