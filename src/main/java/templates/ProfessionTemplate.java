package templates;
import model.Profession;
import java.util.List;
public class ProfessionTemplate {
    public static void  Grid(List<Profession>professionList){
        System.out.println();
        System.out.println("┌───────────────────────────────┐");
        System.out.println("┃ Id      |     Професія        ┃");
        System.out.println("┃───────────────────────────────┃");
        for (Profession profession : professionList ){
            System.out.println("| " + profession.getId() + "    |   " + profession.getName() + "    |");
        }
        System.out.println("└───────────────────────────────13┘");
        System.out.println();
    }
}
