package views.profession;

import dao.ProfessionDao;
import dao.impls.ProfessionDaoImpl;
import model.Profession;
import views.HomePage;

import java.sql.SQLException;
import java.util.Scanner;

public class FindProfessionById {
    ProfessionDao professionDao = new ProfessionDaoImpl();

    public FindProfessionById() throws Exception {
        System.out.println();
        System.out.println("              ┌────────────────────────────────────────────┐                  ");
        System.out.println("              |           Пошук професії по ID             |                 ");
        System.out.println("              └────────────────────────────────────────────┘                 ");

        System.out.println("Введіть ID професії: ");
        String id = new Scanner(System.in).next();

        try{
            Profession profession = professionDao.getById(Integer.parseInt(id));
            System.out.println("┌─────────────────────────────────────┐");
            System.out.println("┃    Id      |      Професія          ┃");
            System.out.println("┃─────────────────────────────────────┃");
            System.out.println("| "+ profession.getId() + "   |   " + profession.getName() +"|");
            System.out.println("└─────────────────────────────────────┘");
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