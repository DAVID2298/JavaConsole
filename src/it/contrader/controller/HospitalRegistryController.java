package it.contrader.controller;

import it.contrader.converter.HospitalRegistryConverter;
import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.main.UserSingleton;
import it.contrader.model.HospitalRegistry;
import it.contrader.model.User;
import it.contrader.model.UserRegistry;
import it.contrader.service.HospitalRegistryService;
import it.contrader.service.UserRegistryService;

import java.util.List;

public class HospitalRegistryController implements Controller {
    private static String sub_package= "hospitalRegistry.";
    private UserRegistryService userRegistryService;
    private HospitalRegistryService hospitalRegistryService;
    private HospitalRegistryConverter hospitalRegistryConverter;

    public HospitalRegistryController(){
        this.userRegistryService= new UserRegistryService();
        this.hospitalRegistryService= new HospitalRegistryService();
        this.hospitalRegistryConverter= new HospitalRegistryConverter();
    }

    @Override
    public void doControl(Request request) {

        String mode =(String) request.get("mode");
        String choice = (String) request.get("choice");

        long id;
        String name;
        String address;
        String nation;
        String province;
        String city;
        String description;
        String register;
        long userId ;


        HospitalRegistry hospitalRegistry = new HospitalRegistry();

        switch (mode){


            case "INSERT":
                System.out.println("sono qui ciao");
                name = request.get("name").toString();
                address = request.get("address").toString();
                nation = request.get("nation").toString();
                province = request.get("province").toString();
                city = request.get("city").toString();
                description = request.get("description").toString();
                userId= UserSingleton.getInstance().getUserLogged().getId();
                HospitalRegistryDTO hospitalRegistryDTO = new HospitalRegistryDTO(name,address,nation,province,city,description,userId);
                hospitalRegistryService.insert(hospitalRegistryDTO);
                request = new Request();
                request.put("mode","mode");
                MainDispatcher.getInstance().callView(sub_package + "HospitalRegistryInsert", request);
                break;
            case "UPDATE":
                System.out.println("sono qui");
                int i = UserSingleton.getInstance().getUserLogged().getId();
                id= hospitalRegistryService.readId(i);
                name=request.get("name").toString();
                address=request.get("address").toString();
                nation= request.get("nation").toString();
                province= request.get("province").toString();
                city= request.get("city").toString();
                description= request.get("description").toString();
                userId=UserSingleton.getInstance().getUserLogged().getId();
                HospitalRegistryDTO hospitalRegistryUpdate =new HospitalRegistryDTO(id,name,address,nation,province,city,description,userId);


                System.out.println(hospitalRegistryUpdate);

                hospitalRegistryService.update(hospitalRegistryUpdate);
                request = new Request();
                request.put("mode",hospitalRegistryService );
                System.out.println(hospitalRegistryUpdate+" aaaa");
                MainDispatcher.getInstance().callView(sub_package + "Modifica", request);
                System.out.println(hospitalRegistryUpdate);
                break;
            case "PROFILO":
                userId = UserSingleton.getInstance().getUserLogged().getId();
                HospitalRegistryDTO hospitalRegistryDTO1 = hospitalRegistryService.read((int) userId);
                request.put("hospitalRegistry", hospitalRegistryDTO1);
                MainDispatcher.getInstance().callView(sub_package + "HospitalRegistryRead", request);
                break;

            case "HOSPITALREGISTRY":

                MainDispatcher.getInstance().callView("HospitalRegistry", request);
                break;
            case "GETCHOICE":

                //toUpperCase() mette in maiuscolo la scelta
                switch (choice.toUpperCase()) {

                    case "L":
                        MainDispatcher.getInstance().callView(sub_package + "UserRegistryRead", null);
                        break;

                    case "I":
                        MainDispatcher.getInstance().callView(sub_package + "HospitalRegistryInsert", null);
                        break;

                    case "M":
                        MainDispatcher.getInstance().callView("hospitalRegistry." + "Modifica",null);
                        break;

                    case "E":
                        MainDispatcher.getInstance().callView("Login", null);
                        break;

                    case "B":
                        MainDispatcher.getInstance().callView("HomeAdmin", null);
                        break;
                    case "X":
                        MainDispatcher.getInstance().callView("UserRegistry", null);
                        break;
                    case "U":
                        MainDispatcher.getInstance().callView(sub_package + "UserRegistry", null);
                        break;
                    case "A":
                        MainDispatcher.getInstance().callView("HospitalRegistry" , null);
                        break;


                    default:
                        MainDispatcher.getInstance().callView("Login", null);
                }
                break;

            default:
                MainDispatcher.getInstance().callView("Login", null);
        }

    }
}
