package it.contrader.controller;

import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.MedicalExamination;
import it.contrader.service.HospitalRegistryService;
import it.contrader.service.UserService;

import java.util.List;

public class MedicalExaminationController implements Controller{


    private static String sub_package = "medicalE.";

    private UserService userService;
    private HospitalRegistryService hospitalRegistryService;

    public MedicalExaminationController()  {
        this.userService = new UserService();
        this.hospitalRegistryService= new HospitalRegistryService();
    }



    /**
     * Metodo dell'interfaccia Controller. Estrae dalla request la mode
     * (che riceve dalle view specifiche e pu� essere la richesta di una
     * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
     *
     * Se la modalit� corrisponde ad una CRUD il controller chiama i service,
     * altrimenti rimanda alla View della CRUD per richiedere i parametri
     */
    @Override
    public void doControl(Request request) {


        //Estrae dalla request mode e choice
        String mode = (String) request.get("mode");

        String choice = (String) request.get("choice");

        //Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
        long id;
        String name;
        String typology;
        double cost;
        long code;
        String hours;
        String img;

        switch (mode) {

            case "INSERT":
                id = Long.parseLong(request.get("id").toString());
                name = request.get("name").toString();
                typology = request.get("typology").toString();
                cost = Double.parseDouble(request.get("cost").toString());
                code = Long.parseLong(request.get("code").toString());
                hours = request.get("hours").toString();
                img = request.get("img").toString();
                MedicalExaminationDTO medicalExaminationDTO = new MedicalExaminationDTO(id,name,typology,cost,code,hours,img);
                hospitalRegistryService.insert(medicalExaminationDTO);
                request = new Request();
                request.put("mode", "mode");
                MainDispatcher.getInstance().callView(sub_package + "MedicalExaminationView", request);
                break;

            case "READ":



            //Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
            //con REQUEST NULL (vedi una View specifica)
            case "GETCHOICE":

                //toUpperCase() mette in maiuscolo la scelta
                switch (choice.toUpperCase()) {

                    case "L":
                        MainDispatcher.getInstance().callView(sub_package + "UserRead", null);
                        break;

                    case "I":
                        MainDispatcher.getInstance().callView(sub_package + "UserInsert", null);
                        break;

                    case "M":
                        MainDispatcher.getInstance().callView(sub_package + "UserUpdate", null);
                        break;

                    case "C":
                        MainDispatcher.getInstance().callView(sub_package + "UserDelete", null);
                        break;

                    case "E":
                        MainDispatcher.getInstance().callView("Login", null);
                        break;

                    case "B":
                        MainDispatcher.getInstance().callView("HomeAdmin", null);
                        break;

                    case "T":
                        MainDispatcher.getInstance().callView("MedicalExamination", null);
                        break;

                    default:
                        MainDispatcher.getInstance().callView("Login", null);
                }

            default:
                MainDispatcher.getInstance().callView("Login", null);
        }
    }
}
