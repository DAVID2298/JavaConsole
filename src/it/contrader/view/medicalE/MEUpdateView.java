package it.contrader.view.medicalE;

import it.contrader.controller.Request;
import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MEUpdateView extends AbstractView {

    private Request request;

    private long id;

    private String name;

    private String typology;

    private double cost;

    private long code;

    private String hours;

    private String img;

    private long userId;

    private final String mode = "UPDATE";

    public MEUpdateView(){

    }

    /**
     * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
     * l'esito dell'operazione
     */
    @Override
    public void showResults(Request request) {
        if (request!=null) {
            System.out.println("Modifica andata a buon fine.\n");
            MainDispatcher.getInstance().callView("MedicalExamination", null);
        }
    }

    /**
     * Chiede all'utente di inserire gli attributi dell'utente da modificare
     */
    @Override
    public void showOptions() {
        try {
//            System.out.println("Inserisci id della visita da modificare:");
//            id = Long.parseLong(getInput());
            System.out.println("Inserisci nome della visita :");
            name = getInput();
            System.out.println("Inserisci tipologia della visita :");
            typology = getInput();
            System.out.println("Inserisci costo:");
            code = Long.parseLong(getInput());
            System.out.println("Inserisci codice:");
            code = Long.parseLong(getInput());
            System.out.println("Inserisci orario :");
            hours = getInput();
            System.out.println("Inserisci img :");
            img = getInput();

        } catch (Exception e) {

        }
    }


    /**
     * Impacchetta la request con i dati inseriti nel metodo showOption()
     */

        @Override
        public void submit() {
            request = new Request();
            request.put("name",name);
            request.put("typology",typology);
            request.put("cost",cost);
            request.put("code",code);
            request.put("hours",hours);
            request.put("img",img);
            request.put("userId",userId);
            request.put("mode",mode);
            MainDispatcher.getInstance().callAction("ME","doControl",request);

        }
    }



