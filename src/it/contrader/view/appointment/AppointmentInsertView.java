package it.contrader.view.appointment;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Appointment;
import it.contrader.view.AbstractView;

public class AppointmentInsertView extends AbstractView {

    private Request request;
    private long id;
    private String date;
    private String hour;
    private double cost;
    private long user_id;
    private long medicalExaminationId;
    private final String mode = "INSERT";

    public AppointmentInsertView() {

    }

    @Override
    public void showResults(Request request) {
        if (request != null) {
            System.out.println("Inserimento andato a buon fine.\n");


            if (request.get("register").toString().equals("true")) {
                MainDispatcher.getInstance().callView("Login", null);

            } else {
                MainDispatcher.getInstance().callView("HomeUser", null);

            }



        }
    }

    @Override
    public void showOptions() {
        System.out.println("Inserisci id");
        id= Integer.parseInt(getInput());
        System.out.println("Inserisci la data della prenotazione:");
        date = getInput();
        System.out.println("Inserisci l'ora della prenotazione");
        hour = getInput();
        System.out.println("Inserisci il costo della prenotazione");
        cost = Double.parseDouble(getInput());
//        System.out.println("Inserisci user_id");
//        user_id = Long.parseLong(getInput());
        System.out.println("Inserisci id_visita");
        medicalExaminationId=Long.parseLong(getInput());

    }

    @Override
    public void submit() {
        request = new Request();
        request.put("date", date);
        request.put("hour", hour);
        request.put("cost", cost);
        request.put("id",id);
        request.put("medicalExaminationId",medicalExaminationId);

        request.put("register", "false");
        request.put("mode",mode);

        MainDispatcher.getInstance().callAction("Appointment", "doControl", request);

    }

}