package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ThreadNhapXuat extends Thread{
	
	// Thuoc tinh cua class
	private String serverName;
	private int port;
	
	Label labelName;
	TextArea textAreaTrucTuyen;
	TextArea textAreaNoiDung;
	TextField textFieldSoanThao;
	ComboBox<String> comboboxChonNguoiNhan;
	
	// Bien cuc bo
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private int userID;
	
	
	public ThreadNhapXuat(String serverName, int port, Label labelName, TextArea textAreaTrucTuyen,
			TextArea textAreaNoiDung, TextField textFieldSoanThao, ComboBox<String> comboboxChonNguoiNhan) {
		this.serverName = serverName;
		this.port = port;
		this.labelName = labelName;
		this.textAreaTrucTuyen = textAreaTrucTuyen;
		this.textAreaNoiDung = textAreaNoiDung;
		this.textFieldSoanThao = textFieldSoanThao;
		this.comboboxChonNguoiNhan = comboboxChonNguoiNhan;
	}
	
	@Override
	public void run() {
		try {
			socket = new Socket(serverName, port);
			System.out.println("Connect Success!");
			
			//Mo kenh nhap du lieu
			InputStream in = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(in);
			bufferedReader = new BufferedReader(reader);
			
			//Mo kenh xuat du lieu
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(out);
			bufferedWriter = new BufferedWriter(writer);
			
			System.out.println("[Client]::Open out - in data with [Server] Success");
		
			// Lien tuc nhan du lieu tu kenh
			// Sau do phan tich cu phap cua thong diep de hien thi len client
			receive();
			
			socket.close();	
			
		} catch (Exception e) {
			System.out.println("[Client] - [ThreadNhapXuat] - [Error(1)]::" + e.getMessage());
			return;
		}
	}

	// Nhan thong diep tu kenh, sau do phan tich cu phap cua thong diep de hien thi
	// len man hinh cua may tram
	private void receive() {
		String receiveMessage;
		while(true){
			try {
				receiveMessage = bufferedReader.readLine();
				
				if(receiveMessage != null) {
					String[] splitMessage = receiveMessage.split("#~");
					
					// phan tich "loai" thong diep de hien thi len client dung vi tri
					// hien thi userId len ....
					if(splitMessage[0].equals("UserID")) {
						userID = Integer.parseInt(splitMessage[2]);
						labelName.setText("You::username " + userID);
					}
					// Cap nhap danh sach online
					else if(splitMessage[0].equals("capNhatDSOnline")) {
						capNhatDSOnline(splitMessage[2]);
					}
					else if(splitMessage[0].equals("capNhatDangNhapDangXuat")) {
						textAreaNoiDung.setText(textAreaNoiDung.getText()
								+ splitMessage[2] + "\n");
					}
					else if(splitMessage[0].equals("guiMotNguoi")) {
						textAreaNoiDung.setText(textAreaNoiDung.getText() 
								+ "username" 
								+ splitMessage[1] + ":"
								+ splitMessage[2] + "\n");
					}
					else if(splitMessage[0].equals("guiMoiNguoi")) {
						textAreaNoiDung.setText(textAreaNoiDung.getText()
								+ "username" 
								+ splitMessage[1]
								+ " (gửi mọi người): "
								+ splitMessage[2] + "\n");
					}
				}
			}catch (Exception e) {
				System.out.println("[Client] - [ThreadNhapXuat] - [Error(2)]::" + e.getMessage());
				return;
			}
		}
	}

	private void capNhatDSOnline(String listOnline) {
		String[] splitListOnline = listOnline.split("-");
		String usernameOnline = "";
		List<String> onlineList = new ArrayList<>();
		
		for(String i : splitListOnline) {
			onlineList.add(i);
			usernameOnline += "username" + i + "\n";
		}
		textAreaTrucTuyen.setText(usernameOnline);
		capNhatComboboxChonNguoiNhan(onlineList);
	}

	private void capNhatComboboxChonNguoiNhan(List<String> onlineList) {
		comboboxChonNguoiNhan.getItems().clear();
		comboboxChonNguoiNhan.setPromptText("Chọn người nhận");
		comboboxChonNguoiNhan.getItems().addAll("Mọi người");
		for(String i : onlineList) {
			if(!i.equals("" + userID)) { // loai chinh minh
				comboboxChonNguoiNhan.getItems().addAll("username " + i);
			}
		}
		
	}
	
	public void send() {
		String message = textFieldSoanThao.getText();
		String diaChiDich = comboboxChonNguoiNhan.getValue();
		
		if(message.isBlank() || diaChiDich == null) {
			alert("Ban chua nhap thong diep hoac chua chon nguoi nhan");
		}else {
			// Gui cho moi nguoi
			if(diaChiDich.equals("Mọi người")) {
				export("guiMoiNguoi" + "#~" + userID + "#~" + message);
				
				// Hien thi noi dung vua gui len cho chinh minh
				textAreaNoiDung.setText(textAreaNoiDung.getText()
						+ "Bạn (gửi mọi người): "
						+ message + "\n");
			}else {
				// Gui cho mot nguoi
				String[] diaChiDichSplit = diaChiDich.split(" ");
				export("guiMotNguoi" + "#~" + userID + "#~" + message + "#~" + diaChiDichSplit[1]);
				
				// Hien thi noi dung vua gui len cho chinh minh
				textAreaNoiDung.setText(textAreaNoiDung.getText()
						+ "Bạn (gửi username "
						+ diaChiDichSplit[1] + "): "
						+ message + "\n");
			}
			textFieldSoanThao.setText("");
		}
	}

	private void alert(String tb) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Thông báo");
		alert.setHeaderText(null);
		alert.setContentText(tb);
		alert.showAndWait();
	}

	private void export(String message) {
		try {
			bufferedWriter.write(message);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		} catch (Exception e) {
			System.out.println("[Client] - [ThreadNhapXuat] - [Error(3)]::" + e.getMessage());
			return;
		}
		
	}
	
	
	
	
	
}
