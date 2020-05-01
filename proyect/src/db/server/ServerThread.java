package db.server;

import db.operations.ActionQuery;
import db.operations.ExecuteSql;
import db.proyect.idto.IDto;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
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
            boolean actio = true;
            while (actio) {
                try {
                    ActionQuery actionQuery = (ActionQuery) in.readObject();
                    actionQuery.setObjectOutputStream(oos);
                    actio = actionQuery.doAction();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                oos.flush();


            }
            in.close();
            oos.close();
        } catch (IOException e) {
            System.out.println("ServerThread Error:" + e.getMessage());
        }

    }


}
