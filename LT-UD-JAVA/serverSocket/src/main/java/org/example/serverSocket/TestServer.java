package org.example.serverSocket;

public class TestServer extends Thread{
    public static void main(String[] args) {
        int port = 3333;
        int timeout = 10000;

        try {
            Server server = new Server(port, timeout);
            server.run();
        }catch (Exception e){
            System.out.println("Error::" + e.getMessage());
        }
    }
}
