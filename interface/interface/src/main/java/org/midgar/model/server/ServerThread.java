package org.midgar.model.server;

import org.midgar.model.proyect.idto.IDto;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends RequestIdentifier implements Runnable {
    private final Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());

            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);

            while (true) {
                String request = in.readUTF();
                /*
                System.out.println(request);
                if(request.contains("select")){
                    IDto response = getData(request);
                    oos.writeObject(response);
                    oos.flush();
                }else{
                    break;
                }*/
                //aqui se ejecuta la clase identificador
                if (request.contains("UNLINK")){
                    break;
                }else {
                    IDto result = (IDto) requestIdentifier(request);
                    oos.writeObject(result);
                    oos.flush();
                }

            }
            in.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
