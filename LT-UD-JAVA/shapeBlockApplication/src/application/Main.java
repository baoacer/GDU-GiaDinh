package application;
	
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
	   @Override
	    public void start(Stage stage) {
	        // Lục giác
	        Polygon hexagon = new Polygon();
	        hexagon.getPoints().addAll(
	            50.0, 0.0,
	            100.0, 25.0,
	            100.0, 75.0,
	            50.0, 100.0,
	            0.0, 75.0,
	            0.0, 25.0
	        );
	        hexagon.setFill(Color.CORNFLOWERBLUE);

	        // Tam giác
	        Polygon triangle = new Polygon();
	        triangle.getPoints().addAll(
	            50.0, 0.0,
	            100.0, 100.0,
	            0.0, 100.0
	        );
	        triangle.setFill(Color.LIGHTGREEN);

	        // Chữ nhật
	        Rectangle rectangle = new Rectangle(100, 50);
	        rectangle.setFill(Color.SALMON);

	        // Xoay từng hình
	        setupRotationWithTimeline(hexagon);
	        setupRotationWithTimeline(triangle);
	        setupRotationWithTimeline(rectangle);

	        // Sắp xếp các hình
	        HBox hbox = new HBox(20, hexagon, triangle, rectangle);
	        hbox.setAlignment(Pos.CENTER); // Đặt các hình ở giữa HBox

	        // Dùng StackPane để căn giữa toàn bộ HBox
	        StackPane root = new StackPane(hbox);
	        root.setAlignment(Pos.CENTER); // Căn giữa toàn bộ màn hình

	        Scene scene = new Scene(root, 400, 200);

	        stage.setTitle("Shape Rotation with Timeline");
	        stage.setScene(scene);
	        stage.show();
	    }

	    private void setupRotationWithTimeline(javafx.scene.shape.Shape shape) {
	        final boolean[] runningClockwise = {false};
	        final boolean[] runningCounterClockwise = {false};

	        // Tạo Timeline để điều khiển việc xoay
	        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5), event -> {
	            if (runningClockwise[0]) {
	                shape.setRotate(shape.getRotate() + 2); // Xoay theo chiều kim đồng hồ
	            } else if (runningCounterClockwise[0]) {
	                shape.setRotate(shape.getRotate() - 2); // Xoay ngược chiều kim đồng hồ
	            }
	        }));
	        timeline.setCycleCount(Timeline.INDEFINITE); // Xoay liên tục

	        shape.setOnMouseClicked(event -> {
	            if (!runningClockwise[0] && !runningCounterClockwise[0]) {
	                runningClockwise[0] = true; // Bắt đầu xoay thuận khi click lần 1
	                timeline.play();
	            } else if (runningClockwise[0]) {
	                runningClockwise[0] = false;
	                runningCounterClockwise[0] = true; // Xoay ngược khi click lần 2
	            } else {
	                runningCounterClockwise[0] = false; // Dừng lại khi click lần 3
	                timeline.pause();
	            }
	        });
	    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
