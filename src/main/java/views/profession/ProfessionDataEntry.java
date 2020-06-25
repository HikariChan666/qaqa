package views.profession;

import dao.ProfessionDao;
import dao.impls.ProfessionDaoImpl;
import model.Profession;
import views.HomePage;

import java.util.Scanner;

public class ProfessionDataEntry {
    ProfessionDaoImpl professionDao = new ProfessionDaoImpl();

    public ProfessionDataEntry() throws Exception {
        System.out.println();
        System.out.println("              ┌────────────────────────────────────────────┐             ");
        System.out.println("              |             Додавання професії             |             ");
        System.out.println("              └────────────────────────────────────────────┘             ");

        System.out.println("Введіть назву : ");
        String name_tmp = new Scanner(System.in).nextLine();

        try {
            Profession profession = new Profession();
            profession.setName(name_tmp);
            professionDao.saveProfession(profession);
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