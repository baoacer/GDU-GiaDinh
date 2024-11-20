package org.example;

import org.example.server.Server;

public class Main {
    public static void main(String[] args) {
        int port = 3333;
        try {
            Server server = new Server(port);
            server.run();
        }catch (Exception e) {
            System.out.println("Main Error::"+ e.getMessage());
        }
    }
}