package it.contrader.dao;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.UserRegistry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRegistryDAO {

    private final String QUERY_ALL= "SELECT * FROM user_anagrafico";
    private final String QUERY_CREATE= "INSERT INTO user_anagrafico (nome, cognome, indirizzo, data_di_nascita,user_id) VALUES (?,?,?,?,?)";
    private final String QUERY_READ= "SELECT * FROM user_anagrafico WHERE user_id=?";
    private final String QUERY_UPDATE= "UPDATE user_anagrafico SET nome=?, cognome=?, indirizzo=?, data_di_nascita=? WHERE User_id=?";
    private final String QUERY_DELETE= "DELETE from user WHERE id=?";
    private final String QUERY_DELETEBYIDUSER= "DELETE user_anagrafico FROM user_anagrafico JOIN user ON user_anagrafico.User_Id = user.idWHERE user.id = ?";
    private final String QUERY_REGISTRY="select id_anagrafica, user_id from user_anagrafico where user_id = ?";
    public UserRegistryDAO() {
    }

    public List<UserRegistry> getAll(){
        List<UserRegistry> userRegistries=new ArrayList<>();


        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            UserRegistry userRegistry;
            while (resultSet.next()) {
                int id = resultSet.getInt("id_anagrafica");
                String name = resultSet.getString("nome");
                String surname = resultSet.getString("cognome");
                String address = resultSet.getString("indirizzo");
                String date_birthday=resultSet.getString("data_di_nascita");
                int user_id = resultSet.getInt("user_id");

                userRegistry= new UserRegistry(id,name,surname,address,date_birthday,user_id);
                userRegistry.setUserId(user_id);
                userRegistry.setId(id);
                userRegistries.add(userRegistry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRegistries;
    }

    public boolean insert(UserRegistry userRegistry){
        Connection connection= ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement= connection.prepareStatement(QUERY_CREATE);
            preparedStatement.setString(1, userRegistry.getName());
            preparedStatement.setString(2, userRegistry.getSurname());
            preparedStatement.setString(3, userRegistry.getAddress());
            preparedStatement.setString(4, userRegistry.getBirthDate());
            preparedStatement.setLong(5, userRegistry.getUserId());
            preparedStatement.execute();
            return true;

        }catch(SQLException e){
            return false;
        }
    }

    public UserRegistry read(long uRegistry){
        Connection connection= ConnectionSingleton.getInstance();
        try{

            PreparedStatement preparedStatement= connection.prepareStatement(QUERY_READ);
            preparedStatement.setLong(1,uRegistry);
            ResultSet resultSet= preparedStatement.executeQuery();
            resultSet.next();
            String name, surname, address,date_of_birth;
            int userId;
            name= resultSet.getString("nome");
            surname= resultSet.getString("cognome");
            address= resultSet.getString("indirizzo");
            date_of_birth=resultSet.getString("Data_Di_Nascita");
            userId=resultSet.getInt("User_Id");
            UserRegistry userRegistry= new UserRegistry(name,surname,address,date_of_birth);
            userRegistry.setId(resultSet.getInt("id_anagrafica"));
            userRegistry.setUserId(userId);
            return userRegistry;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean update(UserRegistry userRegistryToUpdate){
        Connection connection= ConnectionSingleton.getInstance();
        if(userRegistryToUpdate.getId()==0){
            return false;
        }
        UserRegistry userRegistryRead = read(userRegistryToUpdate.getUserId());
        if (!userRegistryRead.equals(userRegistryToUpdate)){
            try{
                if (userRegistryToUpdate.getName()==null||userRegistryToUpdate.getName().equals("")){
                    userRegistryToUpdate.setName(userRegistryRead.getName());
                }
                if (userRegistryToUpdate.getSurname()==null||userRegistryToUpdate.getSurname().equals("")){
                    userRegistryRead.setSurname(userRegistryRead.getSurname());
                }

                if (userRegistryToUpdate.getAddress()==null||userRegistryToUpdate.getAddress().equals("")){
                    userRegistryToUpdate.setAddress(userRegistryRead.getAddress());
                }
                if (userRegistryToUpdate.getBirthDate()==null||userRegistryToUpdate.getBirthDate().equals("")){
                    userRegistryToUpdate.setBirthDate(userRegistryRead.getBirthDate());
                }


                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);

                preparedStatement.setString(1, userRegistryToUpdate.getName());
                preparedStatement.setString(2, userRegistryToUpdate.getSurname());
                preparedStatement.setString(3, userRegistryToUpdate.getAddress());
                preparedStatement.setString(4, userRegistryToUpdate.getBirthDate());
                preparedStatement.setLong(5,userRegistryToUpdate.getUserId());
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

    public int readId(int userId){
        Connection connection= ConnectionSingleton.getInstance();
        try{

            PreparedStatement preparedStatement= connection.prepareStatement(QUERY_REGISTRY);
            preparedStatement.setLong(1,userId);
            ResultSet resultSet= preparedStatement.executeQuery();
            resultSet.next();
            int id;
//            userRegistry.getId(resultSet.getInt("id_anagrafica"));
            id = resultSet.getInt("id_anagrafica");
            return id;

        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }





}
