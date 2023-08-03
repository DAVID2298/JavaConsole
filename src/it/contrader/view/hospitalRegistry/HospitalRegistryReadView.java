package it.contrader.view.hospitalRegistry;


import it.contrader.controller.Request;
import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class HospitalRegistryReadView extends AbstractView {

    private Request request;

    private int userId;

    private final String mode= "READ";


    @Override
    public void showResults(Request request) {
        if (request!=null){
            HospitalRegistryDTO hospitalRegistryDTO=(HospitalRegistryDTO) request.get("hospitalRegistry");
            System.out.println(hospitalRegistryDTO);
            MainDispatcher.getInstance().callView("HospitalRegistry",null);
        }

    }

    @Override
    public void showOptions() {

    }

    @Override
    public void submit() {
        request = new Request();
        request.put("userId", userId);
        request.put("mode", mode);
        MainDispatcher.getInstance().callAction("HospitalRegistry", "doControl", request);

    }
}