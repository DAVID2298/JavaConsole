package it.contrader.controller;

import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.dto.UserDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.main.UserSingleton;
import it.contrader.service.MedicalExaminationService;
import it.contrader.service.UserRegistryService;

import java.util.List;

public class MEController implements Controller{


    private static String sub_package = "medicalE.";

    private MedicalExaminationService medicalExaminationService;
    private UserRegistryService userRegistryService;


    public MEController()  {
        this.medicalExaminationService = new MedicalExaminationService();
        this.userRegistryService=new UserRegistryService();

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
        long userId;

        switch (mode) {

            case "INSERT":
                System.out.println("sono qui ciao");
                id = Long.parseLong(request.get("id").toString());
                name = request.get("name").toString();
                typology = request.get("typology").toString();
                cost = Double.parseDouble(request.get("cost").toString());
                code = Long.parseLong(request.get("code").toString());
                hours = request.get("hours").toString();
                img = request.get("img").toString();
                MedicalExaminationDTO medicalExaminationDTO = new MedicalExaminationDTO(id,name,typology,cost,code,hours,img);
                medicalExaminationService.insert(medicalExaminationDTO);
                request = new Request();
                request.put("mode","mode");
                MainDispatcher.getInstance().callView(sub_package + "MEInsert", request);
                break;

            case "DELETE":
                id = Integer.parseInt(request.get("id").toString());
                //Qui chiama il service
                medicalExaminationService.delete(id);
                request = new Request();
                request.put("mode", "mode");
                MainDispatcher.getInstance().callView(sub_package + "MEDelete", request);
                break;


            case "MODIFICA":
                System.out.println("sono qui");
                id= Long.parseLong(request.get("id").toString());
                name=request.get("name").toString();
                typology=request.get("typology").toString();
                cost=Double.parseDouble(request.get("cost").toString());
                code= Long.parseLong(request.get("code").toString());
                hours= request.get("hours").toString();
                img=request.get("img").toString();
                userId=UserSingleton.getInstance().getUserLogged().getId();
                MedicalExaminationDTO medicalExaminationUpdate =new MedicalExaminationDTO(id,name,typology,cost,code,hours,img,userId);
                System.out.println(medicalExaminationUpdate);
                medicalExaminationService.update(medicalExaminationUpdate);
                request = new Request();
                request.put("mode",medicalExaminationUpdate );
                MainDispatcher.getInstance().callView(sub_package + "MEModifica", request);
                System.out.println(medicalExaminationUpdate);
                break;

            case "STATISTICA":
                MainDispatcher.getInstance().callView(sub_package + "MEStatistic", null);
                break;
            case "STATISTIC":
                System.out.println("ciao ciao");
                String type=request.get("typology").toString();
                System.out.println("ciao 2");
                int statistica=medicalExaminationService.statistic(type);
                request=new Request();
                request.put("mode", mode);
                request.put("statistica", statistica);
                MainDispatcher.getInstance().callView( sub_package+"MEStatistic", request);
                break;

            case "PONTE":
                MainDispatcher.getInstance().callView(sub_package+"MedicalEF",null);

            case "FILTRO":

                id = Long.parseLong(request.get("id").toString());

                MedicalExaminationDTO datiAnagraficiDTO=medicalExaminationService.search((int) id);
                request.put("medicalExaminationS",datiAnagraficiDTO);
                MainDispatcher.getInstance().callView(sub_package + "MedicalEF",request);
                break;




//debug
            case "MEDICALEXAMINATIONLIST":
                List<MedicalExaminationDTO> medicalExaminationDTOS = medicalExaminationService.getAll();
                //Impacchetta la request con la lista degli user
                request.put("medicalExaminationS", medicalExaminationDTOS);
                MainDispatcher.getInstance().callView("MedicalExamination", request);
                break;




            //Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
            //con REQUEST NULL (vedi una View specifica)
            case "GETCHOICE":

                //toUpperCase() mette in maiuscolo la scelta
                switch (choice.toUpperCase()) {

                    case "L":
                        MainDispatcher.getInstance().callView(sub_package + "UserRead", null);
                        break;

                    case "I":
                        MainDispatcher.getInstance().callView(sub_package + "MEInsert", null);
                        break;

                    case "M":
                        MainDispatcher.getInstance().callView(sub_package + "MEModifica", null);
                        break;

                    case "C":
                        MainDispatcher.getInstance().callView(sub_package + "MEDelete", null);
                        break;


                    case "E":
                        MainDispatcher.getInstance().callView("Login", null);
                        break;

                    case "B":
                        MainDispatcher.getInstance().callView("HomeAdmin", null);
                        break;

                    case "V":
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
