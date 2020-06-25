package templates;
import model.Vacancy;
import java.util.List;
public class VacancyTemplate {
    public static void Grid(List<Vacancy>vacancyList){
        System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("┃         Id       |         Вакансія          ┃       Вимоги       ┃      Номер рекрутера      ┃      Назва компанії      ┃       Місто     ┃      Заробітня плата     ┃       Професія     ┃");
        System.out.println("┃──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┃");
        for (Vacancy vacancy : vacancyList ){
            System.out.println("| "+ vacancy.getId() + "  |  " + vacancy.getName() +"  |  " + vacancy.getRequirements() + "  |  " + vacancy.getRecruterPhone() + "  |  " + vacancy.getNameOfCompany() + "  |  " + vacancy.getCity() + "  |  " + vacancy.getSalary() + "  |  " + vacancy.getProfession().getName()+ "  |");
        }
        System.out.println("└──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
        System.out.println();
    }
}
