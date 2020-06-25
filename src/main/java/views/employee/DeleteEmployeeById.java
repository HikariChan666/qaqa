package views.employee;

import dao.EmployeeDao;
import dao.impls.EmployeeDaoImpl;
import views.HomePage;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployeeById {
    EmployeeDao employeeDao = new EmployeeDaoImpl();

    public DeleteEmployeeById() throws Exception {
        System.out.println();
        System.out.println("              ┌────────────────────────────────────────────┐             ");
        System.out.println("              |         Видалення робітника по ID          |             ");
        System.out.println("              └────────────────────────────────────────────┘             ");

        System.out.println("Введіть ID робітника: ");
        String employeeId = new Scanner(System.in).next();

        try{
            employeeDao.delete(Integer.parseInt(employeeId));
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
