package it.contrader.dao;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalRegistryDAO {

    public HospitalRegistryDAO() {
    }

    private final String QUERY_CREATE = "INSERT INTO anagrafica_hospital (nome, indirizzo, nazione, provincia, citta, descrizione, user_id) VALUES (?,?,?,?,?,?,?)";
    private final String QUERY_READ_USER = "SELECT * FROM user WHERE id=?";
    private final String QUERY_READ_USER_HOSPITAL= "SELECT *"
                                                    + "from user u join User_Anagrafico ua ON u.User_id = ua.User_Id"
                                                    + "where u.User_Id = ?";
    private final String QUERY_ALL = "SELECT * FROM User_Anagrafico";

    private final String QUERY_DELETE = "delete user from user where user_id = ?";

    private  final String QUERY_INSERT = "INSERT INTO visita(nome, tipologia, costo, ID_visita, orari) VALUES (?,?,?,?,?)";

    private final String QUERY_UPDATE="";



    public boolean insert(HospitalRegistry hospitalRegistry) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
            preparedStatement.setString(1, hospitalRegistry.getName());
            preparedStatement.setString(2, hospitalRegistry.getAddress());
            preparedStatement.setString(3, hospitalRegistry.getNation());
            preparedStatement.setString(4, hospitalRegistry.getProvince());
            preparedStatement.setString(5, hospitalRegistry.getCity());
            preparedStatement.setString(6, hospitalRegistry.getDescription());
            preparedStatement.setLong(7, hospitalRegistry.getUser_id());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<UserRegistry> getAll() {
        List<UserRegistry> usersList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            User user;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cognome = resultSet.getString("cognome");
                String indirizzo = resultSet.getString("indirizzo");
                String data_di_nascita = resultSet.getString("data_di_nascita");
                UserRegistry userRegistry = new UserRegistry(nome, cognome, indirizzo,data_di_nascita);
                userRegistry.setId(id);
                usersList.add(userRegistry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public boolean delete(int id) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, id);
            int n = preparedStatement.executeUpdate();
            if (n != 0)
                return true;

        } catch (SQLException e) {
        }
        return false;
    }

    public void insert(MedicalExamination medicalExamination) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, medicalExamination.getName());
            preparedStatement.setString(2, medicalExamination.getTypology());
            preparedStatement.setDouble(3, medicalExamination.getCost());
            preparedStatement.setDouble(4, medicalExamination.getCode());
            preparedStatement.setString(5, medicalExamination.getHours());
            preparedStatement.setString(5, medicalExamination.getImg());
            preparedStatement.execute();

        } catch (SQLException e) {

        }

    }



}
