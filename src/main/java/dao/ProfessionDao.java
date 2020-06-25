package dao;

import model.Profession;

import java.sql.SQLException;
import java.util.List;

public interface ProfessionDao {
    void saveProfession(Profession profession);

    Profession getById(int id) throws SQLException;

    List<Profession> getAllProfessions();
    void delete(int id);
    void update(Profession profession);
}
