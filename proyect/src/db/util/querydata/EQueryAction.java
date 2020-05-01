package db.util.querydata;

public enum EQueryAction {

    INSERT("action#insert"),
    UPDATE("action#update"),
    DELETE("action#delete"),
    SELECT_ONE("action#selecone"),
    SELEC_ALL("action#selecall"),
    UNLINK("action#unlink");

    private final String action;

    EQueryAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
