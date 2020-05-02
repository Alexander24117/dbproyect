package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private Socket client;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private final int port = 6666;
    private final String host = "localhost";



    public Client() {


        try {
            client = new Socket(host,port);
            this.objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            this.objectInputStream = new ObjectInputStream(client.getInputStream());


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new Client();
    }
}
