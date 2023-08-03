package it.contrader.view.medicalE;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MEStatisticView extends AbstractView {

    private Request request;
    private String type;

    private final String mode= "STATISTIC";

    @Override
    public void showResults(Request request) {
        if (request != null) {
            System.out.println("\n------------------- Statistiche ----------------\n");


            @SuppressWarnings("unchecked")
            int statistica =  (int)request.get("statistica");

            System.out.println("Visite prenotate: "+statistica);
            System.out.println();
            MainDispatcher.getInstance().callView("HomeAdmin", null);
        }

    }

    @Override
    public void showOptions() {
        try {
//
            System.out.println("Inserisci tipologia :");
            type = getInput();

        } catch (Exception e) {

        }
    }

    @Override
    public void submit() {
        request = new Request();
        request.put("typology",type);
        request.put("mode",mode);
        MainDispatcher.getInstance().callAction("ME","doControl",request);
    }
}
