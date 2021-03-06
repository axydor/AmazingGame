package main.com.ceng453.server;

import java.io.*;
import java.net.Socket;

class GameClient {
    private final Socket clientSocket;
    public BufferedReader in;
    public PrintWriter out;

    GameClient(Socket socket) throws IOException {
        this.clientSocket = socket;
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.out = new PrintWriter(clientSocket.getOutputStream());
    }

    public void terminate() {
        try {
            this.in.close();
            this.out.close();
            this.clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
