package db.proyect.idao;

import db.util.container.Container;
import db.proyect.idto.IDto;

public interface IDao {
    boolean insert(IDto dto);

    boolean update(IDto dto);

    boolean delete(IDto dto);

    IDto getById(IDto dto);

    Container<IDto> getAll();
}