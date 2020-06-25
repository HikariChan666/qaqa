package views.employee;

import dao.EmployeeDao;
import dao.impls.EmployeeDaoImpl;
import model.Employee;
import views.HomePage;

import java.sql.SQLException;
import java.util.Scanner;

public class FindEmployeeById {
    EmployeeDao employeeDao = new EmployeeDaoImpl();

    public FindEmployeeById() throws Exception {
        System.out.println();
        System.out.println("              ┌────────────────────────────────────────────┐                  ");
        System.out.println("              |           Пошук робітника по ID            |                 ");
        System.out.println("              └────────────────────────────────────────────┘                 ");

        System.out.println("Введіть ID робітника: ");
        String id = new Scanner(System.in).next();

        try{
            Employee employee = employeeDao.getById(Integer.parseInt(id));
            System.out.println("┌────────────────────────────────────────────┐");
            System.out.println("┃Id  |    Прізвище  |     Вакансія           ┃");
            System.out.println("┃────────────────────────────────────────────┃");
            System.out.println("| "+ employee.getId() + "   |   "+ employee.getSurname() +"   |   " + employee.getVacancy().getName() +"|");
            System.out.println("└────────────────────────────────────────────┘");
            System.out.println();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.print("Повернутись до головного меню: (y)Так - (n)Ні");
        String backToMenu = new Scanner(System.in).next();
        while(!(backToMenu.equals("y") || backToMenu.equals("n")))
        {
            System.out.print("Помилка \n");
            System.out.print("Повернутись до головного меню: (y)Так - (n)Ні:");
            backToMenu = new Scanner(System.in).next();
        }
        if(backToMenu.equals("y")){
            HomePage.displayMenu();
        }else{
            System.exit(0);
        }
    }
}