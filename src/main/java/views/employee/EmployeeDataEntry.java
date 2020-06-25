package views.employee;

import dao.EmployeeDao;
import dao.VacancyDao;
import dao.impls.EmployeeDaoImpl;
import dao.impls.VacancyDaoImpl;
import model.Employee;
import model.Vacancy;
import views.HomePage;

import java.util.Scanner;

public class EmployeeDataEntry {
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    VacancyDao vacancyDao = new VacancyDaoImpl();

    public EmployeeDataEntry() throws Exception {
        System.out.println();
        System.out.println("              ┌────────────────────────────────────────────┐             ");
        System.out.println("              |             Додавання робітника            |             ");
        System.out.println("              └────────────────────────────────────────────┘             ");

        System.out.println("Введіть прізвище: ");
        String surname = new Scanner(System.in).nextLine();
        System.out.println("Введіть ім'я:");
        String firstname = new Scanner(System.in).nextLine();
        System.out.println("Введіть по-батькові:");
        String patronymic = new Scanner(System.in).nextLine();
        System.out.println("Ввежіть телефон:");
        String phone = new Scanner(System.in).nextLine();
        System.out.println("Введіть email:");
        String email = new Scanner(System.in).nextLine();
        System.out.println("Введіть ID вакансії:");
        String vacancyId = new Scanner(System.in).nextLine();

        try {
            Vacancy vacancy = vacancyDao.getById(Integer.parseInt(vacancyId));
            Employee employee = new Employee();
            employee.setSurname(surname);
            employee.setFirstname(firstname);
            employee.setPatronymic(patronymic);
            employee.setPhone(phone);
            employee.setEmail(email);
            employee.setVacancy(vacancy);
            employeeDao.saveEmployee(employee);
        } catch (Exception e) {
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