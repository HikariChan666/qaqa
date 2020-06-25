package views.vacancy;

import dao.VacancyDao;
import dao.impls.VacancyDaoImpl;
import model.Vacancy;
import views.HomePage;

import java.sql.SQLException;
import java.util.Scanner;

public class FindVacancyById {
    VacancyDao vacancyDao = new VacancyDaoImpl();

    public FindVacancyById() throws Exception {
        System.out.println();
        System.out.println("              ┌────────────────────────────────────────────┐                  ");
        System.out.println("              |           Пошук вакансії по ID             |                 ");
        System.out.println("              └────────────────────────────────────────────┘                 ");

        System.out.println("Введіть ID вакансії: ");
        String id = new Scanner(System.in).next();

        try{
            Vacancy vacancy = vacancyDao.getById(Integer.parseInt(id));
            System.out.println("┌──────────────────────────────┐");
            System.out.println("┃   Id   |      Вакансія       ┃");
            System.out.println("┃──────────────────────────────┃");
            System.out.println("| "+ vacancy.getId() + "   |   " + vacancy.getName() +"|");
            System.out.println("└──────────────────────────────┘");
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