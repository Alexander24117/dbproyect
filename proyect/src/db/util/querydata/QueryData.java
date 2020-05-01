package db.util.querydata;

public class QueryData {

    private EQueryAction queryAction;

    private Class entityClass;

    private String query;

    public QueryData(EQueryAction queryAction,
                     Class entityClass,
                     String query) {
        this.queryAction = queryAction;
        this.entityClass = entityClass;
        this.query = query;
    }

    public EQueryAction getQueryAction() {
        return queryAction;
    }

    public void setQueryAction(EQueryAction queryAction) {
        this.queryAction = queryAction;
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
