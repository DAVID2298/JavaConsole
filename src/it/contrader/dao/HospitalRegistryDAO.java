package it.contrader.dao;

import it.contrader.main.ConnectionSingleton;
import it.contrader.main.UserSingleton;
import it.contrader.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalRegistryDAO {

    public HospitalRegistryDAO() {
    }

    private final String QUERY_CREATE = "INSERT INTO anagrafica_hospital (nome, indirizzo, nazione, provincia, citta, descrizione, user_id) VALUES (?,?,?,?,?,?,?)";
    private final String QUERY_READ_USER = "SELECT * FROM anagrafica_hospital WHERE user_id=?";
    private final String QUERY_READ_USER_HOSPITAL= "SELECT *"
                                                    + "from user u join User_Anagrafico ua ON u.User_id = ua.User_Id"
                                                    + "where u.User_Id = ?";
    private final String QUERY_ALL = "SELECT * FROM anagrafica_hospital";

    private final String QUERY_DELETE = "delete user from user where user_id = ?";

    private  final String QUERY_INSERT = "INSERT INTO visita(nome, tipologia, costo, ID_visita, orari) VALUES (?,?,?,?,?)";

    private final String QUERY_UPDATE="update anagrafica_hospital set nome = ?, indirizzo = ?, nazione = ?, provincia = ?, citta = ?, descrizione = ? where user_id = ?";
    private final String QUERY_REGISTRY="select id_anagrafica, user_id from anagrafica_hospital where user_id = ?";



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

    public List<HospitalRegistry> getAll() {
        List<HospitalRegistry> usersList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            User user;
            while (resultSet.next()) {
                int id = resultSet.getInt("id_anagrafica");
                String name = resultSet.getString("nome");
                String address = resultSet.getString("indirizzo");
                String nation = resultSet.getString("nazione");
                String province = resultSet.getString("provincia");
                String city = resultSet.getString("citta");
                String description = resultSet.getString("descrizione");
                int userId= resultSet.getInt("user_id");
                HospitalRegistry userRegistry = new HospitalRegistry(id,name, address, nation,province,city,description,userId);
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

    public void insertMedicalExamination(MedicalExamination medicalExamination) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, medicalExamination.getName());
            preparedStatement.setString(2, medicalExamination.getTypology());
            preparedStatement.setDouble(3, medicalExamination.getCost());
            preparedStatement.setDouble(4, medicalExamination.getCode());
            preparedStatement.setString(5, medicalExamination.getHours());
            preparedStatement.setString(6, medicalExamination.getImg());
            preparedStatement.execute();

        } catch (SQLException e) {

        }

    }

    public HospitalRegistry read(long hRegistry){

        Connection connection= ConnectionSingleton.getInstance();
        try{

            PreparedStatement preparedStatement= connection.prepareStatement(QUERY_READ_USER);
            preparedStatement.setLong(1,hRegistry);
            ResultSet resultSet= preparedStatement.executeQuery();
            resultSet.next();
            String name, address, nation,province, city, description;
            int id, userId;
            userId = UserSingleton.getInstance().getUserLogged().getId();
            id = resultSet.getInt("id_anagrafica");
            name= resultSet.getString("nome");
            address= resultSet.getString("indirizzo");
            nation= resultSet.getString("nazione");
            province=resultSet.getString("provincia");
            city=resultSet.getString("citta");
            description = resultSet.getString("descrizione");
            HospitalRegistry hospitalRegistry= new HospitalRegistry(name, address,nation,province, city, description);
            hospitalRegistry.setId(resultSet.getInt("id_anagrafica"));
            hospitalRegistry.setUser_id(userId);
            return hospitalRegistry;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public int readId(int userId){
        Connection connection= ConnectionSingleton.getInstance();
        try{

            PreparedStatement preparedStatement= connection.prepareStatement(QUERY_REGISTRY);
            preparedStatement.setLong(1,userId);
            ResultSet resultSet= preparedStatement.executeQuery();
            resultSet.next();
            int id;
            id = resultSet.getInt("id_anagrafica");
            return id;

        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public boolean update(HospitalRegistry userRegistryToUpdate){
        Connection connection= ConnectionSingleton.getInstance();
        if(userRegistryToUpdate.getId()==0){
            return false;
        }
        HospitalRegistry userRegistryRead = read(userRegistryToUpdate.getUser_id());
        if (!userRegistryRead.equals(userRegistryToUpdate)){
            try{
                if (userRegistryToUpdate.getName()==null||userRegistryToUpdate.getName().equals("")){
                    userRegistryToUpdate.setName(userRegistryRead.getName());
                }
                if (userRegistryToUpdate.getAddress()==null||userRegistryToUpdate.getAddress().equals("")){
                    userRegistryToUpdate.setAddress(userRegistryRead.getAddress());
                }
                if (userRegistryToUpdate.getNation()==null||userRegistryToUpdate.getNation().equals("")){
                    userRegistryToUpdate.setNation(userRegistryRead.getNation());
                }
                if (userRegistryToUpdate.getProvince()==null||userRegistryToUpdate.getProvince().equals("")){
                    userRegistryToUpdate.setProvince(userRegistryRead.getProvince());
                }
                if (userRegistryToUpdate.getCity()==null||userRegistryToUpdate.getCity().equals("")){
                    userRegistryToUpdate.setCity(userRegistryRead.getCity());
                }
                if (userRegistryToUpdate.getDescription()==null||userRegistryToUpdate.getDescription().equals("")){
                    userRegistryToUpdate.setDescription(userRegistryRead.getDescription());
                }


                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);

                preparedStatement.setString(1, userRegistryToUpdate.getName());
                preparedStatement.setString(2, userRegistryToUpdate.getAddress());
                preparedStatement.setString(3, userRegistryToUpdate.getNation());
                preparedStatement.setString(4, userRegistryToUpdate.getProvince());
                preparedStatement.setString(5, userRegistryToUpdate.getCity());
                preparedStatement.setString(6, userRegistryToUpdate.getDescription());
                preparedStatement.setLong(7,userRegistryToUpdate.getUser_id());
                int a= preparedStatement.executeUpdate();
                if (a > 0)
                    return true;
                else
                    return false;

            }catch (SQLException e){
                return false;
            }
        }
        return false;
    }



}
