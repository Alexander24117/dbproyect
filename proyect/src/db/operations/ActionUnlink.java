package db.operations;

import db.util.querydata.QueryData;

public class ActionUnlink extends ActionQuery {

    protected ActionUnlink(QueryData query) {
        super(query);
    }

    @Override
    public boolean doAction() {
        return false;
    }
}
