package it.contrader.view.appointment;

import it.contrader.controller.Request;

import it.contrader.dto.AppointmentDTO;
import it.contrader.dto.UserDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

import java.util.List;


public class AppointmentListView extends AbstractView {

    private int id;
    private Request request;
    private final String mode = "READ";

    public AppointmentListView() {
    }




    @Override
    public void showResults(Request request) {


        if (request != null) {
            System.out.println("\n------------------- Prenotazioni ----------------\n");
            System.out.println("ID\tUsername\tPassword\tTipo Utente");
//            System.out.println("----------------------------------------------------\n");

            @SuppressWarnings("unchecked")
            List<AppointmentDTO> appointmentRegistryS = (List<AppointmentDTO>) request.get("appointmentRegistryS");
            for (AppointmentDTO d : appointmentRegistryS) {
                System.out.println(d);
                System.out.println();
            }


        }


    }

    @Override
    public void showOptions() {

    }

    @Override
    public void submit() {

    }
}