package views.employee;

import dao.EmployeeDao;
import dao.VacancyDao;
import dao.impls.EmployeeDaoImpl;
import dao.impls.VacancyDaoImpl;
import model.Employee;
import model.Vacancy;
import views.HomePage;

import java.util.Scanner;

public class UpdateEmployeeData {
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    VacancyDao vacancyDao = new VacancyDaoImpl();

    public UpdateEmployeeData() throws Exception{
        System.out.println();
        System.out.println("              ┌────────────────────────────────────────────────────┐        ");
        System.out.println("              |        Оновлення інформації про робітників         |        ");
        System.out.println("              └────────────────────────────────────────────────────┘        ");

        System.out.println("Введіть прізвище: ");
        String surname = new Scanner(System.in).nextLine();
        System.out.println("Введіть ім'я:");
        String firstname = new Scanner(System.in).nextLine();
        System.out.println("Введіть по-батькові:");
        String patronymic = new Scanner(System.in).nextLine();
        System.out.println("Введіть телефон:");
        String phone = new Scanner(System.in).nextLine();
        System.out.println("Введіть email:");
        String email = new Scanner(System.in).nextLine();
        System.out.println("Введіть ID вакансії:");
        String vacancyId = new Scanner(System.in).nextLine();
        System.out.println("Введіть ID робітника для оновлення: ");
        String employeeId = new Scanner(System.in).next();

        try{
            Employee employee = employeeDao.getById(Integer.parseInt(employeeId));
            Vacancy vacancy = vacancyDao.getById(Integer.parseInt(vacancyId));
            employee.setSurname(surname);
            employee.setFirstname(firstname);
            employee.setPatronymic(patronymic);
            employee.setPhone(phone);
            employee.setEmail(email);
            employee.setVacancy(vacancy);
            employee.setId(Integer.parseInt(employeeId));
            employeeDao.update(employee);
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