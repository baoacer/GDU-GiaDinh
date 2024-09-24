package calc;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Gui {
    // Khai báo các thuộc tính của class
    private JFrame frame;
    private TextField textField1;
    private TextField textField2;
    private Button buttonCong;
    private Button buttonTru;
    private TextField textFieldKetQua; // Ô hiển thị kết quả

    public Gui() {
        // Tạo frame chính
        frame = new JFrame("Calculator");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Tạo các thành phần giao diện
        textField1 = new TextField();
        textField1.setBounds(50, 20, 200, 30);
        frame.add(textField1);

        textField2 = new TextField();
        textField2.setBounds(50, 60, 200, 30);
        frame.add(textField2);

        buttonCong = new Button("+");
        buttonCong.setBounds(50, 100, 50, 30);
        frame.add(buttonCong);

        buttonTru = new Button("-");
        buttonTru.setBounds(120, 100, 50, 30);
        frame.add(buttonTru);

        textFieldKetQua = new TextField();
        textFieldKetQua.setBounds(50, 140, 200, 30);
        frame.add(textFieldKetQua);

        // Xử lý sự kiện khi nhấn nút
        buttonCong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(textField1.getText());
                    int num2 = Integer.parseInt(textField2.getText());
                    int result = num1 + num2;
                    textFieldKetQua.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    textFieldKetQua.setText("Lỗi nhập liệu");
                }
            }
        });

        buttonTru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(textField1.getText());
                    int num2 = Integer.parseInt(textField2.getText());
                    int result = num1 - num2;
                    textFieldKetQua.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    textFieldKetQua.setText("Lỗi nhập liệu");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Gui();
    }
}