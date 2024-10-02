package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Model;
import view.View;

public class Controller implements Initializable{
	
	@FXML
	private TextField textField1;
	
	@FXML
	private TextField textField2;
	
	@FXML
	private TextField textFieldKetQua;
	

	private Model model;
	private View view;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		model = new Model();
		view = new View();	
	}
	
	
	public void actionAdd(javafx.event.ActionEvent event) {
		double result = model.add(Double.parseDouble(textField1.toString()), Double.parseDouble(textField2.toString()));
		view.hienThiKetQua(result, textFieldKetQua);
	}
	
	public void actionSub(ActionEvent event) {
		double result = model.sub(Double.parseDouble(textField1.toString()), Double.parseDouble(textField2.toString()));
		view.hienThiKetQua(result, textFieldKetQua);
	}
}
