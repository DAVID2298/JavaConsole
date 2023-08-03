package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.HospitalRegistryService;

import java.util.List;

public class HospitalRegistryView extends AbstractView {


    private Request request;
    private String choice;


    public HospitalRegistryView() {

    }

    @Override
    public void showResults(Request request) {


    }

    @Override
    public void showOptions(){
        System.out.println("          Scegli l'operazione da effettuare:");
        System.out.println("[I]inserisci dati clinica [M]odifica clinica [E]sci");

        this.choice = getInput();

    }


    @Override
    public void submit() {
        request = new Request();
        request.put("choice", choice);
        request.put("mode", "GETCHOICE");
        MainDispatcher.getInstance().callAction("HospitalRegistry", "doControl", this.request);
    }

}

