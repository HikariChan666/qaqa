package dao;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    void saveEmployee(Employee employee);
    Employee getById(int id) throws SQLException;
    List<Employee> getEmployees();
    void delete(int id);
    void update(Employee employee);
}

