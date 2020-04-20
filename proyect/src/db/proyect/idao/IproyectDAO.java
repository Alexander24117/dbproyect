package db.proyect.idao;

public interface IproyectDAO {
    public boolean insert(IproyectDAO dto);

    public boolean update(IproyectDAO dto);

    public boolean delete(IproyectDAO dto);

    public IproyectDAO getById(IproyectDAO dto);

}
