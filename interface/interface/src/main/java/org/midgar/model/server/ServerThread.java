package org.midgar.model.server;

import org.midgar.model.proyect.idto.IDto;

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
                if(request.contains("select")){
                    IDto response = getData(request);
                    oos.writeObject(response);
                    oos.flush();
                }else{
                    break;
                }
                //aqui se ejecuta la clase identificador
                /*if (!request.contains("unlink")) {

                    Object reply = requestIdentifier(request);
                    oos.writeObject(reply);
                    oos.flush();
                } else
                    System.out.println("unlinked");
                    break;
*/
            }
        } catch (IOException e) {
            System.out.println("ServerThread Error:" + e.getMessage());
        }

    }


}
