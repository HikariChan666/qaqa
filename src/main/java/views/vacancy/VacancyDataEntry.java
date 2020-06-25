package views.vacancy;

import dao.ProfessionDao;
import dao.VacancyDao;
import dao.impls.ProfessionDaoImpl;
import dao.impls.VacancyDaoImpl;
import model.Profession;
import model.Vacancy;
import views.HomePage;

import java.util.Scanner;

public class VacancyDataEntry {
    VacancyDao vacancyDao = new VacancyDaoImpl();
    ProfessionDao professionDao = new ProfessionDaoImpl();
    public VacancyDataEntry() throws Exception {
        System.out.println();
        System.out.println("              ┌────────────────────────────────────────────┐             ");
        System.out.println("              |             Додавання вакансії             |             ");
        System.out.println("              └────────────────────────────────────────────┘             ");

        System.out.println("Введіть назву вакансії : ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Введіть вимоги:");
        String requirements = new Scanner(System.in).nextLine();
        System.out.println("Введіть телефон рекрутера:");
        String telephone = new Scanner(System.in).nextLine();
        System.out.println("Введіть назву компанії:");
        String companyName = new Scanner(System.in).nextLine();
        System.out.println("Введіть місто:");
        String city = new Scanner(System.in).nextLine();
        System.out.println("Введіть зарплату:");
        String salary = new Scanner(System.in).nextLine();
        System.out.println("Введіть ID професії:");
        String professionId = new Scanner(System.in).next();
        try {
            Profession profession = professionDao.getById(Integer.parseInt(professionId));
            Vacancy vacancy = new Vacancy();
            vacancy.setName(name);
            vacancy.setRequirements(requirements);
            vacancy.setRecruterPhone(telephone);
            vacancy.setNameOfCompany(companyName);
            vacancy.setCity(city);
            vacancy.setSalary(Double.parseDouble(salary));
            vacancy.setProfession(profession);
            vacancyDao.saveVacancy(vacancy);
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