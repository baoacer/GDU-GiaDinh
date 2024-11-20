package org.example.serverSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server {
    private ServerSocket serverSocket;

    public Server(int port, int timeout) throws IOException {
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(timeout);
        } catch (Exception e) {
            System.out.println("Error::" + e.getMessage());
        }
    }

    public void run() {
        while (true) {
            try {
                // Máy chủ mở cổng và chờ máy trạm kết nối vào
                System.out.println("Server::Waiting client connection - "
                        + serverSocket.getLocalPort() + "...");
                Socket incomingSocket = serverSocket.accept();
                System.out.println("Server::Client - "
                        + incomingSocket.getRemoteSocketAddress()
                        + " Connect Server "
                        + incomingSocket.getLocalSocketAddress());

                // Mở kênh nhập dữ liệu - nhận dữ liệu do máy trạm gửi
                InputStream in = incomingSocket.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);

                BufferedReader bufferedReader = new BufferedReader(reader);
                System.out.println("Client::" + bufferedReader.readLine());

                // Mở kênh ghi dữ liệu - Gửi dữ liệu đến máy trạm
                OutputStream out =  incomingSocket.getOutputStream();
                OutputStreamWriter writer = new OutputStreamWriter(out);

                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write("I am Server "
                        + incomingSocket.getLocalSocketAddress()
                        + "Hello Client" );
                bufferedWriter.newLine();
                bufferedWriter.flush();

                // Đóng kết nối với máy trạm sau khi xử lý xong
                incomingSocket.close();
            } catch (SocketTimeoutException e) {
                // Không đóng serverSocket ở đây để tiếp tục chờ các kết nối mới
                System.out.println("Server::Timeout occurred, waiting for next client connection...");
            } catch (IOException e) {
                System.out.println("Server::Error occurred - " + e.getMessage());
                break; // Thoát vòng lặp nếu có lỗi khác xảy ra
            }
        }

        try {
            // Đóng serverSocket khi thoát vòng lặp
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Server::Failed to close server socket - " + e.getMessage());
        }
    }
}
