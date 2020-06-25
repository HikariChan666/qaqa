package views.vacancy;

import dao.ProfessionDao;
import dao.VacancyDao;
import dao.impls.ProfessionDaoImpl;
import dao.impls.VacancyDaoImpl;
import model.Profession;
import model.Vacancy;
import views.HomePage;

import java.util.Scanner;

public class UpdateVacancyData {
    VacancyDao vacancyDao = new VacancyDaoImpl();
    ProfessionDao professionDao = new ProfessionDaoImpl();

    public UpdateVacancyData() throws Exception{
        System.out.println();
        System.out.println("              ┌────────────────────────────────────────────────────┐        ");
        System.out.println("              |         Оновлення інформації про вакансії          |        ");
        System.out.println("              └────────────────────────────────────────────────────┘        ");

        System.out.println("Введіть назву вакансії: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Введіть вимоги:");
        String requirements = new Scanner(System.in).nextLine();
        System.out.println("Введыть телефон рекрутера:");
        String telephone = new Scanner(System.in).nextLine();
        System.out.println("Введіть назву компанії:");
        String companyName = new Scanner(System.in).nextLine();
        System.out.println("Введіть місто:");
        String city = new Scanner(System.in).nextLine();
        System.out.println("Введіть зарплату:");
        String salary = new Scanner(System.in).nextLine();
        System.out.println("Введіть ID професії:");
        String professionId = new Scanner(System.in).next();
        System.out.println("Введіть ID вакансії для оновлення: ");
        String vacancyId = new Scanner(System.in).next();

        try{
            Vacancy vacancy = vacancyDao.getById(Integer.parseInt(vacancyId));
            Profession profession = professionDao.getById(Integer.parseInt(professionId));
            vacancy.setName(name);
            vacancy.setRequirements(requirements);
            vacancy.setRecruterPhone(telephone);
            vacancy.setNameOfCompany(companyName);
            vacancy.setSalary(Double.parseDouble(salary));
            vacancy.setCity(city);
            vacancy.setProfession(profession);
            vacancy.setId(Integer.parseInt(vacancyId));
            vacancyDao.update(vacancy);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.print("Повернутись до головного меню: (y)Так - (n)Ні");
        String backToMenu = new Scanner(System.in).next();
        while(!(backToMenu.equals("y") || backToMenu.equals("n")))
        {
            System.out.print("Неправильний вибір \n");
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