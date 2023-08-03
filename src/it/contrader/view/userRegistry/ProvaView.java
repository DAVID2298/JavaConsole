package it.contrader.view.userRegistry;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

    public class ProvaView extends AbstractView {

        private Request request;

        private long id;
        private String name;
        private String surname;
        private String address;
        private String dateBirthday;
        private long userId;
        private final String mode="UPDATE";


        public ProvaView(){}


        @Override
        public void showResults(Request request) {
            if(request!=null){
                System.out.println("Inserimento andato a buon fine \n");
                MainDispatcher.getInstance().callView("UserRegistry",null);
            }
        }

        @Override
        public void showOptions() {
            try {
                System.out.println("Inserisci nome dell'utente:");
                name = getInput();
                System.out.println("Inserisci cognome dell'utente:");
                surname = getInput();
                System.out.println("Inserisci indirizzo dell'utente:");
                address = getInput();
                System.out.println("Inserisci data di nascita dell'utente:");
                dateBirthday = getInput();


            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }



        @Override
        public void submit() {
            request = new Request();
//            request.put("id",id);
            request.put("name",name);
            request.put("surname",surname);
            request.put("address",address);
            request.put("dateBirthday",dateBirthday);
            request.put("userId",userId);
            request.put("mode",mode);
            MainDispatcher.getInstance().callAction("UserRegistry","doControl",request);

        }
    }
