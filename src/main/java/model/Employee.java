package model;

public class Employee {
    private int id;
    private String surname;
    private String firstname;
    private String patronymic;
    private String phone;
    private String email;
    private Vacancy vacancy;

    public Employee(int id, String surname, String firstname, String patronymic, String phone, String email, Vacancy vacancy) {
        this.id = id;
        this.surname = surname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.phone = phone;
        this.email = email;
        this.vacancy = vacancy;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    @Override
    public String toString() {
        return "model.Employee{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", vacancy=" + vacancy +
                '}';
    }
}
