package db.server;

import db.proyect.idto.IDto;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket socket;
    private DataInputStream in;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            in = new DataInputStream(socket.getInputStream());

            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);

            while (true) {
                String request = in.readUTF();
                System.out.println(request);
                if (request.contains("select")) {
                    IDto response = getData(request);
                    oos.writeObject(response);
                    oos.flush();
                } else {
                    break;
                }
            }
            in.close();;
            oos.close();
        } catch (IOException e) {
            System.out.println("ServerThread Error:" + e.getMessage());
        }

    }

    private IDto getData(String sql) {
        String nameIDto = sql.substring(0, sql.indexOf("#"));
        sql = sql.substring(sql.indexOf("#") + 1);
        IDto result = null;
        try {
            Class classIDto = Class.forName(nameIDto);
            ExecuteSql<IDto> executeSql = new ExecuteSql<IDto>(classIDto);
            result = executeSql.getOneOnlyResult(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
