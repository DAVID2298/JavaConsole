package it.contrader.dao;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Prenotazione;
import it.contrader.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrenotazioneDAO {
    private final String QUERY_ALL = "SELECT * FROM prenotazione";
    private final String QUERY_CREATE = "INSERT INTO prenotazione (id_prenotazione, data," +
            "orario,costo,id_user,id_visita) VALUES (?,?,?,?.?.?)";
    private final String QUERY_READ = "SELECT * FROM prenotazione WHERE id_prenotazione=?";
    private final String QUERY_UPDATE = "UPDATE prenotazione SET id_prenotazione=?,data=?," +
            "orario=?,costo=?,id_user=?,id_visita=? WHERE id_prenotazione=?";
    private final String QUERY_DELETE = "DELETE FROM prenotazione WHERE id_prenotazione=?";

    public PrenotazioneDAO() {

    }
    public List<Prenotazione> getAll() {
        List<Prenotazione> prenotazionesList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            Prenotazione prenotazione;
            while (resultSet.next()) {
                int id_prenotazione = resultSet.getInt("id_prenotazione");
                String data = resultSet.getString("data");
                String orario = resultSet.getString("orario");
                double costo = resultSet.getDouble("costo");
                int id_user = resultSet.getInt("id_user");
                int id_visita = resultSet.getInt("id_visita");

                prenotazione = new Prenotazione( id_prenotazione,data, orario,costo,id_user,id_visita);
                prenotazione.setId_prenotazione(id_prenotazione);
                prenotazionesList.add(prenotazione);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prenotazionesList;
    }
    public boolean insert(Prenotazione prenotazioneToInsert) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
            preparedStatement.setInt(1, prenotazioneToInsert.getId_prenotazione());
            preparedStatement.setString(2, prenotazioneToInsert.getData());
            preparedStatement.setString(3, prenotazioneToInsert.getOrario());
            preparedStatement.setDouble(4, prenotazioneToInsert.getCosto());
            preparedStatement.setInt(5, prenotazioneToInsert.getId_user());
            preparedStatement.setInt(6, prenotazioneToInsert.getId_visita());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public Prenotazione read(int prenotazioneId_prenotazione) {
        Connection connection = ConnectionSingleton.getInstance();
        try {


            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
            preparedStatement.setInt(1, prenotazioneId_prenotazione);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String data,orario;
            double costo;

            data = resultSet.getString("data");
            orario = resultSet.getString("orario");
            costo = resultSet.getDouble("costo");
            Prenotazione prenotazione = new Prenotazione(data, orario, costo);
            prenotazione.setId_prenotazione(resultSet.getInt("id_prenotazione"));

            return prenotazione;
        } catch (SQLException e) {
            return null;
        }

    }

    public boolean update(Prenotazione prenotazioneToUpdate) {
        Connection connection = ConnectionSingleton.getInstance();

        // Check if id is present
        if (prenotazioneToUpdate.getId_prenotazione() == 0)
            return false;

        Prenotazione prenotazioneRead = read(prenotazioneToUpdate.getId_prenotazione());
        if (!prenotazioneRead.equals(prenotazioneToUpdate)) {
            try {
                // Fill the userToUpdate object
                if (prenotazioneToUpdate.getData() == null || prenotazioneToUpdate.getData().equals("")) {
                    prenotazioneToUpdate.setData(prenotazioneRead.getData());
                }

                if (prenotazioneToUpdate.getCosto() == 0 || prenotazioneToUpdate.getCosto() == 0) {
                    prenotazioneToUpdate.setCosto(prenotazioneRead.getCosto());
                }


                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
                preparedStatement.setInt(1, prenotazioneToUpdate.getId_prenotazione());
                preparedStatement.setString(2, prenotazioneToUpdate.getData());
                preparedStatement.setString(3, prenotazioneToUpdate.getOrario());
                preparedStatement.setDouble(4, prenotazioneToUpdate.getCosto());
                preparedStatement.setInt(5, prenotazioneToUpdate.getId_user());
                preparedStatement.setInt(6, prenotazioneToUpdate.getId_visita());
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

    public boolean delete(int id_prenotazione) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, id_prenotazione);
            int n = preparedStatement.executeUpdate();
            if (n != 0)
                return true;

        } catch (SQLException e) {
        }
        return false;
    }


}


