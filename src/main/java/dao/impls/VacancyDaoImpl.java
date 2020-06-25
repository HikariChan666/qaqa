package dao.impls;

import dao.ProfessionDao;
import dao.VacancyDao;
import db.MySQLConnection;
import model.Employee;
import model.Profession;
import model.Vacancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static db.MySQLConnection.DATABASE_URL;

public class VacancyDaoImpl implements VacancyDao {
    ProfessionDao professionDao = new ProfessionDaoImpl();

    @Override
    public void saveVacancy(Vacancy vacancy) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "1234")) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO vacancies  VALUES (NULL, ?,?,?,?,?,?,?)");
            {
                statement.setString(1, vacancy.getName());
                statement.setString(2,vacancy.getRequirements());
                statement.setString(3,vacancy.getRecruterPhone());
                statement.setString(4,vacancy.getNameOfCompany());
                statement.setString(5,vacancy.getCity());
                statement.setString(6,String.valueOf(vacancy.getSalary()));
                statement.setInt(7,vacancy.getProfession().getId());
                int rows = statement.executeUpdate();
                System.out.println(rows);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Vacancy getById(int id) {
        Vacancy vacancy = null;
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "1234");
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM vacancies where id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(2);
                String requirements = resultSet.getString(3);
                String recruterPhone = resultSet.getString(4);
                String nameOfCompany = resultSet.getString(5);
                String city = resultSet.getString(6);
                Double salary = resultSet.getDouble(7);
                Profession profession = professionDao.getById(resultSet.getInt(8));
                vacancy = new Vacancy(id, name, requirements, recruterPhone, nameOfCompany, city, salary, profession);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return vacancy;
    }
        public List<Vacancy> getAllVacancies () {
            List<Vacancy> vacancies = new ArrayList<>();
            try (Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "1234");
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM vacancies");
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String requirements = resultSet.getString(3);
                    String recruterPhone = resultSet.getString(4);
                    String nameOfCompany = resultSet.getString(5);
                    String city = resultSet.getString(6);
                    Double salary = resultSet.getDouble(7);
                    Profession profession = professionDao.getById(resultSet.getInt(8));
                    Vacancy vacancy = new Vacancy(id, name, requirements, recruterPhone, nameOfCompany, city, salary, profession);
                    vacancies.add(vacancy);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return vacancies;
        }
        public void delete ( int id){
            try (Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "1234");
                 PreparedStatement statement = connection.prepareStatement("DELETE  FROM vacancies WHERE id=?")) {
                statement.setInt(1, id);
                int rows  = statement.executeUpdate();
                System.out.println("Deleted:" + rows);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public void update (Vacancy vacancy){
            try (Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "1234");
                 PreparedStatement statement = connection.prepareStatement("UPDATE vacancies  SET name=?,requirements=?,recruter_phone=?,name_of_company=?,city=?,salary=?,profession_id=?  WHERE id=?")) {
                statement.setString(1, vacancy.getName());
                statement.setString(2,vacancy.getRequirements());
                statement.setString(3,vacancy.getRecruterPhone());
                statement.setString(4,vacancy.getNameOfCompany());
                statement.setString(5,vacancy.getCity());
                statement.setString(6, String.valueOf(vacancy.getSalary()));
                statement.setInt(7,vacancy.getProfession().getId());
                statement.setInt(8, vacancy.getId());
                int rows = statement.executeUpdate();
                System.out.println("Додано рядків:" + rows);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

