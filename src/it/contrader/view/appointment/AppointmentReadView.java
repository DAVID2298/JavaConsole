package it.contrader.view.appointment;

import it.contrader.controller.Request;
import it.contrader.dto.AppointmentDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

import java.util.List;

public class AppointmentReadView extends AbstractView {
    private int id;
    private Request request;
    private final String mode = "READ";

    @Override
    public void showResults(Request request) {

        if (request != null) {
            AppointmentDTO appointment = (AppointmentDTO) request.get("appointment");
            System.out.println(appointment);
            MainDispatcher.getInstance().callView("Appointment", null);
        }

    }

    @Override
    public void showOptions() {
        System.out.println("Inserisci l'ID della prenotazione");
        id = Integer.parseInt(getInput());
    }

    @Override
    public void submit() {
        request = new Request();
        request.put("id", id);
        request.put("mode", mode);
        MainDispatcher.getInstance().callAction("Appointment", "doControl", request);

    }
}
