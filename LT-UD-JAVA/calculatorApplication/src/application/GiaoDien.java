package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GiaoDien {
	private TextField textField1;
	private TextField textField2;
	private TextField textFieldKetQua;
	private Button buttonCong;
	private Button buttonTru;
	
	    public void start(Stage primaryStage) {
	        // Input fields
	    	textField1 = new TextField();
	        input1.setPromptText("Enter first number");
	        input2 = new TextField();
	        input2.setPromptText("Enter second number");

	        // Output label
	        output = new Label("Result: ");
	        output.setStyle("-fx-font-size: 16;");

	        // Buttons
	        Button addButton = new Button("+");
	        addButton.setStyle("-fx-font-size: 18;");
	        addButton.setOnAction(e -> handleOperation("+"));

	        Button subtractButton = new Button("-");
	        subtractButton.setStyle("-fx-font-size: 18;");
	        subtractButton.setOnAction(e -> handleOperation("-"));

	        // Layout for buttons
	        HBox buttonBox = new HBox(10, addButton, subtractButton);
	        buttonBox.setAlignment(Pos.CENTER);

	        // Main layout
	        VBox root = new VBox(15, input1, input2, buttonBox, output);
	        root.setPadding(new Insets(20));
	        root.setAlignment(Pos.CENTER);

	        // Scene
	        Scene scene = new Scene(root, 300, 200);
	        primaryStage.setTitle("Mini Calculator");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }

	    private void handleOperation(String operation) {
	        try {
	            double num1 = Double.parseDouble(input1.getText());
	            double num2 = Double.parseDouble(input2.getText());
	            double result;

	            if (operation.equals("+")) {
	                result = num1 + num2;
	            } else {
	                result = num1 - num2;
	            }

	            output.setText("Result: " + result);
	        } catch (NumberFormatException e) {
	            output.setText("Please enter valid numbers");
	        }
	    }
	
	
}
