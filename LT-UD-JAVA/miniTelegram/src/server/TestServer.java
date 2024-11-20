package server;

import javafx.application.Application;
import javafx.stage.Stage;

public class TestServer extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		try {
			Server server = new Server(3333);
			server.run();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
