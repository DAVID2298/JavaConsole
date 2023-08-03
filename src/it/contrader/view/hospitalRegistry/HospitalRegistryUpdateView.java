package it.contrader.view.hospitalRegistry;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class HospitalRegistryUpdateView extends AbstractView {

    private Request request;
    private long id;
    private String name;
    private String address;
    private String nation;
    private String province;
    private String city;
    private String description;
    private long userId;
    private final String mode = "UPDATE";

    HospitalRegistryUpdateView(){

    }



    @Override
    public void showResults(Request request) {
        if(request!=null){
            System.out.println("Inserimento andato a buon fine \n");
            MainDispatcher.getInstance().callView("HospitalRegistry",null);
        }
    }

    @Override
    public void showOptions() {
        try {
//                System.out.println("inserisci id");
//                id=Long.parseLong(getInput());
            System.out.println("Inserisci nome della clinica:");
            name = getInput();
            System.out.println("Inserisci indirizzo della clinica:");
            address = getInput();
            System.out.println("Inserisci nazione della clinica:");
            nation = getInput();
            System.out.println("Inserisci provincia della clinica:");
            province = getInput();
            System.out.println("Inserisci città della clinica:");
            city = getInput();
            System.out.println("Inserisci descrizione della clinica:");
            description = getInput();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



    @Override
    public void submit() {
        request = new Request();
//            request.put("id",id);
        request.put("name",name);
        request.put("address",address);
        request.put("nation",nation);
        request.put("province",province);
        request.put("city",city);
        request.put("description",description);
        request.put("mode",mode);
        MainDispatcher.getInstance().callAction("HospitalRegistry","doControl",request);

    }
}
