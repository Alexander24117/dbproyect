module org.midgar {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.midgar to javafx.fxml;
    exports org.midgar;
}