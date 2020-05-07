package org.midgar.model.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void listener(){
        try {
            int port = 6666;
            int nConecctions = 20;
            ServerSocket server= new ServerSocket(port, nConecctions);
            while (true){
                System.out.println("Message: Listening...");
                Socket client = server.accept();

                System.out.println("Linked");
                Runnable run = new ServerThread(client);
                Thread thread = new Thread(run);
                thread.start();
                System.out.println("Exit!");
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
