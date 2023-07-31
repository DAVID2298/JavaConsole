package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class LandingView extends AbstractView {



    private String choice;

    public void showResults(Request request) {

    }
    /**
     * chiede in input all'utente uno username e una password usando il metodo getInput() presente in AbstractView
     */
    public void showOptions() {

        System.out.println("Benvento");

        System.out.println(" [A]ccedi [R]egistrati");
        this.choice = getInput();


    }

    /**
     * Impacchetta una request (metodo request.put("chiave", valore)) e la manda al controller Home tramite il Dispatcher
     */
    public void submit() {

        Request request = new Request();

        request.put("choice", choice);


        MainDispatcher.getInstance().callAction("Landing", "doControl", request);
    }


}