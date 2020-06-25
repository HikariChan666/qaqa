package dao;

import model.Vacancy;

import java.sql.SQLException;
import java.util.List;

 public interface VacancyDao {
    void saveVacancy(Vacancy vacancy);
    Vacancy getById(int id) throws SQLException;
    List<Vacancy> getAllVacancies();
    void delete(int id);
    void update(Vacancy vacancy);
}
