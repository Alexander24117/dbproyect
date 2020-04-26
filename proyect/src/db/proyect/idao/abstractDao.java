package db.proyect.idao;
import db.connection.*;
import db.proyect.idto.IDto;


import java.util.*;
import java.sql.*;


public abstract class  abstractDao implements IDao {

    private orclConnection con;
    public abstractDao(){
        con= orclConnection.getInstance();
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
    public IDao getById(IDto dto) {
        return null;
    }
}
