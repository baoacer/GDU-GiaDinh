module miniTelegram {
	requires javafx.controls;
	requires javafx.fxml;
	
	exports application to javafx.graphics;
	opens client to javafx.graphics, javafx.fxml;

}
