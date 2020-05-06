package org.midgar.model.client;

import org.midgar.model.proyect.idto.IDto;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;

public abstract class RequestGenerator {
    private DataOutputStream out;
    private ObjectInputStream ois;


    public IDto getOneObject(String sql) {
        IDto response =null;
        try {
            this.out.writeUTF(sql);
            this.out.flush();

             response = (IDto) ois.readObject();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
