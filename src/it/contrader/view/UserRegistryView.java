package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;

import java.util.List;

public class UserRegistryView extends AbstractView{

    private Request request;
    private String choice;
    public UserRegistryView(){
    }

    @Override
    public void showResults(Request request) {
        if (request != null){
            System.out.println("\n------------------- Profilo utente ----------------\n");
            System.out.println("Nome\tCognome\tIndirizzo\tData di nascita\tNazionalità");
            System.out.println("----------------------------------------------------\n");
            @SuppressWarnings("unchecked")
            List<UserRegistryDTO> userRegistryS =(List<UserRegistryDTO>) request.get("userRegistryS");
            for (UserRegistryDTO d:userRegistryS) {
                System.out.println(d);
                System.out.println();

            }
        }

    }

    @Override
    public void showOptions() {
        System.out.println("          Scegli l'operazione da effettuare:");
        System.out.println("[L]eggi [I]nserisci [M]odifica [B]ack [E]sci");

        this.choice = getInput();




    }

    @Override
    public void submit() {
        request = new Request();
        request.put("choice", choice);
        request.put("mode", "GETCHOICE");
        MainDispatcher.getInstance().callAction("DatiAnagrafici", "doControl", this.request);



    }
}
