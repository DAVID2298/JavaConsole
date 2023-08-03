package it.contrader.view.medicalE;

import it.contrader.controller.Request;
import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.MedicalExamination;
import it.contrader.view.AbstractView;

public class MedicalEFView extends AbstractView {

    private Request request;
    private int id;

    private final String mode= "FILTRO";

    @Override
    public void showResults(Request request) {
        if (request!=null){
            MedicalExaminationDTO medicalExaminationDTO=(MedicalExaminationDTO) request.get("medicalExaminationS");
            System.out.println(medicalExaminationDTO);
            MainDispatcher.getInstance().callView("Login",null);
        }

    }

    @Override
    public void showOptions() {
        try {
//
            System.out.println("Inserisci id :");
            id = Integer.parseInt(getInput());

        } catch (Exception e) {

        }
    }

    @Override
    public void submit() {
        request = new Request();
        request.put("id",id);
        request.put("mode",mode);
        MainDispatcher.getInstance().callAction("ME","doControl",request);
    }
}

