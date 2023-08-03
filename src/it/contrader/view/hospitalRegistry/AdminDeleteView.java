package it.contrader.view.hospitalRegistry;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class AdminDeleteView extends AbstractView {

    private Request request;

    private int id;
    private final String mode = "DELETE";

    public AdminDeleteView() {
    }



    @Override
    public void showResults(Request request) {
        if (request!=null) {
            System.out.println("Cancellazione andata a buon fine.\n");
            MainDispatcher.getInstance().callView("User", null);}}



    @Override
    public void showOptions() {}

    /**

     impacchetta la request con l'id dell'utente da cancellare*/@Override
    public void submit() {
        request = new Request();
        request.put("id", id);
        request.put("mode", mode);
        MainDispatcher.getInstance().callAction("User", "doControl", request);}
}
