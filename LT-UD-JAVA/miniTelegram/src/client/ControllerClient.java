package client;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControllerClient implements Initializable{
	// Khai bao các bien cua file giao dien fxml
	@FXML
	private Label lableName;
	
	@FXML
	private TextArea textAreaTrucTuyen;
	
	@FXML
	private TextArea textAreaNoiDung;
	
	@FXML
	private TextField textFieldSoanThao;
	
	@FXML
	private ComboBox<String> comboboxChonNguoiNhan;
	
	// khai bao các biến cục bộ cua lop
	private String serverName = "localhost";
	private int port = 3333;
	
	private ThreadNhapXuat t;

	@Override
	public void initialize(URL url, ResourceBundle res) {
		connectServer();
		
	}

	private void connectServer() {
		try {
			t = new ThreadNhapXuat(serverName, port, lableName, textAreaTrucTuyen, textAreaNoiDung, textFieldSoanThao, comboboxChonNguoiNhan);
			t.start();
		} catch (Exception e) {
			System.out.println("[ControllerClient] - [Error]::" + e.getMessage());
		}
		
	}
	
	public void actionSend(ActionEvent event) {
		t.send();
	}
	
}
