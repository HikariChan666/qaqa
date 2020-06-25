package views.employee;

import dao.EmployeeDao;
import dao.impls.EmployeeDaoImpl;
import model.Employee;
import templates.EmployeeTemplate;
import views.HomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeList {
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    public EmployeeList() throws Exception {
        System.out.println();
        System.out.println("              ┌────────────────────────────────────────────┐             ");
        System.out.println("              |              Список вакансій               |             ");
        System.out.println("              └────────────────────────────────────────────┘             ");
        List<Employee> employeesList = new ArrayList<Employee>();
        try{
            employeesList = employeeDao.getEmployees();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!employeesList.isEmpty()){
            EmployeeTemplate.Grid(employeesList);
        }else{
            System.out.println("Інформації не знайдено!");
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