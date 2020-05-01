package db.operations;

import db.util.querydata.QueryData;


import java.io.ObjectOutputStream;

public abstract class ActionQuery {
    protected QueryData query;
    protected ObjectOutputStream objectOutputStream;

    protected ActionQuery(QueryData query) {
        this.query = query;
    }

    public abstract boolean doAction();

    public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }
}
