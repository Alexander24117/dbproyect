package org.midgar.model.proyect.idao;

import org.midgar.model.connections.OracleConnection;
import org.midgar.model.proyect.idto.IDto;
import org.midgar.model.util.container.List;

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
            while (rs.next()) {
                dataForObject(rs, newObject);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return newObject;
    }

    @Override
    public List<IDto> getAll() {
        ResultSet rs = con.executeQuery(newObject().findAll());
        List<IDto> allData = new List<>();
        try {
            while (rs.next()) {
                T newObject = newObject();
                dataForObject(rs, newObject);
                allData.add(newObject);
            }
        } catch (SQLException e) {
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
                String nameMethodSet1 = getNameSet(metaData.getColumnName(i));

                Method methodToExecute1 = entityClass.getMethod(nameMethodSet1, Class.forName(metaData.getColumnClassName(i)));
                methodToExecute1.invoke(newObject, rs.getObject(i));


            }




        } catch (Exception e) {
            e.printStackTrace();
        }
        return newObject;
    }

    private String getNameSet(String columnName) {
        columnName = columnName.toLowerCase();
        return "set" + setFirstLetterToUpperCase(columnName);
    }

    private String setFirstLetterToUpperCase(String word) {

        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
}
