package org.midgar.model.server;

import org.midgar.model.connections.OracleConnection;
import org.midgar.model.proyect.idto.IDto;
import org.midgar.model.util.container.Container;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ExecuteSql<T extends IDto> {
    protected OracleConnection con;
    private final Class<T> entityClass;

    public ExecuteSql(Class<T> entityClass) {
        this.con = OracleConnection.getInstance();
        this.entityClass = entityClass;
    }


    public IDto getOneOnlyResult(String sql) {
        T newObject = newObject();
        ResultSet rs = con.executeQuery(sql);
        try {
            while (rs.next()) {
                dataForObject(rs, newObject);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return newObject;
    }

    public boolean getExecuteUpdate(String sql) {

        int rs = con.executeUpdate(sql);

        return rs > 0;


    }

    public Container<IDto> getManyResults(String sql) {
        ResultSet rs = con.executeQuery(sql);
        Container<IDto> allData = new Container<>();
        try {
            while (rs.next()) {
                T newObject = newObject();
                dataForObject(rs, newObject);
                allData.add(newObject);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return allData;
    }

    private T dataForObject(ResultSet rs, T newObject) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String nameMethodSet = getNameSet(metaData.getColumnName(i));
                Method methodToExecute = entityClass.getMethod(nameMethodSet, Class.forName(metaData.getColumnClassName(i)));
                methodToExecute.invoke(newObject, rs.getObject(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newObject;
    }

    public T newObject() {
        T newObject = null;
        try {
            newObject = entityClass.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newObject;
    }

    protected Field[] getFields() {
        return entityClass.getFields();
    }

    private String setFirstLetterToUpperCase(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

    private String getNameSet(String columnName) {
        while (columnName.indexOf("_") > 0) {
            int pos = columnName.indexOf("_");
            columnName = columnName.substring(0, pos) +
                    setFirstLetterToUpperCase(columnName.substring(pos + 1));
        }
        return "set" + setFirstLetterToUpperCase(columnName);
    }
}
