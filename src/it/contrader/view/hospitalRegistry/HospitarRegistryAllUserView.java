package it.contrader.view.hospitalRegistry;

import it.contrader.controller.Request;
import it.contrader.dto.UserDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.HospitalRegistryService;
import it.contrader.view.AbstractView;

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
            System.out.println("Nome|\tCognome|\tIndirizzo|\tData di nascita'|");
            System.out.println("----------------------------------------------------\n");
            UserRegistryDTO userRegistryDTO = new UserRegistryDTO();
            userRegistryDTO = (UserRegistryDTO) request.get("userRegistry");
            System.out.println(userRegistryDTO);

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

