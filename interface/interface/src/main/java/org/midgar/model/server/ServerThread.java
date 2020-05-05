package org.midgar.model.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends RequestIdentifier implements Runnable {
    private final Socket socket;
    private ObjectInputStream in;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = new ObjectInputStream(socket.getInputStream());

            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);

            while (true) {
                String request = in.readUTF();
                System.out.println(request);
                //aqui se ejecuta la clase identificador
                if (!request.contains("unlink")) {
                    Object reply = requestIdentifier(request);
                    oos.writeObject(reply);
                    oos.flush();
                } else
                    break;

            }
        } catch (IOException e) {
            System.out.println("ServerThread Error:" + e.getMessage());
        }

    }


}
