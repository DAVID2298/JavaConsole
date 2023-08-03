package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.dto.AppointmentDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;

import java.util.List;

public class AppointmentView extends AbstractView {

    private String choice;

    private Request request;


    @Override
    public void showResults(Request request) {
        if (request != null){
            System.out.println("\n------------------- Profilo utente ----------------\n");
            System.out.println("id\tdata\tora\tcosto\tuser_id\tid_visita");
            System.out.println("----------------------------------------------------\n");
            @SuppressWarnings("unchecked")
            List<AppointmentDTO> appointments =(List<AppointmentDTO>) request.get("appointments");
            for (AppointmentDTO d:appointments) {
                System.out.println(d);
                System.out.println();

            }
        }
    }

    @Override
    public void showOptions() {

        System.out.println("---------PRENOTAZIONI----------");
        System.out.println("Seleziona l'operazione");
        System.out.println("[L]eggi [I]nserisci [V]isualizza storico prenotazioni [C]ancella [E]sci");

        choice = this.getInput();

    }

    @Override
    public void submit() {

        request = new Request();
        request.put("choice", choice);
        request.put("mode", "GETCHOICE");
        MainDispatcher.getInstance().callAction("Appointment" , "doControl", request);

    }
}