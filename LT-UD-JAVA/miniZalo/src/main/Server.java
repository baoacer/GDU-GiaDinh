package org.example.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // Bien local
    public static volatile XuLy xuLy;

    private ServerSocket serverSocket;
    private ThreadNhapXuat threadNhapXuat;

    public Server(int port) throws Exception {
        try {
            serverSocket = new ServerSocket(port); // > 1023
            XuLy xuLy = new XuLy();
        }catch (Exception e) {
            System.out.println("Error[1]::" + e.getMessage());
        }
    }

    public void run() throws IOException {
        int userID = 1;
        Socket incomingSocket;
        try {
            while (true){
                System.out.println("[Server]::Waiting for [Client] to connect...");
                // Chap nhan yeu cau ket noi tu client
                incomingSocket = serverSocket.accept();
                System.out.println("[Server]::[Client(" + userID + ")] "
                        + incomingSocket.getRemoteSocketAddress()
                        + " Connected [Server - "
                        + incomingSocket.getLocalSocketAddress()
                        + "]");

                // TODO: Tao mot thread nhap xuat de quan ly client
                threadNhapXuat = new ThreadNhapXuat(incomingSocket, userID++);
                threadNhapXuat.start(); // bat dau thuc hien thread nhap xuat

                // TODO: them Thread nhap-xuat cua tung client vao lop xu ly de quan ly theo list
                xuLy.addClientThread(threadNhapXuat);
                System.out.println("[Server]::Number Thread Run::" + xuLy.getSize());
            }
        }catch (IOException e) {
            System.out.println("Error[2]::" + e.getMessage());
        }finally {
            try {
                serverSocket.close();
            }catch (IOException e){
                System.out.println("Error[3]::" + e.getMessage());
            }
        }
    }


}
