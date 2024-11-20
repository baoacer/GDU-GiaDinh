package org.example.clientSocket;

public class TestClient {
    public static void main(String[] args) {
        Client client = new Client("localhost", 3333);
        client.connectServer();
    }
}
