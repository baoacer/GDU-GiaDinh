package application;

import javafx.scene.control.TextField;

public class View {
	public void hienThiKetQua(Double ketqua, TextField textFieldKQ) {
		textFieldKQ.setText(String.valueOf(ketqua));
	}
}
