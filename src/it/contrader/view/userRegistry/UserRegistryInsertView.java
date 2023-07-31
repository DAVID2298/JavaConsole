package it.contrader.view.userRegistry;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class UserRegistryInsertView extends AbstractView {

    private Request request;
    private String name;
    private String surname;
    private String address;
    private String dateBirthday;
    private long userId;
    private final String mode = "INSERT";

    public UserRegistryInsertView() {

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
        System.out.println("sono qui");
        System.out.println("Inserisci nome dell'utente:");
        name = getInput();
        System.out.println("Inserisci cognome dell'utente:");
        surname = getInput();
        System.out.println("Inserisci indirizzo dell'utente:");
        address = getInput();
        System.out.println("Inserisci data di nascita dell'utente:");
        dateBirthday = getInput();
        System.out.println("Inserisci l'Id dell'utente");
        userId= Integer.parseInt(getInput());
        System.out.println();

    }

    @Override
    public void submit() {
        request = new Request();
        request.put("name", name);
        request.put("surname", surname);
        request.put("address", address);
        request.put("dateBirthday", dateBirthday);
        request.put("userId",userId);
        request.put("mode",mode);
        request.put("register", "false");
        MainDispatcher.getInstance().callAction("UserRegistry", "doControl", request);

    }

}
