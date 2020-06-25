package views.profession;

import dao.ProfessionDao;
import dao.impls.ProfessionDaoImpl;
import model.Profession;
import views.HomePage;

import java.util.Scanner;

public class UpdateProfessionData {
    ProfessionDao professionDao = new ProfessionDaoImpl();

    public UpdateProfessionData() throws Exception{
        System.out.println();
        System.out.println("              ┌────────────────────────────────────────────────────┐        ");
        System.out.println("              |         Оновлення інформації про професії          |        ");
        System.out.println("              └────────────────────────────────────────────────────┘        ");

        System.out.println("Введіть назву професії: ");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Введіть ID професії для оновлення: ");
        String professionId = new Scanner(System.in).next();

        try{
            Profession profession = professionDao.getById(Integer.parseInt(professionId));
            profession.setName(name);
            profession.setId(Integer.parseInt(professionId));
            professionDao.update(profession);
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