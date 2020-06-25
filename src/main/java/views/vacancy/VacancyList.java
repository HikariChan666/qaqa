package views.vacancy;

import dao.VacancyDao;
import dao.impls.VacancyDaoImpl;
import model.Vacancy;
import templates.VacancyTemplate;
import views.HomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VacancyList {
    VacancyDao vacancyDao = new VacancyDaoImpl();
    public VacancyList() throws Exception {
        System.out.println();
        System.out.println("              ┌────────────────────────────────────────────┐             ");
        System.out.println("              |              Список вакансій               |             ");
        System.out.println("              └────────────────────────────────────────────┘             ");
        List<Vacancy> vacancyList = new ArrayList<Vacancy>();
        try{
            vacancyList = vacancyDao.getAllVacancies();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!vacancyList.isEmpty()){
            VacancyTemplate.Grid(vacancyList);
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