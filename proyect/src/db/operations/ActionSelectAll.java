package db.operations;

import db.proyect.idto.IDto;
import db.util.querydata.QueryData;

import java.io.IOException;

public class ActionSelectAll extends ActionQuery {

    protected ActionSelectAll(QueryData query) {
        super(query);
    }

    @Override
    public boolean doAction() {

        try {
            Class classIDto = Class.forName(query.getEntityClass().getName());
            ExecuteSql<IDto> executeSql = new ExecuteSql<>(classIDto);
            IDto reply = (IDto) executeSql.getManyResults(query.getQuery());
            objectOutputStream.writeObject(reply);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
