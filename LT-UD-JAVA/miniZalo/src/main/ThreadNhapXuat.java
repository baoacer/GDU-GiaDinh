package org.example.server;

import java.io.*;
import java.net.Socket;

public class ThreadNhapXuat extends Thread{
    // Thuoc tinh cua lop
    private Socket socket;
    private int userID;

    // Bien cuc bo cua class
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public ThreadNhapXuat(Socket socket, int userID) {
        this.socket = socket;
        this.userID = userID;
        System.out.println("[Server]::[Client]::" + userID + "Connected to server");
    }

    public int getUserID() {
        return userID;
    }

    @Override
    public void run(){
        try {
            // Mo kenh nhan du lieu - Nhan
            InputStream in = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            bufferedReader = new BufferedReader(reader);

            // Mo kenh xuat du lieu - Gui
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(out);
            bufferedWriter = new BufferedWriter(writer);

            System.out.println("[Server]::Open Out - In Data with " + userID + " Successfully");

            // TODO: server send client userID
            Server.xuLy.sendUserIDForClient(userID);

            // TODO: send list user online to all users
            Server.xuLy.sendListUserOnline();

            // TODO: send all client content "user x login"
            Server.xuLy.sendToPerson("capNhapDanhSachDangNhap" + "#~" + "server" +
                    "#~" + "== username " + userID + " Login ==");

            // TODO: continue forward messages : get messages from 1 client later analysis message -> forward to 1 or much client
            String message;
            while(true){
                message = enter();
                if(message != null){
                    Server.xuLy.forwardMessage(message, getUserID());
                }
            }

        }catch (IOException e){
            System.out.println("Error[4]::" + e.getMessage());
        }
    }

    public String enter() throws IOException{
        return bufferedReader.readLine();
    }

    public void export(String message) throws IOException{
        bufferedWriter.write(message);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
}
