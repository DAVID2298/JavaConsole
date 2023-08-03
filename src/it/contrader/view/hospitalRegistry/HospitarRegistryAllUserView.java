package it.contrader.view.hospitalRegistry;

import it.contrader.controller.Request;
import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.dto.UserDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.HospitalRegistryService;
import it.contrader.view.AbstractView;

import java.util.List;

public class HospitarRegistryAllUserView extends AbstractView {


    private HospitalRegistryService hospitalRegistryService;
    private Request request;
    private String choice;
    private final String mode = "READALL";

    public HospitarRegistryAllUserView() {
        hospitalRegistryService = new HospitalRegistryService();
    }

    @Override
    public void showResults(Request request) {
        if (request != null) {
            System.out.println("\n------------------- Profilo utente ----------------\n");
            System.out.println("Nome|\tIndirizzo|\tNazione|\tProvincia|\tCittà|\tNazione|");
            System.out.println("----------------------------------------------------\n");
            HospitalRegistryDTO hospitalRegistryDTO = new HospitalRegistryDTO();
            hospitalRegistryDTO = (HospitalRegistryDTO) request.get("hospitalRegistry");
            System.out.println(hospitalRegistryDTO);
            System.out.println("bella a tutti");


            List<HospitalRegistryDTO> hospitalRegistryS =(List<HospitalRegistryDTO>) request.get("hospitalRegistryS");
            for (HospitalRegistryDTO d:hospitalRegistryS) {
                System.out.println(d);
                System.out.println();

            }

        }
    }


    @Override
    public void showOptions () {


    }

    @Override
    public void submit () {
        request = new Request();
        request.put("choice", choice);
        request.put("mode", "GETCHOICE");
        MainDispatcher.getInstance().callAction("HospitalRegistry", "doControl", request);
    }


}