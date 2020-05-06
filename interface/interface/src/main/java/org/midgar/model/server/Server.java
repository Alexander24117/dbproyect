package org.midgar.model.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int port = 6666;
    private final int nConecctions = 20;
    public void listener(){
        try {
            ServerSocket server= new ServerSocket(port,nConecctions);
            while (true){
                System.out.println("Message: Listening...");
                Socket client = server.accept();
                System.out.println("Linked");
                Runnable run = new ServerThread(client);
                Thread thread = new Thread(run);
                thread.start();

            }
        } catch (IOException e) {
            System.out.println("Server Error: "+ e.getMessage());
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.listener();
    }
}
