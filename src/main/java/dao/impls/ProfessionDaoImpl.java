package dao.impls;

import com.sun.xml.internal.bind.v2.model.core.ID;
import dao.ProfessionDao;
import db.MySQLConnection;
import model.Profession;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static db.MySQLConnection.DATABASE_URL;

public class ProfessionDaoImpl implements ProfessionDao {
    public void saveProfession(Profession profession){
    try(Connection connection = DriverManager.getConnection(DATABASE_URL,"root","1234")){
        PreparedStatement statement = connection.prepareStatement("INSERT INTO professions  VALUES (NULL, ?)");{
            statement.setString(1, profession.getName());
            int rows = statement.executeUpdate();
            System.out.println(rows);
        }
    }catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
@Override
    public Profession getById(int id) {
        Profession profession = null;
        try(Connection connection= DriverManager.getConnection(DATABASE_URL,"root","1234");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM professions where id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                String name = resultSet.getString(2);
                profession = new Profession(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profession;
    }
    @Override
    public List<Profession> getAllProfessions() {
        List<Profession> professionList = new ArrayList<Profession>();
        try(Connection connection= DriverManager.getConnection(DATABASE_URL,"root","1234");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM professions")) {
            ResultSet resultSet = statement.executeQuery();
                    while(resultSet.next()){
                        int id= resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        Profession profession = new Profession(id, name);
                        professionList.add(profession);
                    }
        } catch (SQLException e) {
            e.printStackTrace();
        } ;
        return professionList;
    }
    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "1234");
             PreparedStatement statement = connection.prepareStatement("DELETE  FROM professions WHERE id=?")) {
        statement.setInt(1,id);
        int rows = statement.executeUpdate();
            System.out.println("Deleted:"+ rows);
    }catch (SQLException e){
        e.printStackTrace();
    }
    }
    @Override
    public void update(Profession profession) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "1234");
             PreparedStatement statement = connection.prepareStatement("UPDATE professions SET name=?  WHERE id=?")) {
            statement.setString(1,profession.getName());
            statement.setInt(2,profession.getId());
            int rows = statement.executeUpdate();
            System.out.println("Додано рядків:" + rows);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
