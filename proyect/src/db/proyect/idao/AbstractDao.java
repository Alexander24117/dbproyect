package db.proyect.idao;

import db.util.container.Container;
import db.connections.*;
import db.proyect.idto.IDto;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;



public abstract class AbstractDao<T extends IDto> implements IDao {

    protected OracleConnection con;
    private final Class<T> entityClass;


    public AbstractDao(Class<T> entityClass) {
        this.con = OracleConnection.getInstance();
        this.entityClass = entityClass;
    }

    @Override
    public boolean insert(IDto dto) {
        return con.executeUpdate(dto.insert()) > 0;

    }

    @Override
    public boolean update(IDto dto) {
        return con.executeUpdate(dto.update()) > 0;
    }

    @Override
    public boolean delete(IDto dto) {
        return con.executeUpdate(dto.delete()) > 0;
    }

    @Override
    public IDto getById(IDto dto) {
        T newObject = newObject();
        ResultSet rs = con.executeQuery(dto.findById());
        try {
            while (rs.next()){
                dataForObject(rs, newObject);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    return newObject;
    }

    @Override
    public Container<IDto> getAll() {
        ResultSet rs = con.executeQuery(newObject().findById());
        Container<IDto> allData = new Container<>();
        try {
            while (rs.next()){
                T newObject = dataForObject(rs,newObject());
                allData.add(newObject);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allData;
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
    private String getNameSet(String columnName) {
        while (columnName.indexOf("_") > 0) {
            int pos = columnName.indexOf("_");
            columnName = columnName.substring(0, pos) +
                    setFirstLetterToUpperCase(columnName.substring(pos + 1));
        }
        return "set" + setFirstLetterToUpperCase(columnName);
    }
    private String setFirstLetterToUpperCase(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
}
