package org.midgar.model.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {
    private Socket client;
    private DataOutputStream out;

    private ObjectInputStream ois;

    public static void main(String[] args) {
    new Client();
    }

    public Client() {
        try {
            int port = 6666;
            String host = "localhost";
            client = new Socket(host, port);
            this.out = new DataOutputStream(client.getOutputStream());
            this.ois = new ObjectInputStream(client.getInputStream());
            // aqui se envia las peticiones

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
