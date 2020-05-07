package org.midgar.model.client;

import org.midgar.model.proyect.idto.IDto;
import org.midgar.model.registro.*;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {
    private DataOutputStream out;

    private ObjectInputStream ois;

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        try {
            int port = 6666;
            String host = "localhost";
            Socket client = new Socket(host, port);
            this.out = new DataOutputStream(client.getOutputStream());
            this.ois = new ObjectInputStream(client.getInputStream());
            // aqui se envia las peticiones
            RegistroDao registroDao = new RegistroDao();
            getOneObject(Registro.class.getName() + "#SELECT * FROM REGISTRO WHERE USER_ID = 1");

            this.ois.close();
            this.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void getOneObject(String sql) {

        try {
            this.out.writeUTF(sql);
            this.out.flush();

            IDto response = (IDto) ois.readObject();
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
