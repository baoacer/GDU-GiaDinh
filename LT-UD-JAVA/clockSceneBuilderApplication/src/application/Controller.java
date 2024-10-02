package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class Controller implements Initializable{
	
	@FXML
	private TextField textFieldGio;

	private Model gio;
	private View view;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gio = new Model("");
		view = new View();	
	}
	
	public void hienThiGio(javafx.event.ActionEvent event) {
		gio.gioHienTai();
		String stringGio = gio.getGio();
		
		view.hienThiGio(stringGio, textFieldGio);
	}
	

}
