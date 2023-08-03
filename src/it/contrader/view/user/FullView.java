package it.contrader.view.user;

import it.contrader.controller.Request;

import it.contrader.dto.UserDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

import java.util.List;


public class FullView extends AbstractView {

    private int id;
    private Request request;
    private final String mode = "READ";

    public FullView() {
    }




    @Override
    public void showResults(Request request) {


        if (request != null) {
            System.out.println("\n------------------- Gestione utenti ----------------\n");
            System.out.println("ID\tUsername\tPassword\tTipo Utente");
            System.out.println("----------------------------------------------------\n");

            @SuppressWarnings("unchecked")
            List<UserRegistryDTO> users = (List<UserRegistryDTO>) request.get("user");
            for (UserRegistryDTO u : users)
                System.out.println(u);
            System.out.println();
        }


    }

    @Override
    public void showOptions() {

    }

    @Override
    public void submit() {

    }
}