package it.contrader.dao;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.MedicalExamination;
import it.contrader.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicalExaminationDAO {


    private final String QUERY_ALL = "SELECT * FROM visita";
    private final String QUERY_CREATE = "INSERT INTO visita (id_visita, nome, tipologia, costo, codice, orari, img) VALUES (?,?,?,?,?,?,?)";
    private final String QUERY_READ = "SELECT * FROM visita WHERE id_visita=?";
    private final String QUERY_UPDATE = "UPDATE visita SET nome=?, tipologia=?, costo=?, codice=?, orari=?, img=? WHERE id_visita=?";
    private final String QUERY_DELETE = "DELETE FROM visita WHERE id_visita=?";

    public MedicalExaminationDAO(){

    }

    public List<MedicalExamination> getAll(){

        List<MedicalExamination> medicalExaminationList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            MedicalExamination medicalExamination;
            while (resultSet.next()){

                long id = resultSet.getLong("id_visita");
                String name = resultSet.getString("nome");
                String typology = resultSet.getString("tipologia");
                double cost = resultSet.getDouble("costo");
                long code = resultSet.getLong("codice");
                String hour = resultSet.getString("orari");
                String img = resultSet.getString("img");
                medicalExamination = new MedicalExamination(name, typology, cost, code, hour, img);
                medicalExamination.setId(id);
                medicalExaminationList.add(medicalExamination);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return medicalExaminationList;
    }

    public boolean insert (MedicalExamination medicalExaminationToInsert){

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
            preparedStatement.setLong(1, medicalExaminationToInsert.getId());
            preparedStatement.setString(2, medicalExaminationToInsert.getName());
            preparedStatement.setString(3, medicalExaminationToInsert.getTypology());
            preparedStatement.setDouble(3, medicalExaminationToInsert.getCost());
            preparedStatement.setLong(3, medicalExaminationToInsert.getCode());
            preparedStatement.setString(3, medicalExaminationToInsert.getHours());
            preparedStatement.setString(3, medicalExaminationToInsert.getImg());
            preparedStatement.execute();
            return true;
        }catch (SQLException e){
            return false;
        }
    }

    public MedicalExamination read(long id) {
        Connection connection = ConnectionSingleton.getInstance();
        try {


            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String name, typology, hours, img;
            double cost;
            long code;

            name = resultSet.getString("nome");
            typology = resultSet.getString("tipologia");
            cost = resultSet.getDouble("costo");
            code = resultSet.getLong("codice");
            hours = resultSet.getString("orari");
            img = resultSet.getString("img");
            MedicalExamination medicalExamination = new MedicalExamination(name, typology, cost, code, hours, img);
            medicalExamination.setId(resultSet.getLong("id_visita"));

            return medicalExamination;
        } catch (SQLException e) {
            return null;
        }

    }

    public boolean update(MedicalExamination medicalExaminationToUpdate) {
        Connection connection = ConnectionSingleton.getInstance();

        if (medicalExaminationToUpdate.getId() == 0)
            return false;

        MedicalExamination medicalExaminationread = read(medicalExaminationToUpdate.getId());
        if (!medicalExaminationread.equals(medicalExaminationToUpdate)) {
            try {

                if (medicalExaminationToUpdate.getName() == null || medicalExaminationToUpdate.getName().equals("")) {
                    medicalExaminationToUpdate.setName(medicalExaminationread.getName());
                }

                if (medicalExaminationToUpdate.getTypology() == null || medicalExaminationToUpdate.getTypology().equals("")) {
                    medicalExaminationToUpdate.setTypology(medicalExaminationread.getTypology());
                }

                if (medicalExaminationToUpdate.getCost() == 0) {
                    medicalExaminationToUpdate.setCost(medicalExaminationread.getCost());
                }

                if (medicalExaminationToUpdate.getCode() == 0){
                    medicalExaminationToUpdate.setCode(medicalExaminationread.getCode());
                }

                if (medicalExaminationToUpdate.getHours() == null || medicalExaminationToUpdate.getHours().equals("")){
                    medicalExaminationToUpdate.setHours(medicalExaminationread.getHours());
                }

                if (medicalExaminationToUpdate.getImg() == null || medicalExaminationToUpdate.getImg().equals("")){
                    medicalExaminationToUpdate.setHours(medicalExaminationread.getHours());
                }

                PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
                preparedStatement.setString(1, medicalExaminationToUpdate.getName());
                preparedStatement.setString(2, medicalExaminationToUpdate.getTypology());
                preparedStatement.setDouble(3, medicalExaminationToUpdate.getCost());
                preparedStatement.setLong(4, medicalExaminationToUpdate.getCode());
                preparedStatement.setString(5, medicalExaminationToUpdate.getHours());
                preparedStatement.setString(6, medicalExaminationToUpdate.getImg());
                int a = preparedStatement.executeUpdate();
                if (a > 0)
                    return true;
                else
                    return false;

            } catch (SQLException e) {
                return false;
            }
        }

        return false;

    }

    public boolean delete(long id) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setLong(1, id);
            int n = preparedStatement.executeUpdate();
            if (n != 0)
                return true;

        } catch (SQLException e) {
        }
        return false;
    }

}
