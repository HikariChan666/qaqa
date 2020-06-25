package templates;
import model.Employee;
import java.util.List;
public class EmployeeTemplate {
    public static void  Grid(List<Employee> EmployeeList){
        System.out.println("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("┃  Id  |      Прізвище      ┃    Ім'я      ┃      По батькові    ┃    Номер телефону   ┃     e-mail    ┃     Вакансія    ┃");
        System.out.println("┃────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┃");
        for (Employee employee : EmployeeList ){
            System.out.println("| "+ employee.getId() + "  |  " + employee.getSurname() +"  |  " + employee.getFirstname() +  "  |  " + employee.getPatronymic() + "  |  " + employee.getPhone() + "  |  " + employee.getEmail()  + "  |  "  + employee.getVacancy().getName() + "  |");
        }
        System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
        System.out.println();
    }
}
