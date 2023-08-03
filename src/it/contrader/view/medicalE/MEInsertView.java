package it.contrader.view.medicalE;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MEInsertView extends AbstractView {

    private Request request;

    private long id;

    private String name;

    private String typology;

    private double cost;

    private long code;

    private String hours;

    private String img;

    private final String mode = "INSERT";

    public MEInsertView() {
    }

    /**
     * Se la request non � nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
     * l'esito dell'operazione
     */
    @Override
    public void showResults(Request request) {
        if (request!=null) {
            System.out.println("Inserimento andato a buon fine.\n");
            MainDispatcher.getInstance().callView("HomeAdmin", null);
        }
    }

    /**
     * Chiede all'utente di inserire gli attributi dell'utente da inserire
     */
    @Override
    public void showOptions() {
        System.out.println("Inserisci id della visita:");
        id= Long.parseLong(getInput());
        System.out.println("Inserisci nome della visita:");
        name = getInput();
        System.out.println("Inserisci tipologia della visita:");
        typology = getInput();
        System.out.println("Inserisci costo della visita:");
        cost = Double.parseDouble(getInput());
        System.out.println("Inserisci codice della visita:");
        code = Long.parseLong(getInput());
        System.out.println("Inserisci orario della visita:");
        hours = getInput();
        System.out.println("Inserisci url img della visita:");
        img = getInput();
    }

    /**
     * Impacchetta la request con i dati inseriti nel metodo showOption()
     */
    @Override
    public void submit() {
        request = new Request();
        request.put("id", id);
        request.put("name", name);
        request.put("typology",typology);
        request.put("cost", cost);
        request.put("code", code);
        request.put("hours",hours);
        request.put("img", img);
        request.put("mode", mode);
        MainDispatcher.getInstance().callAction("ME", "doControl", request);
    }

}
