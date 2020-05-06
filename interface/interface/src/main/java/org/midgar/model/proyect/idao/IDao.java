package org.midgar.model.proyect.idao;

import org.midgar.model.proyect.idto.IDto;
import org.midgar.model.util.container.List;

public interface IDao {
    boolean insert(IDto dto);

    boolean update(IDto dto);

    boolean delete(IDto dto);

    IDto getById(IDto dto);

    List<IDto> getAll();
}