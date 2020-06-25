package model;

public class Vacancy {
    private int id;
    private String name;
    private String requirements;
    private String recruterPhone;
    private String nameOfCompany;
    private String city;
    private double salary;
    private Profession profession;

    public Vacancy(int id, String name, String requirements, String recruterPhone, String nameOfCompany, String city, double salary, Profession profession) {
        this.id = id;
        this.name = name;
        this.requirements = requirements;
        this.recruterPhone = recruterPhone;
        this.nameOfCompany = nameOfCompany;
        this.city = city;
        this.salary = salary;
        this.profession = profession;
    }

    public Vacancy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getRecruterPhone() {
        return recruterPhone;
    }

    public void setRecruterPhone(String recruterPhone) {
        this.recruterPhone = recruterPhone;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "model.Vacancy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", requirements='" + requirements + '\'' +
                ", recruterPhone='" + recruterPhone + '\'' +
                ", nameOfCompany='" + nameOfCompany + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                ", profession=" + profession +
                '}';
    }
}
