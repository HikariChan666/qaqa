package views.profession;

import dao.ProfessionDao;
import dao.impls.ProfessionDaoImpl;
import model.Profession;
import templates.ProfessionTemplate;
import views.HomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfessionList {
    ProfessionDao professionDao = new ProfessionDaoImpl();
    public ProfessionList() throws Exception {
        System.out.println();
        System.out.println("              ┌────────────────────────────────────────────┐             ");
        System.out.println("              |              Список професій               |             ");
        System.out.println("              └────────────────────────────────────────────┘             ");
        List<Profession> professionList = new ArrayList<Profession>();
        try{
            professionList = professionDao.getAllProfessions();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!professionList.isEmpty()){
            ProfessionTemplate.Grid(professionList);
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