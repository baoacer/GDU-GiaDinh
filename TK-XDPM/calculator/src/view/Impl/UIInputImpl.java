package view.Impl;

import dtos.IRequestData;
import view.IInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIInputImpl extends JFrame {
    private IInput IInput;
    private IRequestData request;

    // Các thành phần giao diện
    private JTextField number1Field;
    private JTextField number2Field;
    private JTextArea resultArea;

    public UIInputImpl(IInput IInput, IRequestData request) {
        this.IInput = IInput;
        this.request = request;
        initComponents();  // Khởi tạo các thành phần giao diện
    }

    private void initComponents() {
        // Thiết lập giao diện chính
        setTitle("Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Tạo các nhãn và trường nhập liệu
        JLabel number1Label = new JLabel("Enter Number 1:");
        number1Field = new JTextField();
        
        JLabel number2Label = new JLabel("Enter Number 2:");
        number2Field = new JTextField();
        
        // Các nút cho phép tính
        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        // Thêm các thành phần vào giao diện
        add(number1Label);
        add(number1Field);
        add(number2Label);
        add(number2Field);

        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);

        add(new JLabel("Result:"));
        add(resultArea);

        // Gắn sự kiện cho các nút
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOperation("+");
            }
        });
        
        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOperation("-");
            }
        });
        
        mulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOperation("*");
            }
        });
        
        divButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOperation("/");
            }
        });

        setVisible(true);
    }

    // Xử lý khi người dùng chọn phép tính
    private void onOperation(String operation) {
        String number1 = number1Field.getText();
        String number2 = number2Field.getText();

        request.setNumber1(number1);
        request.setNumber2(number2);
        request.setOperation(operation);

        IInput.execute(request);
    }

    // Hiển thị kết quả hoặc lỗi lên giao diện
    public void showResult(String result) {
        resultArea.setText(result);
    }
}
