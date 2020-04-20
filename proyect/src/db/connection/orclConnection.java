package db.connection;
import java.io.IOException;
import java.sql.*;
import java.io.FileInputStream;
import java.util.Properties;


public class orclConnection {

    private static orclConnection connection = null;

    private Connection con;


private orclConnection(){

    Properties conProperties = new Properties();
    try {

        conProperties.load(new FileInputStream("data/connection.porperties") );

            String url =conProperties.getProperty("url");
            String user = conProperties.getProperty("user");
            String password = conProperties.getProperty("password");

             con = DriverManager.getConnection(url, user, password);
                System.out.println("connected...");
        } catch (IOException | SQLException e) {
        System.out.println(e.getMessage());
            }

    }
    public static orclConnection getInstance(){
        if(connection == null){
            connection = new orclConnection();
        }
        return connection;
    }
    public ResultSet executeQuery(String sql){
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return rs;
    }
    public int executeUpdate(String sql){
        int res = 0;
        Statement st = null;
        try {
            st = con.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
