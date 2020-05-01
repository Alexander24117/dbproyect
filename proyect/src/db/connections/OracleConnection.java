package db.connections;
import java.io.IOException;
import java.sql.*;
import java.io.FileInputStream;
import java.util.Properties;


public class OracleConnection {

    private static OracleConnection connection = null;

    private Connection con;


private OracleConnection(){

    Properties conProperties = new Properties();
    try {

        conProperties.load(new FileInputStream("data/connection.porperties") );

            String url =conProperties.getProperty("url");
            String user = conProperties.getProperty("user");
            String password = conProperties.getProperty("password");

             con = DriverManager.getConnection(url, user, password);
                System.out.println("link started...");
        } catch (IOException | SQLException e) {
        System.out.println(e.getMessage());
            }

    }
    public static OracleConnection getInstance(){
        if(connection == null){
            connection = new OracleConnection();
        }
        return connection;
    }
    public ResultSet executeQuery(String sql){
        Statement st;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Message: Query successful!");
        } catch (SQLException e) {
            System.out.println("F: "+e.getMessage());
            }
        return rs;
    }
    public int executeUpdate(String sql){
        int res = 0;
        Statement st;
        try {
            st = con.createStatement();
            res = st.executeUpdate(sql);
            System.out.println("Message: Update successful!");
        } catch (SQLException e) {
            System.out.println("F: "+e.getMessage());
        }
        return res;
    }
}
