package it.contrader.controller;

import it.contrader.converter.HospitalRegistryConverter;
import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;
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
                System.out.println("ciao");
                name=request.get("name").toString();
                address=request.get("address").toString();
                nation=  request.get("nation").toString();
                province=request.get("province").toString();
                city=  request.get("city").toString();
                description= request.get("description").toString();

                userId= Long.parseLong(request.get("userId").toString());
                register=request.get("register").toString();
                HospitalRegistryDTO hospitalRegistryDTO = new HospitalRegistryDTO(name,address,nation,province,city,description,userId);
//            userRegistry.getUserId();
//            user.getId();
//            userRegistryDTO.setUserId(user.getId());
                System.out.println(hospitalRegistryDTO);

                hospitalRegistryService.insert(hospitalRegistryDTO);
                request = new Request();
                request.put("register", register);
                MainDispatcher.getInstance().callView(sub_package + "HospitalRegistryInsert", request);
                break;
//            case "UPDATE":
//                name=request.get("name").toString();
//                address=request.get("address").toString();
//                nation=  request.get("nation").toString();
//                province=request.get("province").toString();
//                city=  request.get("city").toString();
//                description= request.get("description").toString();
//
//                userId= Integer.parseInt(request.get("userId").toString());
//                register=request.get("register").toString();
//                hospitalRegistry.setUser_id(user.getId());
//
//
//                HospitalRegistryDTO hospitalRegistryUpdate =new HospitalRegistryDTO(name,address,nation,province,city,description,userId);
//                hospitalRegistryUpdate.setUser_id(userId);
//                hospitalRegistryService.update(hospitalRegistryUpdate);
//                request = new Request();
//                request.put("mode", "mode");
//                MainDispatcher.getInstance().callView(sub_package + "HospitalRegistryUpdate", request);
//                break;


            case "HOSPITALREGISTRYLIST":
                List<UserRegistryDTO> userRegistryDTOS = userRegistryService.getAll();
                //Impacchetta la request con la lista degli user
                request.put("userRegistryDTOS", userRegistryDTOS);
                MainDispatcher.getInstance().callView(sub_package + "HospitalRegistryAllUser", request);
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
                        MainDispatcher.getInstance().callView(sub_package + "UserRegistryUpdate", null);
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
