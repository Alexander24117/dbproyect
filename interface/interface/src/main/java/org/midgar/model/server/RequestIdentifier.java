package org.midgar.model.server;

import org.midgar.model.proyect.idto.IDto;
import org.midgar.model.util.container.Container;

public abstract class RequestIdentifier {

    // toma los valores insert, update, delete, getOne y getAll
    // Estructura de la peticion = Clase + tipo de peticion +(opcional)sql
    // devolver el request
    public <T> Object requestIdentifier(String request) {
        Object reply = null;
        if (request.contains("update")||request.contains("delete")||request.contains("insert")) {
             reply = getUpdate(request);

        }else if (request.contains("where")){
            reply = getData(request);
        }else {
            reply = getAllData(request);
        }
        return reply;
    }

    // Para Upade,delete y insert  dando un boolean
    public boolean getUpdate(String sql) {
        String nameIDto = sql.substring(0, sql.indexOf("#"));
        sql = sql.substring(sql.indexOf("#") + 1);
        boolean result = false;
        try {
            Class classIDto = Class.forName(nameIDto);
            ExecuteSql<IDto> executeSql = new ExecuteSql<IDto>(classIDto);
            result = executeSql.getExecuteUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public IDto getData(String sql) {
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

    public Container<IDto> getAllData(String sql) {
        String nameIDto = sql.substring(0, sql.indexOf("#"));
        sql = sql.substring(sql.indexOf("#") + 1);
        Container<IDto> result = null;
        try {
            Class classIDto = Class.forName(nameIDto);
            ExecuteSql<IDto> executeSql = new ExecuteSql<IDto>(classIDto);
            result = executeSql.getManyResults(sql);
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        return result;
    }

}
