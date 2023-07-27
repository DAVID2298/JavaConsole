package it.contrader.converter;

import it.contrader.dto.AppointmentDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Appointment;
import it.contrader.model.User;

import java.util.ArrayList;
import java.util.List;

public class AppointmentConverter {

    public AppointmentDTO toDTO(Appointment appointment){
        AppointmentDTO appointmentDTO= new AppointmentDTO(
                appointment.getId(),
                appointment.getDate(),
                appointment.getHour(),
                appointment.getCost(),
                appointment.getUser_id(),
                appointment.getMedical_booking_id()
        );
        return appointmentDTO;
    }

    public Appointment toEntity(AppointmentDTO appointmentDTO){
        Appointment appointment= new Appointment(
                appointmentDTO.getId(),
                appointmentDTO.getDate(),
                appointmentDTO.getHour(),
                appointmentDTO.getCost(),
                appointmentDTO.getUser_id(),
                appointmentDTO.getMedical_booking_id()
        );
        return appointment;
    }

    public List<AppointmentDTO> toDTOList(List<Appointment> appointmentList) {
        //Crea una lista vuota.
        List<AppointmentDTO> appointmentDTOList = new ArrayList<AppointmentDTO>();

        //Cicla tutti gli elementi della lista e li converte uno a uno
        for(Appointment appointment : appointmentList) {
            //Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
            //e lo aggiunge adda lista di DTO
            appointmentDTOList.add(toDTO(appointment));
        }
        return appointmentDTOList;
    }


}
