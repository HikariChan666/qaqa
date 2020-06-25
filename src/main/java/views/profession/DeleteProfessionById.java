package views.profession;

import dao.ProfessionDao;
import dao.impls.ProfessionDaoImpl;
import views.HomePage;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteProfessionById {
    ProfessionDao professionDao = new ProfessionDaoImpl();

    public DeleteProfessionById() throws Exception {
        System.out.println();
        System.out.println("              ┌────────────────────────────────────────────┐             ");
        System.out.println("              |         Видалення професії по ID           |             ");
        System.out.println("              └────────────────────────────────────────────┘             ");

        System.out.println("Введіть ID професії: ");
        String vacancyId = new Scanner(System.in).next();

        try{
            professionDao.delete(Integer.parseInt(vacancyId));
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
