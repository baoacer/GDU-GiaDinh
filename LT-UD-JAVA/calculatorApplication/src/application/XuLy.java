package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class XuLy {
	private TextField textField1;
	private TextField textField2;
	private TextField textFieldKetQua;
	private Button buttonCong;
	private Button buttonTru;
	
	public XuLy(TextField textField1, TextField textField2, TextField textFieldKetQua, Button buttonCong,
			Button buttonTru) {
		this.textField1 = textField1;
		this.textField2 = textField2;
		this.textFieldKetQua = textFieldKetQua;
		this.buttonCong = buttonCong;
		this.buttonTru = buttonTru;
	}
	
	public void xuLyCong() {
		buttonCong.setOnAction(e -> {
			phepCong();
		});
	}
	

	public void xuLyTru() {
		buttonCong.setOnAction(e -> {
			phepTru();
		});
	}
	

	private void phepCong() {
		int t1 = Integer.valueOf(textField1.getText());
		int t2 = Integer.valueOf(textField2.getText());
		textFieldKetQua.setText(String.valueOf(t1 + t2));
	}
	

	private void phepTru() {
		int t1 = Integer.valueOf(textField1.getText());
		int t2 = Integer.valueOf(textField2.getText());
		textFieldKetQua.setText(String.valueOf(t1 - t2));
	}

	public TextField getTextField1() {
		return textField1;
	}

	public void setTextField1(TextField textField1) {
		this.textField1 = textField1;
	}

	public TextField getTextField2() {
		return textField2;
	}

	public void setTextField2(TextField textField2) {
		this.textField2 = textField2;
	}

	public TextField getTextFieldKetQua() {
		return textFieldKetQua;
	}

	public void setTextFieldKetQua(TextField textFieldKetQua) {
		this.textFieldKetQua = textFieldKetQua;
	}

	public Button getButtonCong() {
		return buttonCong;
	}

	public void setButtonCong(Button buttonCong) {
		this.buttonCong = buttonCong;
	}

	public Button getButtonTru() {
		return buttonTru;
	}

	public void setButtonTru(Button buttonTru) {
		this.buttonTru = buttonTru;
	}
	
	
	
	
}
