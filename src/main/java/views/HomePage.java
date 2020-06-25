package views;
import dao.EmployeeDao;
import dao.ProfessionDao;
import dao.impls.EmployeeDaoImpl;
import dao.impls.ProfessionDaoImpl;
import model.Employee;
import model.Profession;
import templates.EmployeeTemplate;
import templates.ProfessionTemplate;
import views.employee.*;
import views.profession.*;
import views.vacancy.*;

import java.util.List;
import java.util.Scanner;

public class HomePage {
    public static void main(String[]args) throws Exception{
        displayMenu();
    }
    public static void displayMenu() throws Exception{
        System.out.println();
        System.out.println("◤▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔◥");
        System.out.println("║         Довідник центру зайнятості           ║");
        System.out.println("▶═════════════════════════════════════════════◀");
        System.out.println("║       Меню:                                  ║");
        System.out.println("║  1. Додати робітника                         ║");
        System.out.println("║  2. Знайти робітника по ID                   ║");
        System.out.println("║  3. Видалити робітника по ID                 ║");
        System.out.println("║  4. Вивести список робітників                ║");
        System.out.println("║  5. Оновити інформацію про робітника         ║");
        System.out.println("║  6. Додати професію                          ║");
        System.out.println("║  7. Оновити інформацію про професії          ║");
        System.out.println("║  8. Вивести список професій                  ║");
        System.out.println("║  9. Видалити професію                        ║");
        System.out.println("║  10. Знайти професію                         ║");
        System.out.println("║  11. Додати вакансію                         ║");
        System.out.println("║  12. Знайти вакансію                         ║");
        System.out.println("║  13. Видалити вакансію                       ║");
        System.out.println("║  14. Вивести список вакансій                 ║");
        System.out.println("║  15. Оновити інформацію про вакансії         ║");
        System.out.println("◣_____________________________________________◢");
        System.out.println();
        System.out.println("Оберіть пункт меню:");
        String option = new Scanner(System.in).next();
        while (!(option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4") || option.equals("5") || option.equals("6")
                || option.equals("7") || option.equals("8") || option.equals("9") || option.equals("10")
                || option.equals("11") || option.equals("12") || option.equals("13") || option.equals("14") || option.equals("15"))){
            System.out.println("Помилка!");
            System.out.println("Оберіть ще раз");
        }
        switch (option) {
            case "1": {
                new EmployeeDataEntry();
                break;
            }
            case "2": {
                new FindEmployeeById();
                break;
            }
            case "3":{
                new DeleteEmployeeById();
                break;
            }
            case "4":{
                new EmployeeList();
                break;
            }
            case "5": {
                new UpdateEmployeeData();
                break;
            }
            case "6":{
                new ProfessionDataEntry();
                break;
            }
            case "7":{
                new UpdateProfessionData();
                break;
            }
            case "8":{
                new ProfessionList();
                break;
            }
            case "9":{
                new DeleteProfessionById();
                break;
            }
            case "10":{
                new FindProfessionById();
                break;
            }
            case "11": {
                new VacancyDataEntry();
                break;
            }
            case "12":{
                new FindVacancyById();
                break;
            }
            case "13":{
                new DeleteVacancyById();
                break;
            }
            case "14":{
                new VacancyList();
                break;
            }
            case "15":{
                new UpdateVacancyData();
                break;
            }

        }
    }
}

