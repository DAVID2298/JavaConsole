package it.contrader.service;

import it.contrader.converter.AppointmentConverter;
import it.contrader.dao.AppointmentDAO;
import it.contrader.dto.AppointmentDTO;


import java.util.List;

public class AppointmentService {
    private AppointmentDAO appointmentDAO;
    private AppointmentConverter appointmentConverter;

    public AppointmentService(){
        this.appointmentDAO = new AppointmentDAO();
        this.appointmentConverter = new AppointmentConverter();
    }


    public List<AppointmentDTO> getAll() {
        // Ottiene una lista di entit? e le restituisce convertendole in DTO
        return appointmentConverter.toDTOList(appointmentDAO.getAll());
    }


    public AppointmentDTO read(int id_prenotazione) {
        // Ottiene un'entit? e la restituisce convertendola in DTO
        return appointmentConverter.toDTO(appointmentDAO.read(id_prenotazione));
    }


    public boolean insert(AppointmentDTO dto) {
        // Converte un DTO in entit? e lo passa al DAO per l'inserimento
        return appointmentDAO.insert(appointmentConverter.toEntity(dto));
    }


    public boolean update(AppointmentDTO dto) {
        // Converte un userDTO in entit? e lo passa allo userDAO per la modifica
        return appointmentDAO.update(appointmentConverter.toEntity(dto));
    }


    public boolean delete(int id) {
        // Questo mtodo chiama direttamente il DAO
        return appointmentDAO.delete(id);
    }

}