package dao.impls;

import dao.EmployeeDao;
import dao.VacancyDao;
import db.MySQLConnection;
import model.Employee;
import model.Profession;
import model.Vacancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static db.MySQLConnection.DATABASE_URL;

public class EmployeeDaoImpl implements EmployeeDao {
    VacancyDao vacancyDao= new VacancyDaoImpl();

    @Override
    public void saveEmployee(Employee employee) {
        try(Connection connection = DriverManager.getConnection(DATABASE_URL,"root","1234")){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO employed  VALUES (NULL, ?,?,?,?,?,?)");{
                statement.setString(1,employee.getSurname());
                statement.setString(2,employee.getFirstname());
                statement.setString(3,employee.getPatronymic());
                statement.setString(4,employee.getPhone());
                statement.setString(5,employee.getEmail());
                statement.setInt(6,employee.getVacancy().getId());
                int rows = statement.executeUpdate();
                System.out.println(rows);
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public Employee getById(int id) {
        Employee employee = null;
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "1234");
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employed where id = ?")){
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                String surname = resultSet.getString(2);
                String firstname = resultSet.getString(3);
                String patronymic = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String email = resultSet.getString(6);
                Vacancy vacancy = vacancyDao.getById(resultSet.getInt(7));
                employee = new Employee(id, surname, firstname, patronymic, phone, email, vacancy);}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }
    @Override
        public List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<Employee>();
        try(Connection connection= DriverManager.getConnection(DATABASE_URL,"root","1234");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employed")) {
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int id= resultSet.getInt(1);
                String surname = resultSet.getString(2);
                String firstname = resultSet.getString(3);
                String patronymic = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String email = resultSet.getString(6);
                Vacancy vacancy = vacancyDao.getById(resultSet.getInt(7));
                Employee employee = new Employee(id, surname, firstname, patronymic, phone, email, vacancy);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();} catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }
    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "1234");
             PreparedStatement statement = connection.prepareStatement("DELETE  FROM employed WHERE id=?")) {
            statement.setInt(1,id);
            int rows = statement.executeUpdate();
            System.out.println("Deleted:" + rows);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void update(Employee employee) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "1234");
             PreparedStatement statement = connection.prepareStatement("UPDATE employed SET surname=?,firstname=?,patronymic=?,phone=?,email=?,vacancy_id=?  WHERE id=?")) {
            statement.setString(1,employee.getSurname());
            statement.setString(2,employee.getFirstname());
            statement.setString(3,employee.getPatronymic());
            statement.setString(4,employee.getPhone());
            statement.setString(5,employee.getEmail());
            statement.setInt(6,employee.getVacancy().getId());
            statement.setInt(7,employee.getId());
            int rows = statement.executeUpdate();
            System.out.println("Додано рядків:" + rows);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

