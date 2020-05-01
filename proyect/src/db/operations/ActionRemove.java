package db.operations;

import db.proyect.idto.IDto;
import db.util.querydata.QueryData;

import java.io.IOException;

public class ActionRemove extends ActionQuery {

    protected ActionRemove(QueryData query) {
        super(query);
    }

    @Override
    public boolean doAction() {
        boolean reply = false;
        try {
            Class classIDto = Class.forName(query.getEntityClass().getName());
            ExecuteSql<IDto> executeSql = new ExecuteSql<>(classIDto);
            reply = executeSql.getExecuteUpdate(query.getQuery());
            objectOutputStream.writeObject(reply);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return reply;
    }
}
