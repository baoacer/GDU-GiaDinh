package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
		private TextField textField1;
		private TextField textField2;
		private TextField textFieldKetQua;
		private Button buttonCong;
		private Button buttonTru;
	

	    @Override
	    public void start(Stage primaryStage) {
	        
	    }

	    public void xuLy() {
	    	XuLy xuLy = new XuLy(textField1, textField2, textFieldKetQua, buttonCong, buttonTru);
	    	xuLy.xuLyCong();
	    	xuLy.xuLyTru();
	    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
