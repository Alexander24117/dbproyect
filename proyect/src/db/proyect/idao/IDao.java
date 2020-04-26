package db.proyect.idao;

import db.proyect.idto.IDto;

public interface IDao {
    public boolean insert(IDto dto);

    public boolean update(IDto dto);

    public boolean delete(IDto dto);

    public IDao getById(IDto dto);


}