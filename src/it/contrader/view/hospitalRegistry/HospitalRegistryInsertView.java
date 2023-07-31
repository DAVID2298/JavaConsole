package it.contrader.view.hospitalRegistry;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class HospitalRegistryInsertView extends AbstractView {

    private Request request;
    private String name;
    private String address;
    private String nation;
    private String province;
    private String city;
    private String description;

    private final String mode = "INSERT";

    public HospitalRegistryInsertView() {

    }

    @Override
    public void showResults(Request request) {
        if (request != null) {
            System.out.println("Inserimento andato a buon fine.\n");


            if (request.get("register").toString().equals("true")) {
                MainDispatcher.getInstance().callView("Login", null);

            } else {
                MainDispatcher.getInstance().callView("HomeAdmin", null);

            }


        }

    }

    @Override
    public void showOptions() {
        System.out.println("sono qui");
        System.out.println("Inserisci nome:");
        name = getInput();
        System.out.println("Inserisci indirizzo:");
        address = getInput();
        System.out.println("Inserisci nazione:");
        nation = getInput();
        System.out.println("Inserisci provincia");
        province= getInput();
        System.out.println("Inserisci città");
        city= getInput();
        System.out.println("Inserisci descrizione");
        description= getInput();

    }

    @Override
    public void submit() {
        request = new Request();
        request.put("name", name);
        request.put("address", address);
        request.put("nation",nation);
        request.put("province",province);
        request.put("city",city);
        request.put("description",description);

        request.put("mode",mode);
        request.put("register", "false");
        MainDispatcher.getInstance().callAction("HospitalRegisty", "doControl", request);

    }

}
