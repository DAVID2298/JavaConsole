package it.contrader.controller;

import it.contrader.main.MainDispatcher;

public class LandingController implements Controller {
    public LandingController() {
    }

    public void doControl (Request request) {

        if (request!=null){
            String choice=request.get("choice").toString();

            switch (choice.toLowerCase()){
                case "a":
                    MainDispatcher.getInstance().callView("Login", null);
                    break;
                case "r":
                    MainDispatcher.getInstance().callView("user."+"UserInsert", null);
                    break;
                default:
                    MainDispatcher.getInstance().callView("Landing", null);
            }
        }
        /**
         * Attraverso il Dispatcher va alla pagina di autenticazione
         */
        MainDispatcher.getInstance().callView("Landing", null);
    }

}