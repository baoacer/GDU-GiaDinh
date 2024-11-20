package org.example.clientSocket;

import java.io.*;
import java.net.Socket;

public class Client {
    private String serverName;
    private int port;

    public Client(String serverName, int port) {
        this.serverName = serverName;
        this.port = port;
    }

    public void connectServer() {
        try {
            System.out.println("Client::Connecting to Server...");
            Socket client = new Socket(serverName, port);
            System.out.println("Client::Connected Server "
                + client.getRemoteSocketAddress()
                + "From " + client.getLocalSocketAddress());

            // Mo kenh xuat du lieu - Gui du lieu den client
            OutputStream out = client.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(out);

            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("I am Client "
                    + client.getLocalSocketAddress()
                    + " Hello Server "
                    + client.getRemoteSocketAddress());
            bufferedWriter.newLine();
            bufferedWriter.flush();

            // Mo kenh nhap du lieu - Nhan du lieu do may chu gui
            InputStream in = client.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println("Server::" + bufferedReader.readLine());

            client.close();
        }catch (Exception e){
            System.out.println("Connect Failed::" + e.getMessage());
        }
    }
}
