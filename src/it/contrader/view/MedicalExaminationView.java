package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;

import java.util.List;

public class MedicalExaminationView extends AbstractView{

    private Request request;
    private String choice;
    public MedicalExaminationView(){
    }


    @Override
    public void showResults(Request request) {
        if (request != null){
            System.out.println("\n------------------- Visite ----------------\n");
            System.out.println("----------------------------------------------------\n");
            @SuppressWarnings("unchecked")
            List<MedicalExaminationDTO> medicalExaminationS =(List<MedicalExaminationDTO>) request.get("medicalExaminationS");
            for (MedicalExaminationDTO d:medicalExaminationS) {
                System.out.println(d);
                System.out.println();

            }
        }

    }

    @Override
    public void showOptions() {
        System.out.println("          Visite      :");
        System.out.println("[L]eggi [I]nserisci Visita [C]ancella [M]odifica [B]ack [E]sci");

        this.choice = getInput();




    }

    @Override
    public void submit() {
        request = new Request();
        request.put("choice", choice);
        request.put("mode", "GETCHOICE");
        MainDispatcher.getInstance().callAction("ME", "doControl", this.request);



    }
}
